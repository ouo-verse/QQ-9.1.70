package com.qzone.album.business.albumlist.fragment;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_PHOTO.Album;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment;
import com.qzone.album.business.photolist.adapter.w;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneAlbumListRequest;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.album.util.l;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.albumx.qzone.vas.event.QZonePhotoDegradeEvent;
import com.qzone.reborn.albumx.qzone.vas.widget.QZoneVasTopTipsView;
import com.qzone.reborn.base.n;
import com.qzone.util.image.ImageInfo;
import com.qzone.widget.AsyncMarkImageView;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.qcircle.api.event.QFSDeleteQZoneVideoAlbumEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.weiyun.AlbumBackupProxyActivity;
import ho.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import qzone.QZonePhotoDegrade$Button;
import qzone.QZonePhotoDegrade$NotifyMsg;
import qzone.QZonePhotoDegrade$QueryNotifyMsgRsp;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumListTabFragment extends AlbumBaseTabFragment implements IObserver.main, View.OnClickListener, SimpleEventReceiver {
    private int A0;
    private int B0;
    private int C0;
    private g D0;
    private Animation H0;
    private List<ImageInfo> I0;
    private int J0;
    private int K0;
    private View N0;
    private String R0;
    protected BroadcastReceiver S0;
    private View V0;

    /* renamed from: s0, reason: collision with root package name */
    private List<AlbumCacheData> f42279s0;

    /* renamed from: t0, reason: collision with root package name */
    private AlbumCacheData f42280t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f42281u0;

    /* renamed from: v0, reason: collision with root package name */
    private ArrayList<String> f42282v0;

    /* renamed from: w0, reason: collision with root package name */
    private GridView f42283w0;

    /* renamed from: x0, reason: collision with root package name */
    private TextView f42284x0;

    /* renamed from: y0, reason: collision with root package name */
    private TextView f42285y0;

    /* renamed from: z0, reason: collision with root package name */
    private RelativeLayout f42286z0;

    /* renamed from: r0, reason: collision with root package name */
    private final String f42278r0 = getClass().getSimpleName();
    private int E0 = 100;
    private int F0 = 100;
    public boolean G0 = false;
    private boolean L0 = false;
    private List<AlbumCacheData[]> M0 = new ArrayList();
    private boolean O0 = false;
    private boolean P0 = false;
    private boolean Q0 = false;
    private boolean T0 = false;
    private int U0 = -1;
    private boolean W0 = false;
    private Animation.AnimationListener X0 = new a();

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.albumlist.fragment.AlbumListTabFragment$4, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ AlbumListTabFragment this$0;

        /* compiled from: P */
        /* renamed from: com.qzone.album.business.albumlist.fragment.AlbumListTabFragment$4$a */
        /* loaded from: classes39.dex */
        class a implements AbsCompatRequest.a {

            /* compiled from: P */
            /* renamed from: com.qzone.album.business.albumlist.fragment.AlbumListTabFragment$4$a$a, reason: collision with other inner class name */
            /* loaded from: classes39.dex */
            class DialogInterfaceOnClickListenerC0315a implements DialogInterface.OnClickListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f42288d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Activity f42289e;

                DialogInterfaceOnClickListenerC0315a(String str, Activity activity) {
                    this.f42288d = str;
                    this.f42289e = activity;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    if (TextUtils.isEmpty(this.f42288d)) {
                        dialogInterface.dismiss();
                    } else {
                        yo.d.b(this.f42289e, new yo.g(this.f42288d));
                    }
                }
            }

            a() {
            }

            @Override // com.qzone.album.protocol.AbsCompatRequest.a
            public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
                Map<Integer, ArrayList<tAdvDesc>> map;
                tAdvDesc tadvdesc;
                if (!sVar.getSucceed() || !(sVar.getData() instanceof QzoneQBossAdvRequest.a) || (map = ((QzoneQBossAdvRequest.a) sVar.getData()).f48461b) == null || map.get(2534) == null || (tadvdesc = map.get(2534).get(0)) == null) {
                    return;
                }
                try {
                    AlbumBaseTabFragment.j jVar = AnonymousClass4.this.this$0.C;
                    Activity hostActivity = jVar == null ? null : jVar.getHostActivity();
                    JSONObject jSONObject = new JSONObject(tadvdesc.res_data);
                    com.qzone.album.ui.widget.b bVar = new com.qzone.album.ui.widget.b(hostActivity, R.style.qZoneInputDialog);
                    bVar.setContentView(R.layout.f169002bk0);
                    bVar.Q(jSONObject.optString("imgURL"));
                    bVar.setTitle(jSONObject.optString("title"));
                    bVar.N(jSONObject.optString(SecretUtils.DES));
                    bVar.O(3);
                    bVar.setCanceledOnTouchOutside(true);
                    bVar.P(jSONObject.optString("buttonText"), new DialogInterfaceOnClickListenerC0315a(jSONObject.optString("buttonURL"), hostActivity));
                    bVar.show();
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(tadvdesc.res_traceinfo, LoginData.getInstance().getUinString());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qzone.proxy.feedcomponent.b.a(this.this$0.f42278r0, "send Qboss getQbossForAlbumDialog");
            this.this$0.R.r0(new a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends AnimateUtils.AnimationAdapter {
        a() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (AlbumListTabFragment.this.f42286z0 != null) {
                AlbumListTabFragment.this.f42286z0.setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof String)) {
                return;
            }
            String str = (String) tag;
            if (AlbumListTabFragment.this.f42282v0 != null) {
                if (AlbumListTabFragment.this.f42282v0.contains(str)) {
                    if (AlbumListTabFragment.this.f42282v0.remove(str)) {
                        AlbumListTabFragment.this.Ej();
                    }
                } else if (AlbumListTabFragment.this.f42282v0.add(str)) {
                    AlbumListTabFragment.this.Dj();
                }
                if (AlbumListTabFragment.this.D0 != null) {
                    AlbumListTabFragment.this.D0.notifyDataSetChanged();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements w.e {
        e() {
        }

        @Override // com.qzone.album.business.photolist.adapter.w.e
        public void onClick(View view) {
            QZoneAlbumUtil.J(view);
            Object tag = view.getTag();
            String str = "";
            if (tag != null && (tag instanceof AlbumCacheData)) {
                AlbumCacheData albumCacheData = (AlbumCacheData) tag;
                if (albumCacheData.isToppedAlbum) {
                    LpReportInfo_pf00064.allReport(326, 1, 4);
                }
                AlbumListTabFragment albumListTabFragment = AlbumListTabFragment.this;
                albumListTabFragment.G0 = false;
                albumListTabFragment.f42280t0 = albumCacheData;
                if (QZLog.isDevelopLevel()) {
                    QZLog.d(AlbumListTabFragment.this.f42278r0, 4, "onListViewItemClick albumName=" + albumCacheData.albumname + "; anonymity=" + albumCacheData.anonymity);
                }
                if (!AlbumListTabFragment.this.P2()) {
                    int i3 = albumCacheData.albumtype;
                    if (i3 != 21) {
                        if (i3 == 102) {
                            AlbumListTabFragment.this.O0 = true;
                            AlbumBackupProxyActivity.F2(AlbumListTabFragment.this.getActivity(), LoginData.getInstance().getUinString(), "source_from_qzone");
                        } else if (albumCacheData.actiontype == 2 && !TextUtils.isEmpty(albumCacheData.actionUrl)) {
                            t4.a.N().y(AlbumListTabFragment.this, albumCacheData.actionUrl, null);
                        } else {
                            com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "onListViewItemClick start");
                            AlbumListTabFragment.this.oj(albumCacheData);
                            String pj5 = AlbumListTabFragment.this.pj();
                            if (!TextUtils.isEmpty(pj5)) {
                                if (pj5.equals(QzoneVideoBeaconReport.EVENT_ALBUM_BANNER)) {
                                    str = QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ALBUM;
                                } else if (pj5.equals(QzoneVideoBeaconReport.EVENT_ALBUM_LIST)) {
                                    str = QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ALBUM;
                                } else {
                                    str = QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ALBUM;
                                }
                            }
                            QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), str);
                        }
                    }
                } else if (!com.qzone.album.util.d.f(AlbumListTabFragment.this.f42280t0.albumrights) || AlbumListTabFragment.this.f42280t0.allowAccess) {
                    AlbumListTabFragment.this.oj(albumCacheData);
                } else {
                    AlbumListTabFragment albumListTabFragment2 = AlbumListTabFragment.this;
                    albumListTabFragment2.nj(albumListTabFragment2.f42280t0, 0, null);
                }
                if (AlbumListTabFragment.this.f42280t0 != null) {
                    com.qzone.album.env.common.a.m().P(Integer.valueOf("326").intValue(), Integer.valueOf("1").intValue(), "26", true, String.valueOf(AlbumListTabFragment.this.f42280t0.getAlbumThemeTypeValue()), String.valueOf(AlbumListTabFragment.this.f42280t0.anonymity));
                }
                AlbumListTabFragment.this.sj(albumCacheData);
                return;
            }
            if (tag != null && (tag instanceof String) && QZoneOptAlbumRequest.FIELD_CMD_CREATE.equals(tag)) {
                AlbumListTabFragment.this.G0 = false;
                eo.c.f396879a.b();
                if (!t4.a.N().m()) {
                    AlbumListTabFragment.this.mj(0);
                    return;
                }
                t4.a N = t4.a.N();
                AlbumListTabFragment albumListTabFragment3 = AlbumListTabFragment.this;
                if (albumListTabFragment3.N != null) {
                    str = t4.a.N().R(AlbumListTabFragment.this.N);
                }
                N.f(albumListTabFragment3, str, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            AlbumListTabFragment.this.N0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int screenHeight = ViewUtils.getScreenHeight();
            int[] iArr = new int[2];
            AlbumListTabFragment.this.N0.getLocationOnScreen(iArr);
            int height = (screenHeight - iArr[1]) - AlbumListTabFragment.this.N0.getHeight();
            if (height > 0) {
                int paddingLeft = AlbumListTabFragment.this.N0.getPaddingLeft();
                int paddingTop = AlbumListTabFragment.this.N0.getPaddingTop();
                AlbumListTabFragment.this.N0.setPadding(paddingLeft, paddingTop + height, AlbumListTabFragment.this.N0.getPaddingRight(), AlbumListTabFragment.this.N0.getPaddingBottom());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Aj(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        i.q(getActivity(), str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        na.c.f419539a.c(1);
        uj();
        EventCollector.getInstance().onViewClicked(view);
    }

    private View Cj(boolean z16) {
        if (this.C == null) {
            QZLog.e(this.f42278r0, 1, "[newPhotoNumTipsFooterView] tab operator should not be null.");
            return null;
        }
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PHOTO_ALBUM_PHOTO_NUM_TIPS, QzoneConfig.DefaultValue.DEFAULT_PHOTO_ALBUM_PHOTO_NUM_TIPS);
        LinearLayout linearLayout = new LinearLayout(this.C.getHostActivity());
        linearLayout.setPadding(0, ViewUtils.dpToPx(20.0f), 0, ViewUtils.dpToPx(20.0f));
        View view = new View(this.C.getHostActivity());
        view.setBackgroundColor(-6250336);
        View view2 = new View(this.C.getHostActivity());
        view2.setBackgroundColor(-6250336);
        TextView textView = new TextView(this.C.getHostActivity());
        textView.setTextColor(-6250336);
        textView.setTextSize(11.0f);
        textView.setText(config);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 1);
        layoutParams.gravity = 16;
        layoutParams.weight = 1.0f;
        layoutParams.leftMargin = ViewUtils.dpToPx(52.0f);
        layoutParams.rightMargin = ViewUtils.dpToPx(9.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 1);
        layoutParams2.gravity = 16;
        layoutParams2.weight = 1.0f;
        layoutParams2.leftMargin = ViewUtils.dpToPx(9.0f);
        layoutParams2.rightMargin = ViewUtils.dpToPx(52.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.addView(view, layoutParams);
        linearLayout.addView(textView, layoutParams3);
        linearLayout.addView(view2, layoutParams2);
        linearLayout.setVisibility(z16 ? 8 : 0);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dj() {
        Pj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej() {
        Pj();
    }

    private void Fj() {
        t4.a.N().x(this);
    }

    private void Gj() {
        Long l3 = this.P;
        if (l3 != null && l3.longValue() == com.qzone.album.env.common.a.m().s()) {
            na.c.f419539a.i(1, new b());
        } else {
            RFWLog.d(this.f42278r0, RFWLog.USR, "requestPhotoDegradeNotify fail: guest user");
        }
    }

    private void Ij() {
        View view = this.N0;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jj(String str, String str2, String str3) {
        if (getActivity() == null) {
            return;
        }
        if (this.V0 == null) {
            View yj5 = yj(str, str2, str3);
            this.V0 = yj5;
            this.J.addHeaderView(yj5);
        }
        this.V0.setVisibility(0);
    }

    private boolean Kj() {
        RelativeLayout relativeLayout = this.f42286z0;
        if (relativeLayout == null || relativeLayout.getVisibility() == 0) {
            return false;
        }
        this.f42286z0.setVisibility(0);
        return true;
    }

    private void Mj(String str, String str2) {
        AlbumCacheData x16 = this.S.x(this.P.longValue(), str);
        if (x16 != null) {
            x16.coverUrl.url = str2;
            this.S.I0(x16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nj(String str, String str2) {
        for (AlbumCacheData albumCacheData : this.f42279s0) {
            if (albumCacheData.albumid.equalsIgnoreCase(str) && !TextUtils.isEmpty(albumCacheData.coverUrl.url) && albumCacheData.coverUrl.url.contains("no_photo")) {
                AlbumBaseTabFragment.j jVar = this.C;
                String b16 = l.b(jVar != null ? jVar.getHostActivity() : null, str2);
                if (!TextUtils.isEmpty(b16)) {
                    albumCacheData.coverUrl.url = b16;
                    Mj(str, b16);
                    return;
                } else {
                    albumCacheData.coverUrl.url = str2;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oj(int[] iArr) {
        EventCenter.getInstance().post("QzoneAlbum", 18, iArr);
    }

    private void Pj() {
        int size = this.f42282v0.size();
        if (size > 0) {
            this.f42284x0.setEnabled(true);
            Hj(String.format(getResources().getString(R.string.gjt), Integer.valueOf(size)));
            TextView textView = this.f42284x0;
            int i3 = this.C0;
            textView.setPadding(i3, 0, i3, 0);
            return;
        }
        this.f42284x0.setEnabled(false);
        Hj(getString(R.string.gpd));
        TextView textView2 = this.f42284x0;
        int i16 = this.B0;
        textView2.setPadding(i16, 0, i16, 0);
    }

    private void jj() {
        t4.a.N().n(this);
    }

    private void kj() {
        int count;
        g gVar = this.D0;
        if (gVar == null || (count = gVar.getCount()) <= 0) {
            return;
        }
        this.f42283w0.setNumColumns(count);
        ViewGroup.LayoutParams layoutParams = this.f42283w0.getLayoutParams();
        layoutParams.width = (this.E0 * count) + ((count - 1) * this.A0);
        this.f42283w0.setLayoutParams(layoutParams);
        this.D0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj() {
        if (this.f42279s0 == null) {
            return;
        }
        AlbumCacheData[] albumCacheDataArr = new AlbumCacheData[qj()];
        int size = this.f42279s0.size();
        if (size == 0) {
            return;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            AlbumCacheData albumCacheData = this.f42279s0.get(i16);
            if (i16 == 0) {
                if (!P2()) {
                    albumCacheDataArr[i3] = null;
                    i3++;
                } else {
                    albumCacheDataArr[i3] = albumCacheData;
                    i3++;
                }
            }
            if (i3 % qj() == 0) {
                this.M0.add(albumCacheDataArr);
                albumCacheDataArr = new AlbumCacheData[qj()];
                i3 = 0;
            }
            albumCacheDataArr[i3] = albumCacheData;
            i3++;
        }
        this.M0.add(albumCacheDataArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(int i3) {
        String str;
        t4.a N = t4.a.N();
        if (this.N != null) {
            str = t4.a.N().R(this.N);
        } else {
            str = "";
        }
        startActivityForResult(N.p(this, str), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(AlbumCacheData albumCacheData) {
        t4.a.N().o(this, albumCacheData, this.P.longValue());
    }

    private int qj() {
        if (this.U0 <= 0) {
            this.U0 = pl.a.f426446a.a(getApplicationContext(), getResources().getDimensionPixelSize(R.dimen.ao9), 2);
        }
        return this.U0;
    }

    private void tj(QFSDeleteQZoneVideoAlbumEvent qFSDeleteQZoneVideoAlbumEvent) {
        QLog.d(this.f42278r0, 1, "[handleQFSDeleteQZoneVideoAlbumEvent]  | mIsDeleteAll=" + qFSDeleteQZoneVideoAlbumEvent.isDeleteAll() + " | mFeedId=" + qFSDeleteQZoneVideoAlbumEvent.getFeedId());
        c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        View view = this.V0;
        if (view != null) {
            view.setVisibility(8);
            QZonePullToRefreshListView qZonePullToRefreshListView = this.J;
            if (qZonePullToRefreshListView != null) {
                qZonePullToRefreshListView.removeHeaderView(this.V0);
            }
        }
    }

    private boolean wj() {
        RelativeLayout relativeLayout = this.f42286z0;
        if (relativeLayout == null || relativeLayout.getVisibility() == 8) {
            return false;
        }
        this.f42286z0.startAnimation(this.H0);
        return true;
    }

    private void xj() {
        this.S0 = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(QZoneJsConstants.BROADCAST_ACTION_REFRESH_ALBUM_LIST);
        AlbumBaseTabFragment.j jVar = this.C;
        Activity hostActivity = jVar == null ? null : jVar.getHostActivity();
        if (hostActivity != null) {
            hostActivity.registerReceiver(this.S0, intentFilter);
            this.T0 = true;
        } else {
            QZLog.d(this.f42278r0, 1, "[initBroadcastReceiver] activity should not be null.");
        }
    }

    private View yj(String str, String str2, final String str3) {
        QZoneVasTopTipsView qZoneVasTopTipsView = new QZoneVasTopTipsView(getActivity());
        qZoneVasTopTipsView.setContent(str);
        qZoneVasTopTipsView.setActionText(str2);
        qZoneVasTopTipsView.setJumpListener(new View.OnClickListener() { // from class: com.qzone.album.business.albumlist.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlbumListTabFragment.this.Aj(str3, view);
            }
        });
        qZoneVasTopTipsView.setCloseListener(new View.OnClickListener() { // from class: com.qzone.album.business.albumlist.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlbumListTabFragment.this.Bj(view);
            }
        });
        return qZoneVasTopTipsView;
    }

    private void zj() {
        t4.a.N().t(this, this.f42282v0);
        this.G0 = false;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Ah() {
        t4.a.N().r(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void Bh() {
        super.Bh();
        com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", this.f42278r0, " doGetMore start");
        if (this.R == null || !t4.a.N().O(Fh())) {
            return;
        }
        this.R.b0(this.P.longValue(), this.f42256o0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void Bi() {
        super.Bi();
        if (ei() && QZLog.isColorLevel()) {
            QZLog.d(this.f42278r0, 2, "subInitUI checkPhotosGuideBanner");
        }
        this.f42243b0 = (ImageView) this.D.findViewById(R.id.q_);
        vi("qzone_album_list_loading_img");
        if (AlbumPersonalizeManager.L().Q() && getActivity() != null) {
            s5.a.d(this.f42243b0, getActivity(), R.drawable.nwl, ImageView.ScaleType.FIT_XY);
        }
        com.qzone.album.business.photolist.adapter.c cVar = this.K;
        if (cVar != null) {
            ((w) cVar).u(this.J);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public int Ch() {
        return R.layout.f169026bo2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void Di(AbsListView absListView, int i3) {
        super.Di(absListView, i3);
        if (getCurrentActivity() != null) {
            mc.c.f416541a.b(i3, new com.tencent.qqnt.avatar.meta.refresh.c<>(getCurrentActivity().getWindow()), this.f42278r0, "qzone_album_monitor_key_detail_tab_album_list");
        }
        if (i3 == 2) {
            wj();
            ((w) this.K).w();
        } else {
            ((w) this.K).v();
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public String Fh() {
        return "KEY_ALBUMLIST_HASMORE_PRE_" + this.P + "_" + com.qzone.album.env.common.a.m().s();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Fi() {
        int count;
        com.qzone.album.business.photolist.adapter.c cVar = this.K;
        if (cVar != null && (count = cVar.getCount()) > 0) {
            if (t4.a.N().O(Fh())) {
                ri(5);
                View view = this.N0;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.N0 != null) {
                ri(3);
                if (count <= 2) {
                    Ij();
                }
                this.N0.setVisibility(0);
                if (this.Q0) {
                    LpReportInfo_pf00064.allReport(326, 1, 1);
                    return;
                }
                return;
            }
            xi(count);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected String Gh() {
        return "qzone_album_old_album_list";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void Nh(s sVar) {
        super.Nh(sVar);
        if (sVar == null || !sVar.getSucceed()) {
            return;
        }
        QZoneAlbumListRequest.a aVar = (QZoneAlbumListRequest.a) sVar.getData();
        this.Q0 = aVar.f43894j;
        this.R0 = aVar.f43895k;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Vh() {
        if (this.C == null) {
            return;
        }
        w wVar = new w(this.C.getHostActivity(), this.M0, qj());
        this.K = wVar;
        wVar.s(new e());
        ((w) this.K).r(P2());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public boolean ai(boolean z16) {
        if (this.C == null) {
            return false;
        }
        boolean ai5 = super.ai(z16);
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PHOTO_ALBUM_PHOTO_NUM_TIPS_FLAG, 1);
        if (this.N0 == null && config == 1) {
            this.N0 = Cj(true);
            this.J.j0().addFooterView(this.N0);
        }
        return ai5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void c0() {
        if (this.C == null || this.P == null) {
            return;
        }
        super.c0();
        if (this.N != null && !TextUtils.isEmpty(t4.a.N().R(this.N))) {
            String Q = t4.a.N().Q(this.N);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("need_album_area", "1");
            this.R.j1(this.P.longValue(), Q, 2, hashMap, this.f42255n0);
        } else {
            this.R.k1(this.P.longValue(), null, this.f42255n0);
        }
        Gj();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void di() {
        if (this.C == null) {
            return;
        }
        com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumListTabFragment.7
            @Override // java.lang.Runnable
            public void run() {
                AlbumListTabFragment albumListTabFragment = AlbumListTabFragment.this;
                final ArrayList<AlbumCacheData> z16 = albumListTabFragment.S.z(albumListTabFragment.P.longValue());
                final int[] L = com.qzone.album.base.Service.a.W().L(AlbumListTabFragment.this.P.longValue());
                if (z16 != null) {
                    AlbumListTabFragment.this.C.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumListTabFragment.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AlbumListTabFragment.this.f42279s0.clear();
                            AlbumListTabFragment.this.f42279s0.addAll(z16);
                            AlbumListTabFragment.this.M0.clear();
                            AlbumListTabFragment.this.lj();
                            AlbumListTabFragment.this.K.notifyDataSetChanged();
                            AlbumListTabFragment.this.Fi();
                            AlbumListTabFragment.this.Oj(L);
                            if (z16.size() > 0) {
                                AlbumListTabFragment.this.Rh();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected boolean ei() {
        return this.f42281u0 == 0;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected boolean enableDaTongPageRegister() {
        return true;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        int i3;
        HashMap hashMap = new HashMap();
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra("refer");
            if (TextUtils.equals(stringExtra, QZoneHelper.QZoneAppConstants.REFER_QQ_SETTING)) {
                i3 = 1;
            } else if (TextUtils.equals(stringExtra, "getActiveFeeds")) {
                i3 = 2;
            } else if (TextUtils.equals(stringExtra, "getMainPage")) {
                i3 = P2() ? 4 : 3;
            } else {
                i3 = 0;
            }
            hashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(i3));
        }
        return hashMap;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected String getDaTongPageId() {
        return "pg_qz_space_album_list";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZonePhotoDegradeEvent.class);
        arrayList.add(QFSDeleteQZoneVideoAlbumEvent.class);
        return arrayList;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected String getTagName() {
        return this.f42278r0;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void ii(s sVar, int i3) {
        com.qzone.proxy.feedcomponent.b.a(this.f42278r0, "onHandleMessage, what: " + i3);
        super.ii(sVar, i3);
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            vj();
            return;
        }
        ((ViewStub) this.D.findViewById(R.id.abr)).inflate();
        this.f42286z0 = (RelativeLayout) this.D.findViewById(R.id.abq);
        TextView textView = (TextView) this.D.findViewById(R.id.k6q);
        this.f42284x0 = textView;
        textView.setEnabled(false);
        this.f42284x0.setOnClickListener(this);
        TextView textView2 = (TextView) this.D.findViewById(R.id.f167033k60);
        this.f42285y0 = textView2;
        textView2.setOnClickListener(this);
        AlbumBaseTabFragment.j jVar = this.C;
        if (jVar == null) {
            QZLog.e(this.f42278r0, 1, "[onHandleMessage] tab operator should not be null.");
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(jVar.getHostActivity(), R.anim.f154788cn);
        this.H0 = loadAnimation;
        loadAnimation.setAnimationListener(this.X0);
        this.f42283w0 = (GridView) this.D.findViewById(R.id.crr);
        g gVar = new g(this.C.getHostActivity());
        this.D0 = gVar;
        this.f42283w0.setAdapter((ListAdapter) gVar);
        Kj();
        this.f42283w0.setOnItemClickListener(new d());
        kj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void initData() {
        super.initData();
        this.f42279s0 = new CopyOnWriteArrayList();
        this.f42282v0 = new ArrayList<>();
        Resources resources = getResources();
        if (resources != null) {
            this.A0 = resources.getDimensionPixelSize(R.dimen.f159239y8);
            this.B0 = resources.getDimensionPixelSize(R.dimen.f159243yc);
            this.C0 = resources.getDimensionPixelSize(R.dimen.f159242yb);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f159240y9);
            this.E0 = dimensionPixelSize;
            this.F0 = dimensionPixelSize;
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void ji(AdapterView<?> adapterView, View view, int i3, long j3) {
        AlbumCacheData albumCacheData = (AlbumCacheData) adapterView.getItemAtPosition(i3);
        if (albumCacheData != null) {
            this.G0 = false;
            this.f42280t0 = albumCacheData;
            if (QZLog.isDevelopLevel()) {
                QZLog.d(this.f42278r0, 4, "onListViewItemClick albumName=" + albumCacheData.albumname + "; anonymity=" + albumCacheData.anonymity);
            }
            com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "onListViewItemClick start");
            if (!P2()) {
                if (albumCacheData.albumtype != 21) {
                    oj(albumCacheData);
                }
            } else {
                if (com.qzone.album.util.d.f(this.f42280t0.albumrights)) {
                    AlbumCacheData albumCacheData2 = this.f42280t0;
                    if (!albumCacheData2.allowAccess) {
                        nj(albumCacheData2, 0, null);
                        return;
                    }
                }
                oj(albumCacheData);
            }
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1) {
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2) {
                    if (intent != null) {
                        t4.a.N().s(this, intent);
                    }
                } else if (i3 != 5) {
                    com.qzone.proxy.feedcomponent.b.i(this.f42278r0, "onShellActivityResult switch to default");
                }
            } else if (intent != null) {
                intent.putExtra("isPhotoListSkipAfterAlbum", true);
                t4.a.N().s(this, intent);
            }
        } else if (i16 == 0 && i3 == 1 && t4.a.N().b(intent)) {
            mj(2);
        }
        AlbumBaseTabFragment.j jVar = this.C;
        if (jVar != null) {
            jVar.A0(i3, i16, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.k6q) {
                zj();
            } else if (id5 == R.id.f167033k60) {
                vj();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xj();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t4.a.N().w();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Hh();
        Ih();
        jj();
        Long l3 = this.P;
        if (l3 != null && l3.longValue() == com.qzone.album.env.common.a.m().s()) {
            com.qzone.album.env.common.a.m().o().post(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumListTabFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    com.qzone.album.env.common.a.m().N(QZoneHelper.QzoneSharePrefrenceConstants.KEY_PHOTO_GUIDE_ENTER_QZONE_DATE, System.currentTimeMillis());
                }
            });
        }
        t4.a.N().v();
        return onCreateView;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QZonePullToRefreshListView qZonePullToRefreshListView;
        AlbumBaseTabFragment.j jVar;
        super.onDestroy();
        com.qzone.album.util.d.b().a();
        Fj();
        if (this.S0 != null && (jVar = this.C) != null && this.T0) {
            jVar.getHostActivity().unregisterReceiver(this.S0);
        }
        com.qzone.album.business.photolist.adapter.c cVar = this.K;
        if (cVar != null && (qZonePullToRefreshListView = this.J) != null) {
            cVar.a(qZonePullToRefreshListView);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        s8.b d16 = s8.b.d(event);
        if ("QzoneAlbum".equals(d16.a())) {
            int c16 = d16.c();
            if (c16 == 2) {
                Object obj = ((Object[]) d16.b())[0];
                if (obj == null || !(obj instanceof Album)) {
                    return;
                }
                Lj((Album) obj);
                return;
            }
            if (c16 == 10) {
                final Object[] objArr = (Object[]) d16.b();
                if (objArr == null || objArr[0] == null || objArr[1] == null) {
                    return;
                }
                com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumListTabFragment.8
                    @Override // java.lang.Runnable
                    public void run() {
                        AlbumListTabFragment albumListTabFragment = AlbumListTabFragment.this;
                        Object[] objArr2 = objArr;
                        albumListTabFragment.Nj((String) objArr2[0], (String) objArr2[1]);
                    }
                });
                return;
            }
            if (c16 != 25) {
                com.qzone.proxy.feedcomponent.b.i(this.f42278r0, "onEventUIThread switch to default");
                return;
            }
            Object obj2 = ((Object[]) d16.b())[0];
            if (obj2 != null && (obj2 instanceof String)) {
                String str = (String) obj2;
                for (int i3 = 0; i3 < this.f42279s0.size(); i3++) {
                    if (this.f42279s0.get(i3).albumid.equals(str)) {
                        this.f42279s0.get(i3).allowAccess = true;
                    }
                }
            }
            c0();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        EventCenter.getInstance().post("LocalPhotoCardView", 1);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZonePhotoDegradeEvent) {
            if (((QZonePhotoDegradeEvent) simpleBaseEvent).getIsForceClose()) {
                uj();
                this.W0 = true;
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QFSDeleteQZoneVideoAlbumEvent) {
            tj((QFSDeleteQZoneVideoAlbumEvent) simpleBaseEvent);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.C == null) {
            return;
        }
        Long l3 = this.P;
        if (l3 != null && l3.longValue() == com.qzone.album.env.common.a.m().s() && !this.G0) {
            vj();
        }
        this.K.notifyDataSetChanged();
        if (this.O0) {
            this.O0 = false;
            c0();
        }
        t4.a.N().u(this.C.getHostActivity(), this.K);
        EventCenter.getInstance().post("LocalPhotoCardView", 2);
        if (this.W0) {
            return;
        }
        Gj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void parseIntent() {
        super.parseIntent();
        Bundle bundle = this.Q;
        if (bundle != null) {
            this.f42281u0 = bundle.getInt(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_TAB);
            this.G0 = this.Q.getBoolean(QZoneHelper.QZoneAlbumConstants.KEY_NEED_SHOW_ALBUM_RECENT_PHOTO);
            this.L0 = this.Q.getBoolean(QZoneHelper.QZoneAppConstants.KEY_HAS_REDTOUCH, false);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void pi() {
        com.qzone.album.ui.widget.c cVar = this.f42244c0;
        if (cVar != null) {
            cVar.l(10);
        }
    }

    public String pj() {
        AlbumBaseTabFragment.j jVar = this.C;
        if (jVar == null) {
            QZLog.e(this.f42278r0, 1, "[getBeaconEvent] tab operator should not be null.");
            return "";
        }
        Intent intent = jVar.getHostActivity().getIntent();
        if (intent == null) {
            return "";
        }
        String stringExtra = intent.getStringExtra("refer");
        if (TextUtils.isEmpty(stringExtra)) {
            return "";
        }
        if (stringExtra.equals("getActiveFeeds")) {
            return QzoneVideoBeaconReport.EVENT_ALBUM_BANNER;
        }
        if (stringExtra.equals(QZoneHelper.QZoneAppConstants.REFER_QQ_SETTING)) {
            return QzoneVideoBeaconReport.EVENT_ALBUM_LIST;
        }
        return QzoneVideoBeaconReport.EVENT_ALBUM_OTHER;
    }

    public String rj() {
        return this.R0;
    }

    public boolean vj() {
        RelativeLayout relativeLayout = this.f42286z0;
        if (relativeLayout == null || relativeLayout.getVisibility() == 8) {
            return false;
        }
        this.f42286z0.setVisibility(8);
        return true;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void yi() {
        vi("qzone_album_list_loading_img");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements n.a<QZonePhotoDegrade$QueryNotifyMsgRsp> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long j3, String str) {
            AlbumListTabFragment.this.uj();
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QZonePhotoDegrade$QueryNotifyMsgRsp qZonePhotoDegrade$QueryNotifyMsgRsp, long j3, String str, boolean z16) {
            QZonePhotoDegrade$NotifyMsg qZonePhotoDegrade$NotifyMsg;
            if (qZonePhotoDegrade$QueryNotifyMsgRsp == null || (qZonePhotoDegrade$NotifyMsg = qZonePhotoDegrade$QueryNotifyMsgRsp.f430342msg) == null) {
                AlbumListTabFragment.this.uj();
                return;
            }
            String j16 = na.c.f419539a.j(qZonePhotoDegrade$NotifyMsg.texts.get());
            List<QZonePhotoDegrade$Button> list = qZonePhotoDegrade$QueryNotifyMsgRsp.f430342msg.buttons.get();
            RFWLog.d(AlbumListTabFragment.this.f42278r0, RFWLog.USR, "requestPhotoDegradeNotify onSuccess: " + j16 + ", button: " + list.size());
            if (TextUtils.isEmpty(j16) || list.size() <= 0) {
                AlbumListTabFragment.this.uj();
            } else {
                QZonePhotoDegrade$Button qZonePhotoDegrade$Button = list.get(0);
                AlbumListTabFragment.this.Jj(j16, qZonePhotoDegrade$Button.f430341msg.get(), qZonePhotoDegrade$Button.url.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action) || !action.equals(QZoneJsConstants.BROADCAST_ACTION_REFRESH_ALBUM_LIST)) {
                    return;
                }
                AlbumListTabFragment.this.c0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private Context f42301d;

        public g(Context context) {
            this.f42301d = context;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImageInfo getItem(int i3) {
            return (ImageInfo) AlbumListTabFragment.this.I0.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AlbumListTabFragment.this.I0.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            AsyncMarkImageView asyncMarkImageView;
            if (view != null && (view instanceof AsyncMarkImageView)) {
                asyncMarkImageView = (AsyncMarkImageView) view;
            } else {
                asyncMarkImageView = new AsyncMarkImageView(this.f42301d);
                asyncMarkImageView.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dip2px(75.0f), ViewUtils.dip2px(75.0f)));
                asyncMarkImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                asyncMarkImageView.setAdjustViewBounds(false);
                asyncMarkImageView.setDefaultImage(R.drawable.asd);
                asyncMarkImageView.setAsyncImageProcessor(new SpecifiedSizeCropByPivotProcessor(AlbumListTabFragment.this.E0, AlbumListTabFragment.this.F0));
                asyncMarkImageView.setAsyncClipSize(AlbumListTabFragment.this.E0, AlbumListTabFragment.this.F0);
                asyncMarkImageView.setMarker(R.drawable.d3w, 3);
                asyncMarkImageView.setMarkerPaddingOffset(-AlbumListTabFragment.this.K0, AlbumListTabFragment.this.J0);
                asyncMarkImageView.setForgroundMaskColor(1728053247);
            }
            ImageInfo item = getItem(i3);
            if (item != null && !TextUtils.isEmpty(item.mPath)) {
                asyncMarkImageView.setAsyncImage(item.mPath);
                asyncMarkImageView.setTag(item.mPath);
                if (AlbumListTabFragment.this.f42282v0 != null) {
                    if (AlbumListTabFragment.this.f42282v0.contains(item.mPath)) {
                        asyncMarkImageView.setMarkerVisible(true);
                    } else {
                        asyncMarkImageView.setMarkerVisible(false);
                    }
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return asyncMarkImageView;
        }
    }

    private void Hj(String str) {
        TextView textView;
        if (str == null || str.trim().equals("") || (textView = this.f42284x0) == null) {
            return;
        }
        textView.setText(str);
    }

    private void Lj(Album album) {
        AlbumCacheData albumCacheData;
        if (album == null || TextUtils.isEmpty(album.albumid)) {
            return;
        }
        if (this.C == null) {
            QZLog.e(this.f42278r0, 1, "[updateAlbumList] tab operator should not be null.");
            return;
        }
        Iterator<AlbumCacheData> it = this.f42279s0.iterator();
        while (true) {
            if (!it.hasNext()) {
                albumCacheData = null;
                break;
            } else {
                albumCacheData = it.next();
                if (album.albumid.equals(albumCacheData.albumid)) {
                    break;
                }
            }
        }
        if (albumCacheData != null) {
            albumCacheData.albumname = album.name;
            albumCacheData.albumdesc = album.desc;
            albumCacheData.albumrights = album.priv;
            albumCacheData.albumquestion = album.question;
            albumCacheData.albumanswer = album.answer;
            albumCacheData.albumtype = album.type;
            albumCacheData.birthDateTime = album.birth_time;
            albumCacheData.coverUrl = new PictureUrl(album.coverurl, 0, 0);
            albumCacheData.anonymity = QZoneAlbumUtil.r(albumCacheData.albumtype);
            t4.a.N().u(this.C.getHostActivity(), this.K);
            update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(AlbumCacheData albumCacheData) {
        if (albumCacheData == null || albumCacheData.anonymity != 103) {
            return;
        }
        dh.a aVar = dh.a.f393805d;
        boolean p16 = aVar.p();
        QLog.i("QZ_QFS_" + this.f42278r0, 1, "handleClickClearQcircleRedDot, onClick | showQcircleEntranceRedDot=" + p16);
        if (p16) {
            aVar.l(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj(AlbumCacheData albumCacheData, int i3, String str) {
        if (albumCacheData == null) {
            return;
        }
        startActivity(t4.a.N().q(this, albumCacheData, i3, str, this.P.longValue()));
    }
}
