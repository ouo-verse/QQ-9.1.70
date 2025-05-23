package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SearchFriendListActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private XListView f176980a0;

    /* renamed from: b0, reason: collision with root package name */
    private b f176981b0;

    /* renamed from: c0, reason: collision with root package name */
    private ArrayList<SearchResultItem> f176982c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.avatar.observer.a f176983d0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchFriendListActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                SearchFriendListActivity.this.f176981b0.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateMobileQQHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16 && str != null) {
                SearchFriendListActivity.this.f176981b0.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class b extends BaseAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchFriendListActivity.this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return SearchFriendListActivity.this.f176982c0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (i3 >= 0 && i3 < SearchFriendListActivity.this.f176982c0.size()) {
                return SearchFriendListActivity.this.f176982c0.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = SearchFriendListActivity.this.getLayoutInflater().inflate(R.layout.bx9, viewGroup, false);
                    c cVar = new c();
                    cVar.f176986a = (ImageView) view.findViewById(R.id.d3i);
                    cVar.f176987b = (TextView) view.findViewById(R.id.f9r);
                    cVar.f176988c = (TextView) view.findViewById(R.id.bes);
                    view.setTag(cVar);
                    view.setOnClickListener(SearchFriendListActivity.this);
                }
                SearchFriendListActivity.this.I2(view, i3);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        ImageView f176986a;

        /* renamed from: b, reason: collision with root package name */
        TextView f176987b;

        /* renamed from: c, reason: collision with root package name */
        TextView f176988c;

        /* renamed from: d, reason: collision with root package name */
        int f176989d;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public SearchFriendListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176983d0 = new a();
        }
    }

    void I2(View view, int i3) {
        SearchResultItem searchResultItem;
        String str;
        if (i3 < 0 || i3 >= this.f176982c0.size() || (searchResultItem = this.f176982c0.get(i3)) == null) {
            return;
        }
        String str2 = searchResultItem.f283462f;
        String valueOf = String.valueOf(searchResultItem.f283460d);
        String str3 = searchResultItem.f283463h;
        int i16 = searchResultItem.f283461e;
        c cVar = (c) view.getTag();
        if (!TextUtils.isEmpty(str2)) {
            cVar.f176987b.setText(str2);
        } else {
            TextView textView = cVar.f176987b;
            if (i16 == 1) {
                str = valueOf;
            } else {
                str = str3;
            }
            textView.setText(str);
        }
        if (i16 == 1) {
            cVar.f176986a.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.app, valueOf, (byte) 3));
            cVar.f176988c.setText("QQ\u53f7\u7801: " + valueOf);
        } else {
            cVar.f176986a.setImageDrawable(FaceDrawable.getMobileFaceDrawable(this.app, str3, (byte) 3));
            cVar.f176988c.setText(HardCodeUtil.qqStr(R.string.t6p) + str3);
        }
        cVar.f176989d = i3;
        view.setContentDescription(cVar.f176987b.getText());
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.bx_);
        setContentBackgroundResource(R.drawable.bg_texture);
        setTitle(HardCodeUtil.qqStr(R.string.t6o));
        XListView xListView = (XListView) findViewById(R.id.ijo);
        this.f176980a0 = xListView;
        xListView.setContentBackground(R.drawable.bg_texture);
        addObserver(this.f176983d0);
        ArrayList<SearchResultItem> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("param_search_result_item_list");
        this.f176982c0 = parcelableArrayListExtra;
        if (parcelableArrayListExtra == null) {
            this.f176982c0 = new ArrayList<>();
        }
        b bVar = new b();
        this.f176981b0 = bVar;
        this.f176980a0.setAdapter((ListAdapter) bVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            removeObserver(this.f176983d0);
            super.doOnDestroy();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchResultItem searchResultItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (view.getTag() instanceof c) {
            int i3 = ((c) view.getTag()).f176989d;
            if (i3 >= 0 && i3 < this.f176982c0.size()) {
                searchResultItem = this.f176982c0.get(i3);
            } else {
                searchResultItem = null;
            }
            if (searchResultItem != null) {
                if (searchResultItem.C == 0) {
                    AddFriendActivity.startProfileCardActivity(this, searchResultItem, this.app, false, 1);
                } else {
                    CrmUtils.n(this, null, String.valueOf(searchResultItem.f283460d), false, -1, true, -1);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
