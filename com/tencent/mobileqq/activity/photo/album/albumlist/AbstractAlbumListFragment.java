package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AbstractAlbumListFragment extends QBaseFragment {
    static IPatchRedirector $redirector_;
    public com.tencent.mobileqq.activity.photo.album.albumlist.c C;
    public AlbumListAdapter D;
    public com.tencent.mobileqq.activity.photo.album.albumlist.b<? extends OtherCommonData> E;
    public com.tencent.mobileqq.activity.photo.album.albumlist.a F;
    public FrameLayout G;
    public XListView H;
    public XFrameLayout I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbstractAlbumListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                com.tencent.mobileqq.activity.photo.album.albumlist.c cVar = AbstractAlbumListFragment.this.C;
                if (cVar != null) {
                    cVar.c(false);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbstractAlbumListFragment.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbstractAlbumListFragment.this);
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            QQAlbumInfo item = AbstractAlbumListFragment.this.D.getItem(i3);
            Intent intent = AbstractAlbumListFragment.this.getActivity().getIntent();
            if (item != null && item.mMediaFileCount > 0 && !TextUtils.isEmpty(item.name)) {
                boolean g16 = AbstractAlbumListFragment.this.E.g(item, i3, intent);
                com.tencent.mobileqq.activity.photo.album.albumlist.c cVar = AbstractAlbumListFragment.this.C;
                if (cVar != null) {
                    cVar.a(item, i3, g16);
                    return;
                }
                return;
            }
            QQToast.makeText(AbstractAlbumListFragment.this.getActivity(), R.string.f170308lv, 0).show();
        }

        /* synthetic */ c(AbstractAlbumListFragment abstractAlbumListFragment, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) abstractAlbumListFragment, (Object) aVar);
        }
    }

    public AbstractAlbumListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @TargetApi(14)
    private void initUI(View view) {
        XFrameLayout xFrameLayout = (XFrameLayout) view.findViewById(R.id.ebg);
        this.I = xFrameLayout;
        xFrameLayout.setCornerRadiusAndMode(20, 5);
        XListView xListView = (XListView) view.findViewById(R.id.album_list);
        this.H = xListView;
        xListView.setWrapByScroll(true);
        this.H.setAdapter((ListAdapter) this.D);
        this.H.setOnItemClickListener(new c(this, null));
        this.H.setOverScrollMode(2);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f164270os);
        this.G = frameLayout;
        frameLayout.setOnClickListener(new a());
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler(getActivity().getIntent().getIntExtra(QAlbumConstants.PHOTO_SELECTION_INDEX, 0), getActivity().getIntent().getIntExtra(QAlbumConstants.PHOTO_SELECTION_Y, 0)) { // from class: com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f184207d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f184208e;

            {
                this.f184207d = r6;
                this.f184208e = r7;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AbstractAlbumListFragment.this, Integer.valueOf(r6), Integer.valueOf(r7));
                }
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "load Scroll Position,index:" + this.f184207d + " top:" + this.f184208e);
                }
                AbstractAlbumListFragment.this.H.setSelectionFromTop(this.f184207d, this.f184208e);
                return false;
            }
        });
        this.E.h();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i3, boolean z16, int i16) {
        TranslateAnimation translateAnimation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Animation) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
        }
        if (z16) {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        }
        translateAnimation.setDuration(300L);
        translateAnimation.setAnimationListener(new b());
        return translateAnimation;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.cax, viewGroup, false);
            com.tencent.mobileqq.activity.photo.album.albumlist.b<? extends OtherCommonData> ph5 = ph();
            this.E = ph5;
            this.F = ph5.f184224d;
            this.E.f(getActivity().getIntent());
            initUI(inflate);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroyView();
        com.tencent.mobileqq.activity.photo.album.albumlist.b<? extends OtherCommonData> bVar = this.E;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.onHiddenChanged(z16);
        if (!z16) {
            this.D.notifyDataSetChanged();
        }
    }

    protected com.tencent.mobileqq.activity.photo.album.albumlist.b<? extends OtherCommonData> ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.photo.album.albumlist.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new AlbumListCustomizationBase(this);
    }
}
