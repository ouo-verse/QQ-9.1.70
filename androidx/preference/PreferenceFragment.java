package androidx.preference;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;

/* loaded from: classes.dex */
public abstract class PreferenceFragment extends ReportFragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {
    static IPatchRedirector $redirector_ = null;
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private final DividerDecoration mDividerDecoration;
    private final Handler mHandler;
    private boolean mHavePrefs;
    private boolean mInitDone;
    private int mLayoutResId;
    RecyclerView mList;
    private PreferenceManager mPreferenceManager;
    private final Runnable mRequestFocus;
    private Runnable mSelectPreferenceRunnable;
    private Context mStyledContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class DividerDecoration extends RecyclerView.ItemDecoration {
        private boolean mAllowDividerAfterLastItem = true;
        private Drawable mDivider;
        private int mDividerHeight;

        DividerDecoration() {
        }

        private boolean shouldDrawDividerBelow(View view, RecyclerView recyclerView) {
            boolean z16;
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            boolean z17 = false;
            if ((childViewHolder instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder).isDividerAllowedBelow()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            boolean z18 = this.mAllowDividerAfterLastItem;
            int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild < recyclerView.getChildCount() - 1) {
                RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
                if ((childViewHolder2 instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder2).isDividerAllowedAbove()) {
                    z17 = true;
                }
                return z17;
            }
            return z18;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (shouldDrawDividerBelow(view, recyclerView)) {
                rect.bottom = this.mDividerHeight;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.mDivider == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                if (shouldDrawDividerBelow(childAt, recyclerView)) {
                    int y16 = ((int) childAt.getY()) + childAt.getHeight();
                    this.mDivider.setBounds(0, y16, width, this.mDividerHeight + y16);
                    this.mDivider.draw(canvas);
                }
            }
        }

        public void setAllowDividerAfterLastItem(boolean z16) {
            this.mAllowDividerAfterLastItem = z16;
        }

        public void setDivider(Drawable drawable) {
            if (drawable != null) {
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerHeight = 0;
            }
            this.mDivider = drawable;
            PreferenceFragment.this.mList.invalidateItemDecorations();
        }

        public void setDividerHeight(int i3) {
            this.mDividerHeight = i3;
            PreferenceFragment.this.mList.invalidateItemDecorations();
        }
    }

    /* loaded from: classes.dex */
    public interface OnPreferenceDisplayDialogCallback {
        boolean onPreferenceDisplayDialog(@NonNull PreferenceFragment preferenceFragment, Preference preference);
    }

