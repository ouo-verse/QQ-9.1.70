package com.tencent.aelight.camera.ae.album.fragment;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class AEAbstractAlbumListFragment extends ReportFragment {
    XFrameLayout C;

    /* renamed from: d, reason: collision with root package name */
    public c f62013d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.aelight.camera.ae.album.logic.a f62014e;

    /* renamed from: f, reason: collision with root package name */
    com.tencent.mobileqq.activity.photo.album.albumlist.a f62015f;

    /* renamed from: h, reason: collision with root package name */
    FrameLayout f62016h;

    /* renamed from: i, reason: collision with root package name */
    public AEAlbumListAdapter f62017i;

    /* renamed from: m, reason: collision with root package name */
    public XListView f62018m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c cVar = AEAbstractAlbumListFragment.this.f62013d;
            if (cVar != null) {
                cVar.d();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            QQAlbumInfo item = AEAbstractAlbumListFragment.this.f62017i.getItem(i3);
            Intent intent = AEAbstractAlbumListFragment.this.getActivity().getIntent();
            if (item != null && item.mMediaFileCount > 0 && !TextUtils.isEmpty(item.name)) {
                boolean g16 = AEAbstractAlbumListFragment.this.f62014e.g(item, i3, intent);
                c cVar = AEAbstractAlbumListFragment.this.f62013d;
                if (cVar != null) {
                    cVar.a(item, i3, g16);
                    return;
                }
                return;
            }
            QQToast.makeText(AEAbstractAlbumListFragment.this.getActivity(), R.string.f170308lv, 0).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a(QQAlbumInfo qQAlbumInfo, int i3, boolean z16);

        void d();
    }

    protected abstract com.tencent.aelight.camera.ae.album.logic.a e();

    public void g(c cVar) {
        this.f62013d = cVar;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public Animator onCreateAnimator(int i3, boolean z16, int i16) {
        return null;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.tencent.aelight.camera.ae.album.logic.a aVar = this.f62014e;
        if (aVar != null) {
            aVar.e();
        }
    }

    private void f(View view) {
        XFrameLayout xFrameLayout = (XFrameLayout) view.findViewById(R.id.ebg);
        this.C = xFrameLayout;
        xFrameLayout.setCornerRadiusAndMode(Utils.dp2px(10.0d), 5);
        XListView xListView = (XListView) view.findViewById(R.id.album_list);
        this.f62018m = xListView;
        xListView.setWrapByScroll(true);
        this.f62018m.setAdapter((ListAdapter) this.f62017i);
        this.f62018m.setOnItemClickListener(new b());
        this.f62018m.setOverScrollMode(2);
        this.f62018m.setDivider(null);
        this.f62018m.setVerticalScrollBarEnabled(false);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f164270os);
        this.f62016h = frameLayout;
        frameLayout.setOnClickListener(new a());
        view.findViewById(R.id.f164268or).setVisibility(8);
        final int intExtra = getActivity().getIntent().getIntExtra(QAlbumConstants.PHOTO_SELECTION_INDEX, 0);
        final int intExtra2 = getActivity().getIntent().getIntExtra(QAlbumConstants.PHOTO_SELECTION_Y, 0);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment.2
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                if (QLog.isColorLevel()) {
                    QLog.d("AlbumListActivity", 2, "load Scroll Position,index:" + intExtra + " top:" + intExtra2);
                }
                AEAbstractAlbumListFragment.this.f62018m.setSelectionFromTop(intExtra, intExtra2);
                return false;
            }
        });
        this.f62014e.h();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.cax, viewGroup, false);
        com.tencent.aelight.camera.ae.album.logic.a e16 = e();
        this.f62014e = e16;
        this.f62015f = e16.f62117c;
        this.f62014e.f(getActivity().getIntent());
        f(inflate);
        FragmentCollector.onFragmentViewCreated(this, inflate);
        return inflate;
    }
}
