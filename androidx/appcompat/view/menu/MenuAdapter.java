package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {
    MenuBuilder mAdapterMenu;
    private int mExpandedIndex = -1;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z16, int i3) {
        this.mOverflowOnly = z16;
        this.mInflater = layoutInflater;
        this.mAdapterMenu = menuBuilder;
        this.mItemLayoutRes = i3;
        findExpandedIndex();
    }

    void findExpandedIndex() {
        MenuItemImpl expandedItem = this.mAdapterMenu.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = this.mAdapterMenu.getNonActionItems();
            int size = nonActionItems.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (nonActionItems.get(i3) == expandedItem) {
                    this.mExpandedIndex = i3;
                    return;
                }
            }
        }
        this.mExpandedIndex = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.mAdapterMenu;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> visibleItems;
        if (this.mOverflowOnly) {
            visibleItems = this.mAdapterMenu.getNonActionItems();
        } else {
            visibleItems = this.mAdapterMenu.getVisibleItems();
        }
        if (this.mExpandedIndex < 0) {
            return visibleItems.size();
        }
        return visibleItems.size() - 1;
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        int i16;
        boolean z16;
        if (view == null) {
            view = this.mInflater.inflate(this.mItemLayoutRes, viewGroup, false);
        }
        int groupId = getItem(i3).getGroupId();
        int i17 = i3 - 1;
        if (i17 >= 0) {
            i16 = getItem(i17).getGroupId();
        } else {
            i16 = groupId;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.mAdapterMenu.isGroupDividerEnabled() && groupId != i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        listMenuItemView.setGroupDividerEnabled(z16);
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.mForceShowIcon) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.initialize(getItem(i3), 0);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean z16) {
        this.mForceShowIcon = z16;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int i3) {
        ArrayList<MenuItemImpl> nonActionItems = this.mOverflowOnly ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
        int i16 = this.mExpandedIndex;
        if (i16 >= 0 && i3 >= i16) {
            i3++;
        }
        return nonActionItems.get(i3);
    }
}