    /* loaded from: classes.dex */
    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(PreferenceFragment preferenceFragment, Preference preference);
    }

    /* loaded from: classes.dex */
    public interface OnPreferenceStartScreenCallback {
        boolean onPreferenceStartScreen(PreferenceFragment preferenceFragment, PreferenceScreen preferenceScreen);
    }

    /* loaded from: classes.dex */
    private static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {
        private final RecyclerView.Adapter mAdapter;
        private final String mKey;
        private final RecyclerView mList;
        private final Preference mPreference;

        ScrollToPreferenceObserver(RecyclerView.Adapter adapter, RecyclerView recyclerView, Preference preference, String str) {
            this.mAdapter = adapter;
            this.mList = recyclerView;
            this.mPreference = preference;
            this.mKey = str;
        }

        private void scrollToPreference() {
            int preferenceAdapterPosition;
            this.mAdapter.unregisterAdapterDataObserver(this);
            Preference preference = this.mPreference;
            if (preference != null) {
                preferenceAdapterPosition = ((PreferenceGroup.PreferencePositionCallback) this.mAdapter).getPreferenceAdapterPosition(preference);
            } else {
                preferenceAdapterPosition = ((PreferenceGroup.PreferencePositionCallback) this.mAdapter).getPreferenceAdapterPosition(this.mKey);
            }
            if (preferenceAdapterPosition != -1) {
                this.mList.scrollToPosition(preferenceAdapterPosition);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, Object obj) {
            scrollToPreference();
        }
    }

    public PreferenceFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLayoutResId = com.tencent.mobileqq.R.layout.frr;
        this.mDividerDecoration = new DividerDecoration();
        this.mHandler = new Handler() { // from class: androidx.preference.PreferenceFragment.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    PreferenceFragment.this.bindPreferences();
                }
            }
        };
        this.mRequestFocus = new Runnable() { // from class: androidx.preference.PreferenceFragment.2
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = PreferenceFragment.this.mList;
                recyclerView.focusableViewAvailable(recyclerView);
            }
        };
    }

    private void postBindPreferences() {
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager != null) {
        } else {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void scrollToPreferenceInternal(final Preference preference, final String str) {
        Runnable runnable = new Runnable() { // from class: androidx.preference.PreferenceFragment.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                int preferenceAdapterPosition;
                RecyclerView.Adapter adapter = PreferenceFragment.this.mList.getAdapter();
                if (!(adapter instanceof PreferenceGroup.PreferencePositionCallback)) {
                    if (adapter == 0) {
                        return;
                    } else {
                        throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
                    }
                }
                Preference preference2 = preference;
                if (preference2 != null) {
                    preferenceAdapterPosition = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(preference2);
                } else {
                    preferenceAdapterPosition = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(str);
                }
                if (preferenceAdapterPosition != -1) {
                    PreferenceFragment.this.mList.scrollToPosition(preferenceAdapterPosition);
                } else {
                    adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver(adapter, PreferenceFragment.this.mList, preference, str));
                }
            }
        };
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = runnable;
        } else {
            runnable.run();
        }
    }

    private void unbindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.onDetached();
        }
        onUnbindPreferences();
    }

    public void addPreferencesFromResource(@XmlRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            requirePreferenceManager();
            setPreferenceScreen(this.mPreferenceManager.inflateFromResource(this.mStyledContext, i3, getPreferenceScreen()));
        }
    }

    void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.onAttached();
        }
        onBindPreferences();
    }

    @Override // androidx.preference.DialogPreference.TargetFragment
    public Preference findPreference(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Preference) iPatchRedirector.redirect((short) 18, (Object) this, (Object) charSequence);
        }
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.findPreference(charSequence);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Fragment getCallbackFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Fragment) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return null;
    }

    public final RecyclerView getListView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mList;
    }

    public PreferenceManager getPreferenceManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (PreferenceManager) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (PreferenceScreen) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mPreferenceManager.getPreferenceScreen();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void onBindPreferences() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(com.tencent.mobileqq.R.attr.b2c, typedValue, true);
        int i3 = typedValue.resourceId;
        if (i3 == 0) {
            i3 = com.tencent.mobileqq.R.style.a5f;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), i3);
        this.mStyledContext = contextThemeWrapper;
        PreferenceManager preferenceManager = new PreferenceManager(contextThemeWrapper);
        this.mPreferenceManager = preferenceManager;
        preferenceManager.setOnNavigateToScreenListener(this);
        if (getArguments() != null) {
            str = getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        } else {
            str = null;
        }
        onCreatePreferences(bundle, str);
    }

    protected RecyclerView.Adapter onCreateAdapter(PreferenceScreen preferenceScreen) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (RecyclerView.Adapter) iPatchRedirector.redirect((short) 24, (Object) this, (Object) preferenceScreen);
        }
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    public RecyclerView.LayoutManager onCreateLayoutManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (RecyclerView.LayoutManager) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return new LinearLayoutManager(getActivity());
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 22, this, layoutInflater, viewGroup, bundle);
        }
        if (this.mStyledContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(com.tencent.mobileqq.R.id.i4m)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(com.tencent.mobileqq.R.layout.frt, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        } else {
            Context context = this.mStyledContext;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.PreferenceFragment, TypedArrayUtils.getAttr(context, com.tencent.mobileqq.R.attr.f156013b25, 16844038), 0);
            this.mLayoutResId = obtainStyledAttributes.getResourceId(R.styleable.PreferenceFragment_android_layout, this.mLayoutResId);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.PreferenceFragment_android_divider);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceFragment_android_dividerHeight, -1);
            boolean z16 = obtainStyledAttributes.getBoolean(R.styleable.PreferenceFragment_allowDividerAfterLastItem, true);
            obtainStyledAttributes.recycle();
            LayoutInflater cloneInContext = layoutInflater.cloneInContext(this.mStyledContext);
            View inflate = cloneInContext.inflate(this.mLayoutResId, viewGroup, false);
            View findViewById = inflate.findViewById(16908351);
            if (findViewById instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById;
                RecyclerView onCreateRecyclerView = onCreateRecyclerView(cloneInContext, viewGroup2, bundle);
                if (onCreateRecyclerView != null) {
                    this.mList = onCreateRecyclerView;
                    onCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
                    setDivider(drawable);
                    if (dimensionPixelSize != -1) {
                        setDividerHeight(dimensionPixelSize);
                    }
                    this.mDividerDecoration.setAllowDividerAfterLastItem(z16);
                    if (this.mList.getParent() == null) {
                        viewGroup2.addView(this.mList);
                    }
                    this.mHandler.post(this.mRequestFocus);
                    view = inflate;
                } else {
                    throw new RuntimeException("Could not create RecyclerView");
                }
            } else {
                throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
            }
        }
        FragmentCollector.onFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            unbindPreferences();
        }
        this.mList = null;
        super.onDestroyView();
    }

    @Override // androidx.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    public void onDisplayPreferenceDialog(Preference preference) {
        boolean z16;
        DialogFragment newInstance;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) preference);
            return;
        }
        if (getCallbackFragment() instanceof OnPreferenceDisplayDialogCallback) {
            z16 = ((OnPreferenceDisplayDialogCallback) getCallbackFragment()).onPreferenceDisplayDialog(this, preference);
        } else {
            z16 = false;
        }
        if (!z16 && (getActivity() instanceof OnPreferenceDisplayDialogCallback)) {
            z16 = ((OnPreferenceDisplayDialogCallback) getActivity()).onPreferenceDisplayDialog(this, preference);
        }
        if (z16 || getFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG) != null) {
            return;
        }
        if (preference instanceof EditTextPreference) {
            newInstance = EditTextPreferenceDialogFragment.newInstance(preference.getKey());
        } else if (preference instanceof ListPreference) {
            newInstance = ListPreferenceDialogFragment.newInstance(preference.getKey());
        } else if (preference instanceof MultiSelectListPreference) {
            newInstance = MultiSelectListPreferenceDialogFragment.newInstance(preference.getKey());
        } else {
            throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
        }
        newInstance.setTargetFragment(this, 0);
        newInstance.show(getFragmentManager(), DIALOG_FRAGMENT_TAG);
    }

    @Override // androidx.preference.PreferenceManager.OnNavigateToScreenListener
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) preferenceScreen);
            return;
        }
        if (getCallbackFragment() instanceof OnPreferenceStartScreenCallback) {
            z16 = ((OnPreferenceStartScreenCallback) getCallbackFragment()).onPreferenceStartScreen(this, preferenceScreen);
        } else {
            z16 = false;
        }
        if (!z16 && (getActivity() instanceof OnPreferenceStartScreenCallback)) {
            ((OnPreferenceStartScreenCallback) getActivity()).onPreferenceStartScreen(this, preferenceScreen);
        }
    }

    @Override // androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) preference)).booleanValue();
        }
        boolean z16 = false;
        if (preference.getFragment() == null) {
            return false;
        }
        if (getCallbackFragment() instanceof OnPreferenceStartFragmentCallback) {
            z16 = ((OnPreferenceStartFragmentCallback) getCallbackFragment()).onPreferenceStartFragment(this, preference);
        }
        if (!z16 && (getActivity() instanceof OnPreferenceStartFragmentCallback)) {
            return ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, preference);
        }
        return z16;
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
            return;
        }
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.saveHierarchyState(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onStart();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(this);
        this.mPreferenceManager.setOnDisplayPreferenceDialogListener(this);
    }

    @Override // android.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onStop();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(null);
        this.mPreferenceManager.setOnDisplayPreferenceDialogListener(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void onUnbindPreferences() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle(PREFERENCES_TAG)) != null && (preferenceScreen = getPreferenceScreen()) != null) {
            preferenceScreen.restoreHierarchyState(bundle2);
        }
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            scrollToPreferenceInternal(null, str);
        } else {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        }
    }

    public void setDivider(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
        } else {
            this.mDividerDecoration.setDivider(drawable);
        }
    }

    public void setDividerHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mDividerDecoration.setDividerHeight(i3);
        }
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) preferenceScreen);
            return;
        }
        if (this.mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null) {
            onUnbindPreferences();
            this.mHavePrefs = true;
            if (this.mInitDone) {
                postBindPreferences();
            }
        }
    }

    public void setPreferencesFromResource(@XmlRes int i3, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) str);
            return;
        }
        requirePreferenceManager();
        PreferenceScreen inflateFromResource = this.mPreferenceManager.inflateFromResource(this.mStyledContext, i3, null);
        PreferenceScreen preferenceScreen = inflateFromResource;
        if (str != null) {
            Preference findPreference = inflateFromResource.findPreference(str);
            boolean z16 = findPreference instanceof PreferenceScreen;
            preferenceScreen = findPreference;
            if (!z16) {
                throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
            }
        }
        setPreferenceScreen(preferenceScreen);
    }

    public void scrollToPreference(Preference preference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            scrollToPreferenceInternal(preference, null);
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) preference);
        }
    }
}
