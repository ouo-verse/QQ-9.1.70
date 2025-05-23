package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;

/* compiled from: P */
/* loaded from: classes.dex */
public class ListFragment extends ReportAndroidXFragment {
    static IPatchRedirector $redirector_ = null;
    static final int INTERNAL_EMPTY_ID = 16711681;
    static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
    ListAdapter mAdapter;
    CharSequence mEmptyText;
    View mEmptyView;
    private final Handler mHandler;
    ListView mList;
    View mListContainer;
    boolean mListShown;
    private final AdapterView.OnItemClickListener mOnClickListener;
    View mProgressContainer;
    private final Runnable mRequestFocus;
    TextView mStandardEmptyView;

    public ListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHandler = new Handler();
        this.mRequestFocus = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
            @Override // java.lang.Runnable
            public void run() {
                ListView listView = ListFragment.this.mList;
                listView.focusableViewAvailable(listView);
            }
        };
        this.mOnClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.ListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
                ListFragment.this.onListItemClick((ListView) adapterView, view, i3, j3);
                EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
            }
        };
    }

    private void ensureList() {
        if (this.mList != null) {
            return;
        }
        View view = getView();
        if (view != null) {
            if (view instanceof ListView) {
                this.mList = (ListView) view;
            } else {
                TextView textView = (TextView) view.findViewById(INTERNAL_EMPTY_ID);
                this.mStandardEmptyView = textView;
                if (textView == null) {
                    this.mEmptyView = view.findViewById(R.id.empty);
                } else {
                    textView.setVisibility(8);
                }
                this.mProgressContainer = view.findViewById(INTERNAL_PROGRESS_CONTAINER_ID);
                this.mListContainer = view.findViewById(INTERNAL_LIST_CONTAINER_ID);
                View findViewById = view.findViewById(R.id.list);
                if (!(findViewById instanceof ListView)) {
                    if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    }
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                ListView listView = (ListView) findViewById;
                this.mList = listView;
                View view2 = this.mEmptyView;
                if (view2 != null) {
                    listView.setEmptyView(view2);
                } else {
                    CharSequence charSequence = this.mEmptyText;
                    if (charSequence != null) {
                        this.mStandardEmptyView.setText(charSequence);
                        this.mList.setEmptyView(this.mStandardEmptyView);
                    }
                }
            }
            this.mListShown = true;
            this.mList.setOnItemClickListener(this.mOnClickListener);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                this.mAdapter = null;
                setListAdapter(listAdapter);
            } else if (this.mProgressContainer != null) {
                setListShown(false, false);
            }
            this.mHandler.post(this.mRequestFocus);
            return;
        }
        throw new IllegalStateException("Content view not yet created");
    }

    @Nullable
    public ListAdapter getListAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ListAdapter) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mAdapter;
    }

    @NonNull
    public ListView getListView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ListView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ensureList();
        return this.mList;
    }

    public long getSelectedItemId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        ensureList();
        return this.mList.getSelectedItemPosition();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            Context requireContext = requireContext();
            FrameLayout frameLayout = new FrameLayout(requireContext);
            LinearLayout linearLayout = new LinearLayout(requireContext);
            linearLayout.setId(INTERNAL_PROGRESS_CONTAINER_ID);
            linearLayout.setOrientation(1);
            linearLayout.setVisibility(8);
            linearLayout.setGravity(17);
            linearLayout.addView(new ProgressBar(requireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = new FrameLayout(requireContext);
            frameLayout2.setId(INTERNAL_LIST_CONTAINER_ID);
            TextView textView = new TextView(requireContext);
            textView.setId(INTERNAL_EMPTY_ID);
            textView.setGravity(17);
            frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
            ListView listView = new ListView(requireContext);
            listView.setId(R.id.list);
            listView.setDrawSelectorOnTop(false);
            frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            view = frameLayout;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(@NonNull ListView listView, @NonNull View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, listView, view, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) bundle);
        } else {
            super.onViewCreated(view, bundle);
            ensureList();
        }
    }

    @NonNull
    public final ListAdapter requireListAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ListAdapter) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        ListAdapter listAdapter = getListAdapter();
        if (listAdapter != null) {
            return listAdapter;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(@Nullable CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) charSequence);
            return;
        }
        ensureList();
        TextView textView = this.mStandardEmptyView;
        if (textView != null) {
            textView.setText(charSequence);
            if (this.mEmptyText == null) {
                this.mList.setEmptyView(this.mStandardEmptyView);
            }
            this.mEmptyText = charSequence;
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void setListAdapter(@Nullable ListAdapter listAdapter) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listAdapter);
            return;
        }
        boolean z17 = false;
        if (this.mAdapter != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mAdapter = listAdapter;
        ListView listView = this.mList;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (!this.mListShown && !z16) {
                if (requireView().getWindowToken() != null) {
                    z17 = true;
                }
                setListShown(true, z17);
            }
        }
    }

    public void setListShown(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            setListShown(z16, true);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        }
    }

    public void setListShownNoAnimation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            setListShown(z16, false);
        }
    }

    public void setSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            ensureList();
            this.mList.setSelection(i3);
        }
    }

    private void setListShown(boolean z16, boolean z17) {
        ensureList();
        View view = this.mProgressContainer;
        if (view != null) {
            if (this.mListShown == z16) {
                return;
            }
            this.mListShown = z16;
            if (z16) {
                if (z17) {
                    view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                    this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
                } else {
                    view.clearAnimation();
                    this.mListContainer.clearAnimation();
                }
                this.mProgressContainer.setVisibility(8);
                this.mListContainer.setVisibility(0);
                return;
            }
            if (z17) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
                this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
            } else {
                view.clearAnimation();
                this.mListContainer.clearAnimation();
            }
            this.mProgressContainer.setVisibility(0);
            this.mListContainer.setVisibility(8);
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }
}
