package com.qzone.album.business.photolist.activity;

import NS_MOBILE_PHOTO.AllowJoinShareAlbum;
import NS_MOBILE_PHOTO.AllowJoinShareAlbumData;
import NS_MOBILE_PHOTO.ApplyJoinShareAlbum;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.ShareAlbumMemberCacheData;
import com.qzone.album.data.model.SharingAlbumClientAttr;
import com.qzone.album.data.model.SharingOwnerUinAttr;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.ui.widget.AlbumDialog;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.activities.base.QZoneTitleBarFragmentV2;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneSharingOwnersListActivity extends QZoneTitleBarFragmentV2 {
    private String A0;
    private String B0;
    private String H0;
    private Dialog J0;
    private TextView K0;

    /* renamed from: h0, reason: collision with root package name */
    private int f42536h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f42537i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f42538j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f42539k0;

    /* renamed from: l0, reason: collision with root package name */
    private long f42540l0;

    /* renamed from: m0, reason: collision with root package name */
    private long f42541m0;

    /* renamed from: n0, reason: collision with root package name */
    private SwipListView f42542n0;

    /* renamed from: o0, reason: collision with root package name */
    private View.OnClickListener f42543o0;

    /* renamed from: p0, reason: collision with root package name */
    private View.OnClickListener f42544p0;

    /* renamed from: q0, reason: collision with root package name */
    private View.OnClickListener f42545q0;

    /* renamed from: r0, reason: collision with root package name */
    private View.OnClickListener f42546r0;

    /* renamed from: s0, reason: collision with root package name */
    private View.OnClickListener f42547s0;

    /* renamed from: t0, reason: collision with root package name */
    private SharingOwnersListItemAdapter f42548t0;

    /* renamed from: u0, reason: collision with root package name */
    private RelativeLayout f42549u0;

    /* renamed from: v0, reason: collision with root package name */
    private ActionSheet f42550v0;

    /* renamed from: w0, reason: collision with root package name */
    private AlbumCacheData f42551w0;

    /* renamed from: x0, reason: collision with root package name */
    private ArrayList<i> f42552x0;

    /* renamed from: y0, reason: collision with root package name */
    private String f42553y0;

    /* renamed from: z0, reason: collision with root package name */
    private String f42554z0;
    private final int C0 = 0;
    private final int D0 = 1;
    private long E0 = 0;
    private long F0 = 0;
    private boolean G0 = true;
    private boolean I0 = true;
    private ActionSheet.OnButtonClickListener L0 = new b();
    private View.OnClickListener M0 = new f();
    private View.OnClickListener N0 = new g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity$1, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass1 implements Runnable {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes39.dex */
        public class RunnableC03261 implements Runnable {
            RunnableC03261() {
            }

            @Override // java.lang.Runnable
            public void run() {
                QZoneSharingOwnersListActivity.this.dj();
                long j3 = QZoneSharingOwnersListActivity.this.f42541m0;
                String str = QZoneSharingOwnersListActivity.this.f42537i0;
                if (QZoneSharingOwnersListActivity.this.f42551w0 != null) {
                    j3 = QZoneSharingOwnersListActivity.this.f42551w0.ownerUin;
                    str = QZoneSharingOwnersListActivity.this.f42551w0.albumid;
                } else if (!com.qzone.reborn.configx.g.f53821a.b().I()) {
                    return;
                }
                com.qzone.album.base.Service.a.W().x0(j3, str, new C03271(j3));
            }

            /* compiled from: P */
            /* renamed from: com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity$1$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes39.dex */
            class C03271 implements AbsCompatRequest.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ long f42556a;

                C03271(long j3) {
                    this.f42556a = j3;
                }

                @Override // com.qzone.album.protocol.AbsCompatRequest.a
                public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
                    QZoneSharingOwnersListActivity.this.Dh();
                    if (sVar.getSucceed()) {
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(new Runnable() { // from class: com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity.1.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZoneSharingOwnersListActivity.this.Yi();
                                QZoneSharingOwnersListActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity.1.1.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        QZoneSharingOwnersListActivity.this.dj();
                                        if (QZoneSharingOwnersListActivity.this.f42548t0 != null) {
                                            QZoneSharingOwnersListActivity.this.f42548t0.k(QZoneSharingOwnersListActivity.this.f42552x0);
                                            QZoneSharingOwnersListActivity.this.f42548t0.notifyDataSetChanged();
                                        }
                                        C03271.this.c();
                                    }
                                }, 0L);
                            }
                        });
                        c();
                    } else {
                        if (TextUtils.isEmpty(sVar.getMessage())) {
                            return;
                        }
                        QZoneSharingOwnersListActivity.this.toast(sVar.getMessage(), 5);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void c() {
                    for (int i3 = 0; i3 < QZoneSharingOwnersListActivity.this.f42552x0.size(); i3++) {
                        if (LoginData.getInstance().getUin() == ((i) QZoneSharingOwnersListActivity.this.f42552x0.get(i3)).f42600a) {
                            QZoneSharingOwnersListActivity.this.findViewById(R.id.aef).setVisibility(0);
                        }
                    }
                    if (this.f42556a != LoginData.getInstance().getUin()) {
                        QZoneSharingOwnersListActivity.this.findViewById(R.id.aef).setVisibility(8);
                    }
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QZoneSharingOwnersListActivity.this.Yi();
            QZoneSharingOwnersListActivity.this.runOnUiThread(new RunnableC03261(), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f42590a;

        a(int i3) {
            this.f42590a = i3;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            if (sVar.getSucceed()) {
                if (this.f42590a == 0) {
                    QZoneSharingOwnersListActivity.this.toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastInviteSend", "\u9080\u8bf7\u4fe1\u606f\u5df2\u53d1\u9001"), 5);
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(sVar.getMessage())) {
                QZoneSharingOwnersListActivity.this.toast(sVar.getMessage(), 4);
            } else {
                QZoneSharingOwnersListActivity.this.toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFailAndRetry", "\u64cd\u4f5c\u5931\u8d25\u8bf7\u91cd\u8bd5"), 4);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements ActionSheet.OnButtonClickListener {
        b() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            ActionMenuItem actionMenuItem = QZoneSharingOwnersListActivity.this.f42550v0.getActionMenuItem(i3);
            if (QZoneSharingOwnersListActivity.this.f42551w0 != null && QZoneSharingOwnersListActivity.this.f42551w0.albumtype == 12) {
                com.qzone.album.env.common.a.m().P(326, 14, "4", true, null);
            }
            switch (actionMenuItem.action) {
                case 204:
                    if (QZoneSharingOwnersListActivity.this.f42551w0 != null) {
                        if (QZoneSharingOwnersListActivity.this.f42551w0.albumtype == 11) {
                            com.qzone.album.env.common.a.m().z(QZoneSharingOwnersListActivity.this.getActivity(), -1, 14);
                            break;
                        } else if (QZoneSharingOwnersListActivity.this.f42551w0.getMaxCount() - QZoneSharingOwnersListActivity.this.f42551w0.getConfirmedSharingOwnersNumber() <= 0) {
                            com.qzone.album.env.common.a.m().W(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ReachMaxLimit", "\u76f8\u518c\u5171\u4eab\u4eba\u5df2\u8fbe\u4e0a\u9650"), 4);
                            break;
                        } else {
                            com.qzone.album.env.common.a.m().y(QZoneSharingOwnersListActivity.this.getActivity(), 1, QZoneSharingOwnersListActivity.this.f42551w0.getMaxCount() - QZoneSharingOwnersListActivity.this.f42551w0.getConfirmedSharingOwnersNumber(), -1, 12, QZoneSharingOwnersListActivity.this.f42551w0.getConfirmedSharingOwnersList(), false);
                            break;
                        }
                    } else {
                        return;
                    }
                case 205:
                    if (QZoneSharingOwnersListActivity.this.f42551w0 != null && QZoneSharingOwnersListActivity.this.A0 != null && QZoneSharingOwnersListActivity.this.f42553y0 != null && QZoneSharingOwnersListActivity.this.f42554z0 != null) {
                        ShareUtils.p(QZoneSharingOwnersListActivity.this.getActivity(), 23, QZoneSharingOwnersListActivity.this.A0, QZoneSharingOwnersListActivity.this.f42553y0, QZoneSharingOwnersListActivity.this.f42554z0, QZoneSharingOwnersListActivity.this.f42551w0.albumname);
                        break;
                    }
                    break;
                case 206:
                    QZoneAlbumUtil.y(QZoneSharingOwnersListActivity.this.getActivity(), QZoneSharingOwnersListActivity.this.f42551w0);
                    break;
            }
            ActionSheetHelper.dismissActionSheet(QZoneSharingOwnersListActivity.this.getActivity(), QZoneSharingOwnersListActivity.this.f42550v0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneSharingOwnersListActivity.this.Si();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneSharingOwnersListActivity.this.Ti();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneSharingOwnersListActivity.this.F0 = System.currentTimeMillis();
            if (QZoneSharingOwnersListActivity.this.F0 - QZoneSharingOwnersListActivity.this.E0 >= 800) {
                if (QZoneSharingOwnersListActivity.this.f42550v0 == null) {
                    QZoneSharingOwnersListActivity qZoneSharingOwnersListActivity = QZoneSharingOwnersListActivity.this;
                    qZoneSharingOwnersListActivity.f42550v0 = com.qzone.album.ui.widget.e.b(qZoneSharingOwnersListActivity.getActivity(), QZoneSharingOwnersListActivity.this.L0, QZoneSharingOwnersListActivity.this.f42551w0 != null ? QZoneSharingOwnersListActivity.this.f42551w0.albumtype : 1);
                }
                ActionSheetHelper.showActionSheet(QZoneSharingOwnersListActivity.this.getActivity(), QZoneSharingOwnersListActivity.this.f42550v0);
            }
            QZoneSharingOwnersListActivity qZoneSharingOwnersListActivity2 = QZoneSharingOwnersListActivity.this;
            qZoneSharingOwnersListActivity2.E0 = qZoneSharingOwnersListActivity2.F0;
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements AbsCompatRequest.a {
            a() {
            }

            @Override // com.qzone.album.protocol.AbsCompatRequest.a
            public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
                QZoneSharingOwnersListActivity.this.Vi(sVar);
            }
        }

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ApplyJoinShareAlbum applyJoinShareAlbum = new ApplyJoinShareAlbum();
            if (QZoneSharingOwnersListActivity.this.f42551w0.createSharingUin != 0) {
                applyJoinShareAlbum.owner = QZoneSharingOwnersListActivity.this.f42551w0.createSharingUin;
            } else {
                applyJoinShareAlbum.owner = QZoneSharingOwnersListActivity.this.f42551w0.ownerUin;
            }
            applyJoinShareAlbum.albumid = QZoneSharingOwnersListActivity.this.f42551w0.albumid;
            String str = "14";
            int i3 = 14;
            if (QZoneSharingOwnersListActivity.this.f42551w0.albumtype != 12 && QZoneSharingOwnersListActivity.this.f42551w0.albumtype != 8 && QZoneSharingOwnersListActivity.this.f42551w0.albumtype != 11 && QZoneSharingOwnersListActivity.this.f42551w0.albumtype != 9) {
                i3 = 0;
                str = "";
            }
            com.qzone.album.env.common.a.m().P(326, i3, str, true, null);
            com.qzone.album.base.Service.a.W().F0(QZoneSharingOwnersListActivity.this.f42540l0, 1, applyJoinShareAlbum, null, new a());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneSharingOwnersListActivity.this.F0 = System.currentTimeMillis();
            if (QZoneSharingOwnersListActivity.this.F0 - QZoneSharingOwnersListActivity.this.E0 >= 800) {
                if (QZoneSharingOwnersListActivity.this.f42550v0 == null) {
                    QZoneSharingOwnersListActivity qZoneSharingOwnersListActivity = QZoneSharingOwnersListActivity.this;
                    qZoneSharingOwnersListActivity.f42550v0 = com.qzone.album.ui.widget.e.b(qZoneSharingOwnersListActivity.getActivity(), QZoneSharingOwnersListActivity.this.L0, QZoneSharingOwnersListActivity.this.f42551w0 != null ? QZoneSharingOwnersListActivity.this.f42551w0.albumtype : 1);
                }
                ActionSheetHelper.showActionSheet(QZoneSharingOwnersListActivity.this.getActivity(), QZoneSharingOwnersListActivity.this.f42550v0);
            }
            QZoneSharingOwnersListActivity qZoneSharingOwnersListActivity2 = QZoneSharingOwnersListActivity.this;
            qZoneSharingOwnersListActivity2.E0 = qZoneSharingOwnersListActivity2.F0;
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class j extends SwipTextViewMenuBuilder {

        /* renamed from: a, reason: collision with root package name */
        private static final int[] f42606a = {R.string.f170822ak3};

        /* renamed from: b, reason: collision with root package name */
        private static final int[] f42607b = {R.color.f157028hz};

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f42608c = {R.id.epz};

        /* renamed from: d, reason: collision with root package name */
        private static int[] f42609d = {BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.ari)};

        @Override // com.tencent.widget.SwipRightMenuBuilder
        public void getRightMenuItemInfo(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
            SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[0];
            swipRightMenuItem.menuType = 0;
            swipRightMenuItem.menuId = 0;
        }

        public j() {
            super(1, 1, f42609d, -1, f42608c, f42606a, f42607b);
        }
    }

    private void Ri() {
        try {
            Dialog dialog = this.J0;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.I0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si() {
        AlbumDialog albumDialog = new AlbumDialog(getActivity(), R.style.qZoneInputDialog);
        albumDialog.setContentView(R.layout.bhq);
        albumDialog.X(2);
        albumDialog.setTitle(getString(R.string.gmx));
        AlbumCacheData albumCacheData = this.f42551w0;
        if (albumCacheData != null) {
            if (albumCacheData.isSharingAlbumCreator()) {
                albumDialog.Q(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoWillBeDelete", "\u4f60\u548c\u5171\u4eab\u4eba\u7684\u76f8\u518c\u90fd\u5c06\u88ab\u5220\u9664"));
            } else if (this.f42551w0.isSharingAlbumPartner()) {
                albumDialog.Q(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoDeleteSelf", "\u4ec5\u5220\u9664\u81ea\u5df1\u7684\u76f8\u518c,\u4f46\u4e0d\u4f1a\u5f71\u54cd\u5176\u4ed6\u4eba\u7684\u76f8\u518c"));
            } else {
                albumDialog.Q(getString(R.string.gmv));
            }
        } else {
            albumDialog.Q(getString(R.string.gmv));
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogDelete", "\u5220\u9664");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogCancel", "\u53d6\u6d88");
        albumDialog.a0(config, new d());
        albumDialog.Y(config2, new e());
        albumDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ti() {
        if (this.I0) {
            if (!checkNetworkConnect()) {
                ToastUtil.n(R.string.gdc);
                return;
            }
            if (this.f42551w0 != null) {
                this.I0 = false;
                bj(getString(R.string.gdm));
                HashMap hashMap = new HashMap();
                this.H0 = this.f42537i0;
                hashMap.put(12, this.f42537i0);
                hashMap.put(2, this.f42551w0.albumname);
                QZoneWriteOperationService.v0().W(getHandler(), "", "", "", 4, LoginData.getInstance().getUin(), this.f42537i0, "1", 0, hashMap, 26);
            }
        }
    }

    private int Ui() {
        AlbumCacheData albumCacheData = this.f42551w0;
        if (albumCacheData == null || albumCacheData.getConfirmedSharingOwnersNumber() >= this.f42551w0.getMaxCount() || !this.G0) {
            return 0;
        }
        AlbumCacheData albumCacheData2 = this.f42551w0;
        if (albumCacheData2.ownerUin == this.f42540l0) {
            return 1;
        }
        if (albumCacheData2.albumtype != 12) {
            return 0;
        }
        ArrayList<SharingAlbumClientAttr> arrayList = albumCacheData2.sharingAlbumClientAttrArrayList;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < this.f42551w0.sharingAlbumClientAttrArrayList.size(); i3++) {
                if (this.f42551w0.sharingAlbumClientAttrArrayList.get(i3) != null) {
                    long j3 = this.f42551w0.sharingAlbumClientAttrArrayList.get(i3).uin;
                    int i16 = this.f42551w0.sharingAlbumClientAttrArrayList.get(i3).uinAttr.status;
                    long j16 = this.f42540l0;
                    if (j16 == j3 && i16 == 2) {
                        return 0;
                    }
                    if (j16 == j3 && i16 == 6) {
                        return 3;
                    }
                }
            }
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vi(s sVar) {
        if (sVar.getSucceed()) {
            toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ApplySend", "\u5df2\u53d1\u9001\u7533\u8bf7\uff0c\u5f85\u521b\u5efa\u8005\u5ba1\u6838"), 5);
            runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (((QZoneTitleBarFragmentV2) QZoneSharingOwnersListActivity.this).E != null) {
                        ((QZoneTitleBarFragmentV2) QZoneSharingOwnersListActivity.this).E.setText(QZoneSharingOwnersListActivity.this.getResources().getString(R.string.gbi));
                        ((QZoneTitleBarFragmentV2) QZoneSharingOwnersListActivity.this).E.setOnClickListener(null);
                        ((QZoneTitleBarFragmentV2) QZoneSharingOwnersListActivity.this).E.setVisibility(0);
                    }
                }
            });
        } else if (!TextUtils.isEmpty(sVar.getMessage())) {
            toast(sVar.getMessage(), 4);
        } else {
            ToastUtil.g("request error", 4);
        }
    }

    private void Wi() {
        if (this.E != null) {
            int Ui = Ui();
            if (Ui == 0) {
                this.E.setOnClickListener(null);
                this.E.setVisibility(8);
                return;
            }
            if (Ui == 1) {
                this.E.setText(getResources().getString(R.string.gbh));
                h hVar = new h();
                this.M0 = hVar;
                this.E.setOnClickListener(hVar);
                this.E.setVisibility(0);
                return;
            }
            if (Ui == 2) {
                this.E.setText(getResources().getString(R.string.gbj));
                this.E.setOnClickListener(this.N0);
                this.E.setVisibility(0);
            } else {
                if (Ui != 3) {
                    return;
                }
                this.E.setText(getResources().getString(R.string.gbi));
                this.E.setOnClickListener(null);
                this.E.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yi() {
        if (TextUtils.isEmpty(this.f42537i0)) {
            return;
        }
        this.f42551w0 = AlbumCacheDataManager.J().x(LoginData.getInstance().getUin(), this.f42537i0);
    }

    private void Zi() {
        ArrayList<SharingAlbumClientAttr> j3 = this.f42548t0.j();
        if (j3 == null || j3.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < j3.size(); i3++) {
            if (!Xi(j3.get(i3).uin)) {
                this.f42551w0.sharingAlbumClientAttrArrayList.add(j3.get(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(int i3) {
        Zi();
        AlbumCacheData albumCacheData = this.f42551w0;
        com.qzone.album.base.Service.a.W().F(albumCacheData.createAlbumRequestModel(1, albumCacheData, -1), "", "", "", (byte) 0, new a(i3));
    }

    private void bj(String str) {
        Dialog dialog = this.J0;
        if (dialog == null || !dialog.isShowing()) {
            if (this.J0 == null) {
                ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.f174269ui);
                this.J0 = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                this.K0 = (TextView) this.J0.findViewById(R.id.dialogText);
                this.J0.findViewById(R.id.kja).setVisibility(8);
                this.J0.findViewById(R.id.cib).setVisibility(0);
            }
            this.K0.setText(str);
            this.J0.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj() {
        ArrayList<SharingAlbumClientAttr> arrayList;
        SharingOwnerUinAttr sharingOwnerUinAttr;
        if (this.f42552x0 == null) {
            this.f42552x0 = new ArrayList<>();
        }
        this.f42552x0.clear();
        AlbumCacheData albumCacheData = this.f42551w0;
        if (albumCacheData == null) {
            return;
        }
        if (this.f42541m0 == this.f42540l0 && (arrayList = albumCacheData.sharingAlbumClientAttrArrayList) != null && arrayList.size() > 0) {
            Iterator<SharingAlbumClientAttr> it = this.f42551w0.sharingAlbumClientAttrArrayList.iterator();
            while (it.hasNext()) {
                SharingAlbumClientAttr next = it.next();
                if (next != null && (sharingOwnerUinAttr = next.uinAttr) != null && sharingOwnerUinAttr.status == 6) {
                    i iVar = new i();
                    iVar.l(next.uin);
                    iVar.k(next.qq_nick);
                    iVar.f42604e = true;
                    iVar.j(false);
                    iVar.m(com.qzone.proxy.feedcomponent.util.c.e(next.uinAttr.add_time * 1000));
                    this.f42552x0.add(iVar);
                }
            }
        }
        ArrayList<ShareAlbumMemberCacheData> arrayList2 = this.f42551w0.shareAlbumMemberDataList;
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (int i3 = 0; i3 < this.f42551w0.shareAlbumMemberDataList.size(); i3++) {
                i iVar2 = new i();
                iVar2.l(this.f42551w0.shareAlbumMemberDataList.get(i3).uin);
                iVar2.k(this.f42551w0.shareAlbumMemberDataList.get(i3).nick);
                iVar2.m(l.a(R.string.s86) + (this.f42551w0.shareAlbumMemberDataList.get(i3).photo_cnt + this.f42551w0.shareAlbumMemberDataList.get(i3).video_cnt) + l.a(R.string.f172575s82));
                iVar2.j(false);
                this.f42552x0.add(iVar2);
            }
            return;
        }
        ArrayList<SharingAlbumClientAttr> arrayList3 = this.f42551w0.sharingAlbumClientAttrArrayList;
        if (arrayList3 != null && arrayList3.size() >= 1) {
            for (int i16 = 0; i16 < this.f42551w0.sharingAlbumClientAttrArrayList.size(); i16++) {
                if (this.f42551w0.sharingAlbumClientAttrArrayList.get(i16).uinAttr.status != 1 && this.f42551w0.sharingAlbumClientAttrArrayList.get(i16).uinAttr.status != 6) {
                    i iVar3 = new i();
                    iVar3.l(this.f42551w0.sharingAlbumClientAttrArrayList.get(i16).uin);
                    iVar3.k(this.f42551w0.sharingAlbumClientAttrArrayList.get(i16).qq_nick);
                    iVar3.j(true);
                    this.f42552x0.add(iVar3);
                }
            }
            return;
        }
        i iVar4 = new i();
        iVar4.l(this.f42541m0);
        iVar4.k(LoginData.getInstance().getNickName(""));
        iVar4.j(true);
        this.f42552x0.add(iVar4);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f42537i0 = intent.getStringExtra("SharingOwnersListAlbumId");
            this.f42541m0 = intent.getLongExtra("SharingOwnersListAlbumCreator", 0L);
            this.f42540l0 = intent.getLongExtra("SharingOwnersListAlbumLoginUin", 0L);
            this.G0 = intent.getBooleanExtra("needOpenAddFunction", true);
            if (intent.getBooleanExtra("hasInviteTroopSetting", false)) {
                this.f42553y0 = intent.getStringExtra("inviteTroopCover");
                this.f42554z0 = intent.getStringExtra("inviteTroopDesc");
                this.A0 = intent.getStringExtra("inviteTroopH5Url");
                this.B0 = intent.getStringExtra("inviteTroopSchema");
            }
        }
        this.f42538j0 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_SHARING_OWNERS_LIST_TITLE_BABY, QzoneConfig.DefaultValue.DEFAULT_SHARING_OWNERS_LIST_TITLE_BABY_ALBUM);
        this.f42539k0 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_SHARING_OWNERS_LIST_TITLE_REGULAR, QzoneConfig.DefaultValue.DEFAULT_SHARING_OWNERS_LIST_TITLE_REGULAR_ALBUM);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(new AnonymousClass1());
    }

    private void initUI() {
        String str;
        if (this.f42536h0 == 8) {
            str = this.f42538j0;
        } else {
            str = this.f42539k0;
        }
        setTitle(str);
        TextView textView = this.C;
        if (textView != null) {
            textView.setText("");
            this.C.setBackgroundResource(R.drawable.b5b);
            TextView textView2 = this.C;
            textView2.setPadding(0, textView2.getPaddingTop(), this.C.getPaddingRight(), this.C.getPaddingBottom());
            this.C.setVisibility(0);
        }
        Wi();
        SwipListView swipListView = (SwipListView) findViewById(R.id.irn);
        this.f42542n0 = swipListView;
        swipListView.setDragEnable(true);
        SharingOwnersListItemAdapter sharingOwnersListItemAdapter = new SharingOwnersListItemAdapter();
        this.f42548t0 = sharingOwnersListItemAdapter;
        sharingOwnersListItemAdapter.k(this.f42552x0);
        this.f42542n0.setAdapter((ListAdapter) this.f42548t0);
        this.f42549u0 = (RelativeLayout) findViewById(R.id.hrl);
        findViewById(R.id.aef).setOnClickListener(new c());
        findViewById(R.id.aef).setVisibility(8);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1 && i3 == 12 && intent != null) {
            cj(com.qzone.album.env.common.a.m().r(intent));
            if (!this.f42551w0.isSharingAlbumOnServer()) {
                AlbumCacheData albumCacheData = this.f42551w0;
                if (albumCacheData.createSharingUin <= 0) {
                    albumCacheData.createSharingUin = com.qzone.album.env.common.a.m().s();
                }
            }
            aj(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        QZoneResult unpack;
        super.onHandleMessage(message);
        Ri();
        if (message == null || (unpack = QZoneResult.unpack(message)) == null || message.what != 999909) {
            return;
        }
        if (unpack.getSucceed()) {
            ToastUtil.o(R.string.gmf, 5);
            Intent intent = new Intent();
            intent.putExtra(QZoneContant.KEY_EDIT_TYPE, "deleteAlbum");
            intent.putExtra(QZoneContant.KEY_DELETED_ALBUM_ID, this.H0);
            setResult(-1, intent);
            finish();
            return;
        }
        if (!TextUtils.isEmpty(unpack.getMessage())) {
            toast(unpack.getMessage(), 4);
        } else {
            toast(R.string.gme, 4);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public final class SharingOwnersListItemAdapter extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<i> f42560d;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<i> f42561e;

        /* renamed from: f, reason: collision with root package name */
        private ArrayList<i> f42562f;

        /* renamed from: h, reason: collision with root package name */
        private ActionSheet f42563h;

        /* renamed from: i, reason: collision with root package name */
        private ArrayList<SharingAlbumClientAttr> f42564i;

        /* renamed from: m, reason: collision with root package name */
        private int f42565m = 0;
        j C = new j();

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f42570d;

            a(long j3) {
                this.f42570d = j3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
                qZoneUserHomeBean.setUin(this.f42570d);
                ho.i.z().t(QZoneSharingOwnersListActivity.this.getActivity(), qZoneUserHomeBean);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class b implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f42572d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f42573e;

            /* compiled from: P */
            /* loaded from: classes39.dex */
            class a implements AbsCompatRequest.a {
                a() {
                }

                @Override // com.qzone.album.protocol.AbsCompatRequest.a
                public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
                    if (sVar.getSucceed()) {
                        SharingOwnerUinAttr shareUinAttr = QZoneSharingOwnersListActivity.this.f42551w0.getShareUinAttr(((i) SharingOwnersListItemAdapter.this.f42562f.get(b.this.f42573e)).h());
                        if (shareUinAttr != null) {
                            shareUinAttr.status = 2;
                        }
                        AlbumCacheDataManager.J().I0(QZoneSharingOwnersListActivity.this.f42551w0);
                        ((i) SharingOwnersListItemAdapter.this.f42562f.get(b.this.f42573e)).f42604e = false;
                        ((i) SharingOwnersListItemAdapter.this.f42562f.get(b.this.f42573e)).f42602c = "\u4e0a\u4f20\u4e860\u5f20";
                        ((i) SharingOwnersListItemAdapter.this.f42562f.get(b.this.f42573e)).f42603d = false;
                        SharingOwnersListItemAdapter.this.f42561e.add((i) SharingOwnersListItemAdapter.this.f42562f.get(b.this.f42573e));
                        SharingOwnersListItemAdapter.this.f42562f.remove(b.this.f42573e);
                        SharingOwnersListItemAdapter sharingOwnersListItemAdapter = SharingOwnersListItemAdapter.this;
                        sharingOwnersListItemAdapter.f42565m--;
                        if (SharingOwnersListItemAdapter.this.f42565m == 0 && QZoneSharingOwnersListActivity.this.f42549u0 != null) {
                            QZoneSharingOwnersListActivity.this.f42549u0.setVisibility(8);
                        }
                        SharingOwnersListItemAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    if (TextUtils.isEmpty(sVar.getMessage())) {
                        return;
                    }
                    QZoneSharingOwnersListActivity.this.toast(sVar.getMessage(), 5);
                }
            }

            b(long j3, int i3) {
                this.f42572d = j3;
                this.f42573e = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AllowJoinShareAlbumData allowJoinShareAlbumData = new AllowJoinShareAlbumData();
                allowJoinShareAlbumData.albumid = QZoneSharingOwnersListActivity.this.f42551w0.albumid;
                allowJoinShareAlbumData.joiner = this.f42572d;
                allowJoinShareAlbumData.owner = LoginData.getInstance().getUin();
                AllowJoinShareAlbum allowJoinShareAlbum = new AllowJoinShareAlbum();
                allowJoinShareAlbum.data = allowJoinShareAlbumData.toByteArray();
                allowJoinShareAlbum.source = 2;
                if (QZoneSharingOwnersListActivity.this.f42551w0.albumtype == 12) {
                    com.qzone.album.env.common.a.m().P(326, 14, "16", true, null);
                }
                com.qzone.album.base.Service.a.W().F0(LoginData.getInstance().getUin(), 2, null, allowJoinShareAlbum, new a());
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class c implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f42576d;

            c(int i3) {
                this.f42576d = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (QZoneSharingOwnersListActivity.this.f42551w0 != null && SharingOwnersListItemAdapter.this.f42562f != null && SharingOwnersListItemAdapter.this.f42562f != null && SharingOwnersListItemAdapter.this.f42562f.get(this.f42576d) != null) {
                    SharingAlbumClientAttr sharingAlbumClientAttr = QZoneSharingOwnersListActivity.this.f42551w0.getSharingAlbumClientAttr(((i) SharingOwnersListItemAdapter.this.f42562f.get(this.f42576d)).f42600a);
                    sharingAlbumClientAttr.action = 8;
                    if (SharingOwnersListItemAdapter.this.f42564i == null) {
                        SharingOwnersListItemAdapter.this.f42564i = new ArrayList();
                    }
                    SharingOwnersListItemAdapter.this.f42564i.add(sharingAlbumClientAttr);
                    QZoneSharingOwnersListActivity.this.aj(1);
                    SharingOwnersListItemAdapter.this.f42560d.remove(SharingOwnersListItemAdapter.this.f42562f.get(this.f42576d));
                    SharingOwnersListItemAdapter.this.f42562f.remove(this.f42576d);
                    SharingOwnersListItemAdapter.this.f42565m--;
                    if (SharingOwnersListItemAdapter.this.f42565m == 0 && QZoneSharingOwnersListActivity.this.f42549u0 != null) {
                        QZoneSharingOwnersListActivity.this.f42549u0.setVisibility(8);
                    }
                    SharingOwnersListItemAdapter.this.notifyDataSetChanged();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class d implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f42578d;

            d(int i3) {
                this.f42578d = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                SharingOwnersListItemAdapter sharingOwnersListItemAdapter = SharingOwnersListItemAdapter.this;
                sharingOwnersListItemAdapter.l(this.f42578d, sharingOwnersListItemAdapter.f42565m);
                com.qzone.album.env.common.a.m().P(326, 14, "6", true, null);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        SharingOwnersListItemAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(final int i3, final int i16) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ActionMenuItem(0, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ActionSheetDeleteMember", "\u5220\u9664\u6210\u5458"), 0, 0, 2));
            ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(QZoneSharingOwnersListActivity.this.getActivity(), arrayList, new ActionSheet.OnButtonClickListener() { // from class: com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity.SharingOwnersListItemAdapter.6
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public void onClick(View view, int i17) {
                    try {
                        SharingAlbumClientAttr sharingAlbumClientAttr = QZoneSharingOwnersListActivity.this.f42551w0.getSharingAlbumClientAttr(((i) SharingOwnersListItemAdapter.this.f42561e.get(i3 - i16)).f42600a);
                        sharingAlbumClientAttr.action = 8;
                        if (SharingOwnersListItemAdapter.this.f42564i == null) {
                            SharingOwnersListItemAdapter.this.f42564i = new ArrayList();
                        }
                        SharingOwnersListItemAdapter.this.f42564i.add(sharingAlbumClientAttr);
                        SharingOwnersListItemAdapter.this.f42560d.remove(SharingOwnersListItemAdapter.this.f42561e.get(i3 - i16));
                        SharingOwnersListItemAdapter.this.f42561e.remove(i3 - i16);
                        QZoneSharingOwnersListActivity.this.aj(1);
                        QZoneSharingOwnersListActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity.SharingOwnersListItemAdapter.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SharingOwnersListItemAdapter.this.notifyDataSetChanged();
                                SharingOwnersListItemAdapter.this.f42563h.dismiss();
                            }
                        }, 0L);
                        com.qzone.album.env.common.a.m().P(326, 14, "7", true, null);
                    } catch (Exception e16) {
                        com.qzone.proxy.feedcomponent.util.j.d(BaseFragment.TAG, "QzoneSharingOwnersListActivity delete error", e16);
                    }
                }
            });
            this.f42563h = createActionSheet;
            createActionSheet.addCancelButton(R.string.cancel);
            ActionSheetHelper.showActionSheet(QZoneSharingOwnersListActivity.this.getActivity(), this.f42563h);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<i> arrayList = this.f42560d;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            ArrayList<i> arrayList = this.f42560d;
            if (arrayList != null) {
                return arrayList.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            if (this.f42560d != null) {
                return r3.size();
            }
            return 0L;
        }

        public ArrayList<SharingAlbumClientAttr> j() {
            return this.f42564i;
        }

        public void k(ArrayList<i> arrayList) {
            if (arrayList == null || arrayList.size() < 1) {
                return;
            }
            this.f42560d = arrayList;
            this.f42561e = new ArrayList<>();
            this.f42562f = new ArrayList<>();
            Iterator<i> it = this.f42560d.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next.f42604e) {
                    this.f42562f.add(next);
                } else {
                    this.f42561e.add(next);
                }
            }
            this.f42565m = this.f42562f.size();
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class e implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f42580d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f42581e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f42582f;

            e(long j3, String str, long j16) {
                this.f42580d = j3;
                this.f42581e = str;
                this.f42582f = j16;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Intent I = ak.I(QZoneSharingOwnersListActivity.this.getActivity(), BusinessAlbumInfo.createFrom(QZoneSharingOwnersListActivity.this.f42551w0.albumid, QZoneSharingOwnersListActivity.this.f42551w0.albumtype, QZoneSharingOwnersListActivity.this.f42551w0.albumname, QZoneSharingOwnersListActivity.this.f42551w0.getLloc(), QZoneSharingOwnersListActivity.this.f42551w0.albumrights, QZoneSharingOwnersListActivity.this.f42551w0.albumnum, QZoneSharingOwnersListActivity.this.f42551w0.anonymity, QZoneSharingOwnersListActivity.this.f42551w0.individual, QZoneSharingOwnersListActivity.this.f42551w0.operatemask, QZoneSharingOwnersListActivity.this.f42551w0.allow_share, QZoneSharingOwnersListActivity.this.f42551w0.isSharingAlbumOnServer(), com.qzone.album.util.b.a(QZoneSharingOwnersListActivity.this.f42551w0), QZoneSharingOwnersListActivity.this.f42551w0.isSharingOwner), 3);
                I.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_GET_SHARER_PHOTO_LIST, true);
                I.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_GET_SHARER_PHOTO_LIST_UIN, this.f42580d);
                I.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_GET_SHARER_PHOTO_LIST_NICK, this.f42581e);
                I.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_GET_SHARER_PHOTO_LIST_COUNT, this.f42582f);
                QZoneSharingOwnersListActivity.this.startActivityForResult(I, 21);
                com.qzone.album.env.common.a.m().P(326, 14, "5", true, null);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            f fVar;
            String str;
            String str2;
            long j3;
            long j16;
            ArrayList<i> arrayList;
            if (view == null) {
                View inflate = LayoutInflater.from(QZoneSharingOwnersListActivity.this.getActivity()).inflate(R.layout.br_, (ViewGroup) null);
                f fVar2 = new f(inflate);
                View createView = this.C.createView(QZoneSharingOwnersListActivity.this.getActivity(), inflate, fVar2, -1);
                createView.setTag(fVar2);
                view2 = createView;
                fVar = fVar2;
            } else {
                view2 = view;
                fVar = (f) view.getTag();
            }
            int i16 = this.f42565m;
            if (i16 <= 0 || i3 >= i16) {
                if (i16 == 0 && QZoneSharingOwnersListActivity.this.f42549u0 != null) {
                    QZoneSharingOwnersListActivity.this.f42549u0.setVisibility(8);
                }
                ArrayList<i> arrayList2 = this.f42561e;
                if (arrayList2 != null && i3 - this.f42565m < arrayList2.size() && this.f42561e.get(i3 - this.f42565m) != null) {
                    int i17 = this.f42565m;
                    if (i3 == i17 && i17 != 0) {
                        fVar.F.setText(l.a(R.string.s8k));
                        fVar.E.setVisibility(0);
                    } else {
                        fVar.E.setVisibility(8);
                    }
                    fVar.f42585e.setVisibility(0);
                    j3 = this.f42561e.get(i3 - this.f42565m).h();
                    str = this.f42561e.get(i3 - this.f42565m).g();
                    str2 = this.f42561e.get(i3 - this.f42565m).i();
                    boolean f16 = this.f42561e.get(i3 - this.f42565m).f();
                    fVar.f42587h.setText(str);
                    fVar.f42588i.setText(str2);
                    if (j3 > 0) {
                        fVar.f42584d.loadAvatar(j3);
                    }
                    if (!f16) {
                        fVar.f42588i.setVisibility(0);
                        fVar.f42589m.setVisibility(0);
                    } else {
                        fVar.f42588i.setVisibility(8);
                        fVar.f42589m.setVisibility(8);
                    }
                    fVar.G.setVisibility(8);
                } else {
                    str = "";
                    str2 = "\u4e0a\u4f20\u4e860\u5f20";
                    j3 = 0;
                }
                String str3 = str2;
                String str4 = str;
                if (QZoneSharingOwnersListActivity.this.f42541m0 == QZoneSharingOwnersListActivity.this.f42540l0 && (arrayList = this.f42561e) != null && i3 - this.f42565m < arrayList.size() && this.f42561e.get(i3 - this.f42565m) != null && QZoneSharingOwnersListActivity.this.f42541m0 != this.f42561e.get(i3 - this.f42565m).h()) {
                    QZoneSharingOwnersListActivity.this.f42543o0 = new d(i3);
                    fVar.D.setOnClickListener(QZoneSharingOwnersListActivity.this.f42543o0);
                    fVar.f42586f.setVisibility(0);
                } else {
                    fVar.f42586f.setVisibility(8);
                }
                if (!TextUtils.isEmpty(str3) && str3.startsWith(l.a(R.string.f172581s94))) {
                    try {
                        j16 = Long.parseLong(str3.substring(l.a(R.string.s8v).length(), str3.length() - l.a(R.string.s8i).length()));
                    } catch (Exception unused) {
                    }
                    QZoneSharingOwnersListActivity.this.f42544p0 = new e(j3, str4, j16);
                    fVar.C.setOnClickListener(QZoneSharingOwnersListActivity.this.f42544p0);
                    fVar.f42584d.setOnClickListener(QZoneSharingOwnersListActivity.this.f42544p0);
                }
                j16 = 0;
                QZoneSharingOwnersListActivity.this.f42544p0 = new e(j3, str4, j16);
                fVar.C.setOnClickListener(QZoneSharingOwnersListActivity.this.f42544p0);
                fVar.f42584d.setOnClickListener(QZoneSharingOwnersListActivity.this.f42544p0);
            } else {
                fVar.E.setVisibility(8);
                if (i3 == 0 && QZoneSharingOwnersListActivity.this.f42549u0 != null) {
                    QZoneSharingOwnersListActivity.this.f42549u0.setVisibility(0);
                }
                if (i3 == this.f42565m - 1) {
                    fVar.f42585e.setVisibility(8);
                }
                long h16 = this.f42562f.get(i3).h();
                fVar.f42587h.setText(this.f42562f.get(i3).g());
                if (h16 > 0) {
                    fVar.f42584d.loadAvatar(h16);
                }
                fVar.f42588i.setText(this.f42562f.get(i3).i());
                fVar.f42588i.setVisibility(0);
                fVar.f42589m.setVisibility(0);
                fVar.f42586f.setVisibility(8);
                fVar.G.setVisibility(0);
                QZoneSharingOwnersListActivity.this.f42547s0 = new a(h16);
                QZoneSharingOwnersListActivity.this.f42545q0 = new b(h16, i3);
                QZoneSharingOwnersListActivity.this.f42546r0 = new c(i3);
                fVar.D.setOnClickListener(QZoneSharingOwnersListActivity.this.f42545q0);
                fVar.C.setOnClickListener(QZoneSharingOwnersListActivity.this.f42547s0);
                fVar.f42584d.setOnClickListener(QZoneSharingOwnersListActivity.this.f42547s0);
                this.C.updateRightMenuView(QZoneSharingOwnersListActivity.this.getActivity(), view2, i3, this.f42562f, fVar, QZoneSharingOwnersListActivity.this.f42546r0);
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class f extends SwipRightMenuBuilder.SwipItemBaseHolder implements View.OnClickListener {
            LinearLayout C;
            RelativeLayout D;
            RelativeLayout E;
            TextView F;
            TextView G;

            /* renamed from: d, reason: collision with root package name */
            AvatarImageView f42584d;

            /* renamed from: e, reason: collision with root package name */
            ImageView f42585e;

            /* renamed from: f, reason: collision with root package name */
            ImageView f42586f;

            /* renamed from: h, reason: collision with root package name */
            TextView f42587h;

            /* renamed from: i, reason: collision with root package name */
            TextView f42588i;

            /* renamed from: m, reason: collision with root package name */
            View f42589m;

            public f(View view) {
                this.f42584d = (AvatarImageView) view.findViewById(R.id.hrc);
                this.f42585e = (ImageView) view.findViewById(R.id.hrd);
                this.f42586f = (ImageView) view.findViewById(R.id.hrf);
                this.f42587h = (TextView) view.findViewById(R.id.hrh);
                this.f42588i = (TextView) view.findViewById(R.id.hrj);
                this.f42589m = view.findViewById(R.id.hri);
                this.C = (LinearLayout) view.findViewById(R.id.hre);
                this.D = (RelativeLayout) view.findViewById(R.id.hrg);
                this.E = (RelativeLayout) view.findViewById(R.id.hrk);
                this.F = (TextView) view.findViewById(R.id.hrm);
                this.G = (TextView) view.findViewById(R.id.hrb);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i {

        /* renamed from: a, reason: collision with root package name */
        private long f42600a;

        /* renamed from: b, reason: collision with root package name */
        private String f42601b;

        /* renamed from: c, reason: collision with root package name */
        private String f42602c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f42603d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f42604e = false;

        public i() {
        }

        public boolean f() {
            return this.f42603d;
        }

        public String g() {
            return this.f42601b;
        }

        public long h() {
            return this.f42600a;
        }

        public String i() {
            return this.f42602c;
        }

        public void j(boolean z16) {
            this.f42603d = z16;
        }

        public void k(String str) {
            this.f42601b = str;
        }

        public void l(long j3) {
            this.f42600a = j3;
        }

        public void m(String str) {
            this.f42602c = str;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof i)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            i iVar = (i) obj;
            return this.f42600a == iVar.f42600a && this.f42601b.equals(iVar.f42601b);
        }
    }

    private boolean Xi(long j3) {
        for (int i3 = 0; i3 < this.f42551w0.sharingAlbumClientAttrArrayList.size(); i3++) {
            if (this.f42551w0.sharingAlbumClientAttrArrayList.get(i3).uin == j3) {
                return true;
            }
        }
        return false;
    }

    private void cj(ArrayList<s4.b> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            s4.b bVar = arrayList.get(i3);
            if (!Xi(bVar.f433292a)) {
                this.f42551w0.sharingAlbumClientAttrArrayList.add(new SharingAlbumClientAttr(bVar.f433292a, new SharingOwnerUinAttr(), bVar.f433293b, 4));
            }
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Rh(layoutInflater, R.layout.biw, viewGroup);
    }
}
