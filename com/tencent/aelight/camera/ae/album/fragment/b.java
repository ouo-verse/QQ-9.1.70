package com.tencent.aelight.camera.ae.album.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.album.logic.c;
import com.tencent.aelight.camera.ae.album.logic.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends AEAbstractPhotoListFragment {

    /* renamed from: l0, reason: collision with root package name */
    public Handler f62066l0 = new HandlerC0531b(this);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                oy3.a.a().c("list_photo", false);
            } else {
                oy3.a.a().b("list_photo");
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.album.fragment.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    private static class HandlerC0531b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<b> f62068a;

        public HandlerC0531b(b bVar) {
            this.f62068a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<b> weakReference = this.f62068a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            b bVar = this.f62068a.get();
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    this.f62068a.get().f62027d.m(message);
                    return;
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    bVar.n();
                    QLog.e("PhotoListActivity", 2, "onEncodeError = ", Integer.valueOf(((Integer) message.obj).intValue()));
                    QQToast.makeText(bVar.getActivity(), bVar.getResources().getString(R.string.cua), 0).show();
                    return;
                }
            }
            AEAbstractPhotoListFragment.e eVar = bVar.f62034h;
            if (eVar == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(eVar.f62046d);
            Bundle data = message.getData();
            int i16 = data.getInt("ALBUMLIST_POSITION");
            long j3 = data.getLong("ALBUMLIST_ITEM_DURATION");
            LocalMediaInfo localMediaInfo = arrayList.get(i16);
            localMediaInfo.mDuration = j3;
            arrayList.set(i16, localMediaInfo);
            eVar.t(arrayList, true);
            eVar.notifyDataSetChanged();
        }
    }

    public void L(String str) {
        try {
            FileProvider7Helper.savePhotoToSysAlbum(getActivity(), str);
        } catch (Exception e16) {
            QLog.e("PhotoListActivity", 2, "scanMediaFile :", e16);
        }
    }

    public void M() {
        if ((this.f62029e.f184306q && QAlbumCustomAlbumConstants.RECENT_ALBUM_ID.equals(this.f62027d.f62123f.albumId)) || (this.f62029e.f184307r && QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID.equals(this.f62027d.f62123f.albumId))) {
            r(false, true);
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        if (view.getId() == R.id.ekt) {
            this.f62027d.t(view, new Bundle(), 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tencent.mobileqq.startup.permission.a.f(getActivity().getApplicationContext())) {
            return;
        }
        com.tencent.mobileqq.startup.permission.a.h(getActivity(), null);
    }

    @Override // com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
    }

    @Override // com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment
    protected c s() {
        return new d(this);
    }

    @Override // com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment
    public AEAbstractAlbumListFragment t() {
        return new com.tencent.aelight.camera.ae.album.fragment.a();
    }

    @Override // com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment
    protected Dialog u() {
        ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f168383uh);
        return reportDialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment
    public void x(View view) {
        super.x(view);
        this.Q.addOnScrollListener(new a());
    }
}
