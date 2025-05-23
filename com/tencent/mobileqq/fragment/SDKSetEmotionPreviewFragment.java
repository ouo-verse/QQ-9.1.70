package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class SDKSetEmotionPreviewFragment extends IphoneTitleBarFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private GridView E;
    private a F;
    private ArrayList<String> G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public List<String> f211223d;

        /* renamed from: e, reason: collision with root package name */
        LayoutInflater f211224e;

        /* renamed from: com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class ViewOnClickListenerC7623a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f211226d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f211227e;

            ViewOnClickListenerC7623a(String str, View view) {
                this.f211226d = str;
                this.f211227e = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, str, view);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    SDKSetEmotionPreviewFragment.sh(this.f211226d, SDKSetEmotionPreviewFragment.this.getBaseActivity(), this.f211227e);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* loaded from: classes12.dex */
        public class b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public URLImageView f211229a;

            public b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKSetEmotionPreviewFragment.this);
            } else {
                this.f211223d = new ArrayList();
                this.f211224e = SDKSetEmotionPreviewFragment.this.getBaseActivity().getLayoutInflater();
            }
        }

        public void a(List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            if (list == null) {
                if (this.f211223d.size() != 0) {
                    this.f211223d.clear();
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.f211223d.clear();
            this.f211223d.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            List<String> list = this.f211223d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            return this.f211223d.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            b bVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = this.f211224e.inflate(R.layout.h87, (ViewGroup) null);
                    view.setLayoutParams(new AbsListView.LayoutParams(SDKSetEmotionPreviewFragment.this.C, SDKSetEmotionPreviewFragment.this.D));
                    bVar = new b();
                    bVar.f211229a = (URLImageView) view.findViewById(R.id.buq);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                String str = this.f211223d.get(i3);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mFailedDrawable = drawable;
                obtain.mLoadingDrawable = drawable;
                obtain.mPlayGifImage = BaseImageUtil.isGifFile(str);
                obtain.mUseAutoScaleParams = true;
                URLDrawable fileDrawable = URLDrawable.getFileDrawable(str, obtain);
                bVar.f211229a.setScaleType(ImageView.ScaleType.FIT_CENTER);
                bVar.f211229a.setImageDrawable(fileDrawable);
                URLImageView uRLImageView = bVar.f211229a;
                uRLImageView.setOnClickListener(new ViewOnClickListenerC7623a(str, uRLImageView));
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    public SDKSetEmotionPreviewFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void initData() {
        a aVar = new a();
        this.F = aVar;
        this.E.setAdapter((ListAdapter) aVar);
        this.F.a(this.G);
    }

    private void initView(View view) {
        Resources resources = getResources();
        int i3 = resources.getDisplayMetrics().widthPixels;
        int f16 = BaseAIOUtils.f(0.0f, resources);
        int f17 = BaseAIOUtils.f(4.0f, resources);
        int f18 = BaseAIOUtils.f(4.0f, resources);
        int i16 = ((i3 - (f16 * 2)) - (f17 * 3)) / 4;
        this.C = i16;
        this.D = i16;
        String string = resources.getString(R.string.afp);
        setTitle(string, string);
        GridView gridView = (GridView) view.findViewById(R.id.bv8);
        this.E = gridView;
        gridView.setScrollBarStyle(0);
        this.E.setNumColumns(4);
        this.E.setColumnWidth(this.C);
        this.E.setHorizontalSpacing(f17);
        this.E.setVerticalSpacing(f18);
        GridView gridView2 = this.E;
        gridView2.setPadding(f16, gridView2.getPaddingTop(), f16, this.E.getPaddingBottom());
        this.E.setOnItemClickListener(this);
        this.E.setMaximumVelocity((int) (getResources().getDisplayMetrics().density * 2500.0f));
    }

    public static void sh(String str, Context context, View view) {
        ImageView imageView;
        sm2.a aVar = sm2.a.f433978a;
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        } else {
            imageView = null;
        }
        aVar.c(str, imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initView(((IphoneTitleBarFragment) this).mContentView);
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.f167930nd;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Intent intent = getBaseActivity().getIntent();
        if (intent != null) {
            this.G = intent.getStringArrayListExtra("path_list");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        TextView textView = this.leftView;
        if (textView != null) {
            textView.setContentDescription(getString(R.string.f170549u3));
        }
    }
}
