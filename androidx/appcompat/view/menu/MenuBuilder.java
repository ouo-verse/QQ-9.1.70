package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    private Callback mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private MenuItemImpl mExpandedItem;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mOverrideVisibleItems;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private int mDefaultShowAsAction = 0;
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private boolean mOptionalIconsVisible = false;
    private boolean mIsClosing = false;
    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList<>();
    private boolean mGroupDividerEnabled = false;
    private ArrayList<MenuItemImpl> mItems = new ArrayList<>();
    private ArrayList<MenuItemImpl> mVisibleItems = new ArrayList<>();
    private boolean mIsVisibleItemsStale = true;
    private ArrayList<MenuItemImpl> mActionItems = new ArrayList<>();
    private ArrayList<MenuItemImpl> mNonActionItems = new ArrayList<>();
    private boolean mIsActionItemsStale = true;

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface Callback {
        boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

        void onMenuModeChange(@NonNull MenuBuilder menuBuilder);
    }

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        setShortcutsVisibleInner(true);
    }

    private MenuItemImpl createNewMenuItem(int i3, int i16, int i17, int i18, CharSequence charSequence, int i19) {
        return new MenuItemImpl(this, i3, i16, i17, i18, charSequence, i19);
    }

    private void dispatchPresenterUpdate(boolean z16) {
        if (this.mPresenters.isEmpty()) {
            return;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                menuPresenter.updateMenuView(z16);
            }
        }
        startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(PRESENTER_KEY);
        if (sparseParcelableArray != null && !this.mPresenters.isEmpty()) {
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id5 = menuPresenter.getId();
                    if (id5 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id5)) != null) {
                        menuPresenter.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (this.mPresenters.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                int id5 = menuPresenter.getId();
                if (id5 > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                    sparseArray.put(id5, onSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray(PRESENTER_KEY, sparseArray);
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        boolean z16 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z16 = menuPresenter.onSubMenuSelected(subMenuBuilder);
        }
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null) {
                this.mPresenters.remove(next);
            } else if (!z16) {
                z16 = menuPresenter2.onSubMenuSelected(subMenuBuilder);
            }
        }
        return z16;
    }

    private static int findInsertIndex(ArrayList<MenuItemImpl> arrayList, int i3) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getOrdering() <= i3) {
                return size + 1;
            }
        }
        return 0;
    }

    private static int getOrdering(int i3) {
        int i16 = ((-65536) & i3) >> 16;
        if (i16 >= 0) {
            int[] iArr = sCategoryToOrder;
            if (i16 < iArr.length) {
                return (i3 & 65535) | (iArr[i16] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void removeItemAtInt(int i3, boolean z16) {
        if (i3 >= 0 && i3 < this.mItems.size()) {
            this.mItems.remove(i3);
            if (z16) {
                onItemsChanged(true);
            }
        }
    }

    private void setHeaderInternal(int i3, CharSequence charSequence, int i16, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i3 > 0) {
                this.mHeaderTitle = resources.getText(i3);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i16 > 0) {
                this.mHeaderIcon = ContextCompat.getDrawable(getContext(), i16);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        if (androidx.core.view.ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(android.view.ViewConfiguration.get(r2.mContext), r2.mContext) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setShortcutsVisibleInner(boolean z16) {
        boolean z17;
        if (z16) {
            z17 = true;
            if (this.mResources.getConfiguration().keyboard != 1) {
            }
        }
        z17 = false;
        this.mShortcutsVisible = z17;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i3, int i16, int i17, ComponentName componentName, Intent[] intentArr, Intent intent, int i18, MenuItem[] menuItemArr) {
        int i19;
        Intent intent2;
        int i26;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i19 = queryIntentActivityOptions.size();
        } else {
            i19 = 0;
        }
        if ((i18 & 1) == 0) {
            removeGroup(i3);
        }
        for (int i27 = 0; i27 < i19; i27++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i27);
            int i28 = resolveInfo.specificIndex;
            if (i28 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i28];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent4 = add(i3, i16, i17, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && (i26 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i26] = intent4;
            }
        }
        return i19;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuItem addInternal(int i3, int i16, int i17, CharSequence charSequence) {
        int ordering = getOrdering(i17);
        MenuItemImpl createNewMenuItem = createNewMenuItem(i3, i16, i17, ordering, charSequence, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
        if (contextMenuInfo != null) {
            createNewMenuItem.setMenuInfo(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.mItems;
        arrayList.add(findInsertIndex(arrayList, ordering), createNewMenuItem);
        onItemsChanged(true);
        return createNewMenuItem;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.mContext);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void changeMenuMode() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onMenuModeChange(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl menuItemImpl = this.mExpandedItem;
        if (menuItemImpl != null) {
            collapseItemActionView(menuItemImpl);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public final void close(boolean z16) {
        if (this.mIsClosing) {
            return;
        }
        this.mIsClosing = true;
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                menuPresenter.onCloseMenu(this, z16);
            }
        }
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        boolean z16 = false;
        if (!this.mPresenters.isEmpty() && this.mExpandedItem == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    z16 = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (z16) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z16) {
                this.mExpandedItem = null;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dispatchMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        Callback callback = this.mCallback;
        if (callback != null && callback.onMenuItemSelected(menuBuilder, menuItem)) {
            return true;
        }
        return false;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean z16 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                z16 = menuPresenter.expandItemActionView(this, menuItemImpl);
                if (z16) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z16) {
            this.mExpandedItem = menuItemImpl;
        }
        return z16;
    }

    public int findGroupIndex(int i3) {
        return findGroupIndex(i3, 0);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i3) {
        MenuItem findItem;
        int size = size();
        for (int i16 = 0; i16 < size; i16++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i16);
            if (menuItemImpl.getItemId() == i3) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i3)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i3) {
        int size = size();
        for (int i16 = 0; i16 < size; i16++) {
            if (this.mItems.get(i16).getItemId() == i3) {
                return i16;
            }
        }
        return -1;
    }

    MenuItemImpl findItemWithShortcutForKey(int i3, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<MenuItemImpl> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i3, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i16 = 0; i16 < size; i16++) {
            MenuItemImpl menuItemImpl = arrayList.get(i16);
            if (isQwertyMode) {
                numericShortcut = menuItemImpl.getAlphabeticShortcut();
            } else {
                numericShortcut = menuItemImpl.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((numericShortcut == cArr[0] && (metaState & 2) == 0) || ((numericShortcut == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && numericShortcut == '\b' && i3 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    void findItemsWithShortcutForKey(List<MenuItemImpl> list, int i3, KeyEvent keyEvent) {
        char numericShortcut;
        int numericModifiers;
        boolean z16;
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (!keyEvent.getKeyData(keyData) && i3 != 67) {
            return;
        }
        int size = this.mItems.size();
        for (int i16 = 0; i16 < size; i16++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i16);
            if (menuItemImpl.hasSubMenu()) {
                ((MenuBuilder) menuItemImpl.getSubMenu()).findItemsWithShortcutForKey(list, i3, keyEvent);
            }
            if (isQwertyMode) {
                numericShortcut = menuItemImpl.getAlphabeticShortcut();
            } else {
                numericShortcut = menuItemImpl.getNumericShortcut();
            }
            if (isQwertyMode) {
                numericModifiers = menuItemImpl.getAlphabeticModifiers();
            } else {
                numericModifiers = menuItemImpl.getNumericModifiers();
            }
            if ((modifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) == (numericModifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && numericShortcut != 0) {
                char[] cArr = keyData.meta;
                if ((numericShortcut == cArr[0] || numericShortcut == cArr[2] || (isQwertyMode && numericShortcut == '\b' && i3 == 67)) && menuItemImpl.isEnabled()) {
                    list.add(menuItemImpl);
                }
            }
        }
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (!this.mIsActionItemsStale) {
            return;
        }
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                z16 |= menuPresenter.flagActionItems();
            }
        }
        if (z16) {
            this.mActionItems.clear();
            this.mNonActionItems.clear();
            int size = visibleItems.size();
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = visibleItems.get(i3);
                if (menuItemImpl.isActionButton()) {
                    this.mActionItems.add(menuItemImpl);
                } else {
                    this.mNonActionItems.add(menuItemImpl);
                }
            }
        } else {
            this.mActionItems.clear();
            this.mNonActionItems.clear();
            this.mNonActionItems.addAll(getVisibleItems());
        }
        this.mIsActionItemsStale = false;
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public MenuItemImpl getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i3) {
        return this.mItems.get(i3);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    Resources getResources() {
        return this.mResources;
    }

    @NonNull
    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!this.mIsVisibleItemsStale) {
            return this.mVisibleItems;
        }
        this.mVisibleItems.clear();
        int size = this.mItems.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i3);
            if (menuItemImpl.isVisible()) {
                this.mVisibleItems.add(menuItemImpl);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.mItems.get(i3).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        if (findItemWithShortcutForKey(i3, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemActionRequestChanged(MenuItemImpl menuItemImpl) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemVisibleChanged(MenuItemImpl menuItemImpl) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean z16) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z16) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            dispatchPresenterUpdate(z16);
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z16) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i3, int i16) {
        return performItemAction(findItem(i3), i16);
    }

    public boolean performItemAction(MenuItem menuItem, int i3) {
        return performItemAction(menuItem, null, i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i3, KeyEvent keyEvent, int i16) {
        boolean z16;
        MenuItemImpl findItemWithShortcutForKey = findItemWithShortcutForKey(i3, keyEvent);
        if (findItemWithShortcutForKey != null) {
            z16 = performItemAction(findItemWithShortcutForKey, i16);
        } else {
            z16 = false;
        }
        if ((i16 & 2) != 0) {
            close(true);
        }
        return z16;
    }

    @Override // android.view.Menu
    public void removeGroup(int i3) {
        int findGroupIndex = findGroupIndex(i3);
        if (findGroupIndex >= 0) {
            int size = this.mItems.size() - findGroupIndex;
            int i16 = 0;
            while (true) {
                int i17 = i16 + 1;
                if (i16 >= size || this.mItems.get(findGroupIndex).getGroupId() != i3) {
                    break;
                }
                removeItemAtInt(findGroupIndex, false);
                i16 = i17;
            }
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i3) {
        removeItemAtInt(findItemIndex(i3), true);
    }

    public void removeItemAt(int i3) {
        removeItemAtInt(i3, true);
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.mPresenters.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int i16 = bundle.getInt(EXPANDED_ACTION_VIEW_ID);
        if (i16 > 0 && (findItem = findItem(i16)) != null) {
            findItem.expandActionView();
        }
    }

    public void restorePresenterStates(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public MenuBuilder setDefaultShowAsAction(int i3) {
        this.mDefaultShowAsAction = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExclusiveItemChecked(MenuItem menuItem) {
        boolean z16;
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        stopDispatchingItemsChanged();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i3);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                if (menuItemImpl == menuItem) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                menuItemImpl.setCheckedInt(z16);
            }
        }
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i3, boolean z16, boolean z17) {
        int size = this.mItems.size();
        for (int i16 = 0; i16 < size; i16++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i16);
            if (menuItemImpl.getGroupId() == i3) {
                menuItemImpl.setExclusiveCheckable(z17);
                menuItemImpl.setCheckable(z16);
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean z16) {
        this.mGroupDividerEnabled = z16;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i3, boolean z16) {
        int size = this.mItems.size();
        for (int i16 = 0; i16 < size; i16++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i16);
            if (menuItemImpl.getGroupId() == i3) {
                menuItemImpl.setEnabled(z16);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i3, boolean z16) {
        int size = this.mItems.size();
        boolean z17 = false;
        for (int i16 = 0; i16 < size; i16++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i16);
            if (menuItemImpl.getGroupId() == i3 && menuItemImpl.setVisibleInt(z16)) {
                z17 = true;
            }
        }
        if (z17) {
            onItemsChanged(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(Drawable drawable) {
        setHeaderInternal(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        setHeaderInternal(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder setHeaderViewInt(View view) {
        setHeaderInternal(0, null, 0, null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean z16) {
        this.mOptionalIconsVisible = z16;
    }

    public void setOverrideVisibleItems(boolean z16) {
        this.mOverrideVisibleItems = z16;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z16) {
        this.mQwertyMode = z16;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z16) {
        if (this.mShortcutsVisible == z16) {
            return;
        }
        setShortcutsVisibleInner(z16);
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mItems.size();
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (!this.mPreventDispatchingItemsChanged) {
            this.mPreventDispatchingItemsChanged = true;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i3) {
        return addInternal(0, 0, 0, this.mResources.getString(i3));
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.mPresenters.add(new WeakReference<>(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i3));
    }

    public int findGroupIndex(int i3, int i16) {
        int size = size();
        if (i16 < 0) {
            i16 = 0;
        }
        while (i16 < size) {
            if (this.mItems.get(i16).getGroupId() == i3) {
                return i16;
            }
            i16++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i3) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z16 = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.hasCollapsibleActionView()) {
            invoke |= menuItemImpl.expandActionView();
            if (invoke) {
                close(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z16) {
            if ((i3 & 4) == 0) {
                close(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z16) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            invoke |= dispatchSubMenuSelected(subMenuBuilder, menuPresenter);
            if (!invoke) {
                close(true);
            }
        } else if ((i3 & 1) == 0) {
            close(true);
        }
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(int i3) {
        setHeaderInternal(0, null, i3, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(int i3) {
        setHeaderInternal(i3, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i16, int i17, CharSequence charSequence) {
        return addInternal(i3, i16, i17, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i16, int i17, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i3, i16, i17, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.mContext, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i16, int i17, int i18) {
        return addInternal(i3, i16, i17, this.mResources.getString(i18));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i16, int i17, int i18) {
        return addSubMenu(i3, i16, i17, this.mResources.getString(i18));
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }

    public MenuBuilder getRootMenu() {
        return this;
    }
}
