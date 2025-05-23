package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.ab;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFileAssistant;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService;
import com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.mixedmsg.d;
import com.tencent.mobileqq.panel.SquareRelativeLayout;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.y;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.bp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.report.retention.RetentionReport;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AccountNotMatchException;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes10.dex */
public class PhotoListPanel extends RelativeLayout implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static int Q0 = 20;
    public static int R0;
    MediaFileFilter A0;
    MediaFileFilter B0;
    public QQAppInterface C;
    boolean C0;
    Intent D;
    boolean D0;
    Activity E;
    int E0;
    public SessionInfo F;
    boolean F0;
    String G;
    Boolean G0;
    String H;
    boolean H0;
    String I;
    boolean I0;
    int J;
    public int J0;
    int K;
    private int K0;
    int L;
    private SendByFile L0;
    int M;
    private String M0;
    int N;
    private String N0;
    private boolean O0;
    ArrayList<Integer> P;
    private d.a P0;
    ArrayList<String> Q;
    HashMap<LocalMediaInfo, LocalMediaInfo> R;
    boolean S;
    boolean T;
    boolean U;
    boolean V;
    boolean W;

    /* renamed from: a0, reason: collision with root package name */
    boolean f179640a0;

    /* renamed from: b0, reason: collision with root package name */
    boolean f179641b0;

    /* renamed from: c0, reason: collision with root package name */
    boolean f179642c0;

    /* renamed from: d, reason: collision with root package name */
    private float f179643d;

    /* renamed from: d0, reason: collision with root package name */
    public RecyclerView f179644d0;

    /* renamed from: e, reason: collision with root package name */
    public int f179645e;

    /* renamed from: e0, reason: collision with root package name */
    RecyclerView.LayoutManager f179646e0;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList<String> f179647f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f179648f0;

    /* renamed from: g0, reason: collision with root package name */
    TextView f179649g0;

    /* renamed from: h, reason: collision with root package name */
    public PhotoPanelAdapter f179650h;

    /* renamed from: h0, reason: collision with root package name */
    FrameLayout f179651h0;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, LocalMediaInfo> f179652i;

    /* renamed from: i0, reason: collision with root package name */
    TextView f179653i0;

    /* renamed from: j0, reason: collision with root package name */
    QUICheckBox f179654j0;

    /* renamed from: k0, reason: collision with root package name */
    TextView f179655k0;

    /* renamed from: l0, reason: collision with root package name */
    TextView f179656l0;

    /* renamed from: m, reason: collision with root package name */
    public long f179657m;

    /* renamed from: m0, reason: collision with root package name */
    View f179658m0;

    /* renamed from: n0, reason: collision with root package name */
    View f179659n0;

    /* renamed from: o0, reason: collision with root package name */
    View f179660o0;

    /* renamed from: p0, reason: collision with root package name */
    TextView f179661p0;

    /* renamed from: q0, reason: collision with root package name */
    View f179662q0;

    /* renamed from: r0, reason: collision with root package name */
    e f179663r0;

    /* renamed from: s0, reason: collision with root package name */
    i f179664s0;

    /* renamed from: t0, reason: collision with root package name */
    boolean f179665t0;

    /* renamed from: u0, reason: collision with root package name */
    boolean f179666u0;

    /* renamed from: v0, reason: collision with root package name */
    Handler f179667v0;

    /* renamed from: w0, reason: collision with root package name */
    int f179668w0;

    /* renamed from: x0, reason: collision with root package name */
    int f179669x0;

    /* renamed from: y0, reason: collision with root package name */
    com.tencent.mobileqq.drawable.b f179670y0;

    /* renamed from: z0, reason: collision with root package name */
    com.tencent.mobileqq.drawable.b f179671z0;

    /* renamed from: com.tencent.mobileqq.activity.aio.photo.PhotoListPanel$4, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Pair f179673d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f179674e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f179675f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f179676h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f179677i;
        final /* synthetic */ PhotoListPanel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (!((ArrayList) this.f179673d.first).isEmpty() || !((ArrayList) this.f179673d.second).isEmpty()) {
                this.this$0.T(this.f179673d, this.f179674e);
                com.tencent.mobileqq.shortvideo.h.f287891c = System.currentTimeMillis();
            }
            String str = this.f179675f;
            ReportController.o(null, "CliOper", "", "", str, str, 0, 0, this.f179676h, this.f179677i, "", "");
        }
    }

    /* loaded from: classes10.dex */
    public static class PhotoPanelAdapter extends RecyclerView.Adapter<b> {

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<PhotoListPanel> f179681d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<LocalMediaInfo> f179682e = new ArrayList<>();

        /* renamed from: f, reason: collision with root package name */
        boolean f179683f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes10.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ b f179685d;

            a(b bVar) {
                this.f179685d = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                PhotoPanelAdapter.this.f179681d.get().G(view, this.f179685d.getAdapterPosition());
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* loaded from: classes10.dex */
        public class b extends RecyclerView.ViewHolder {
            public URLDrawable C;
            public View D;
            public TextView E;
            f F;

            /* renamed from: d, reason: collision with root package name */
            public SquareRelativeLayout f179687d;

            /* renamed from: e, reason: collision with root package name */
            public URLImageView f179688e;

            /* renamed from: f, reason: collision with root package name */
            public QUICheckBox f179689f;

            /* renamed from: h, reason: collision with root package name */
            public FrameLayout f179690h;

            /* renamed from: i, reason: collision with root package name */
            public ImageView f179691i;

            /* renamed from: m, reason: collision with root package name */
            public ImageView f179692m;

            public b(View view) {
                super(view);
                FrameLayout frameLayout;
                SquareRelativeLayout squareRelativeLayout = (SquareRelativeLayout) view.findViewById(R.id.cg7);
                this.f179687d = squareRelativeLayout;
                squareRelativeLayout.setCloseSquare(true);
                this.f179688e = (URLImageView) view.findViewById(R.id.f165862dq3);
                this.F = PhotoPanelAdapter.this.f179681d.get().j();
                QUICheckBox qUICheckBox = (QUICheckBox) view.findViewById(R.id.dpo);
                this.f179689f = qUICheckBox;
                qUICheckBox.setClickable(false);
                this.D = view.findViewById(R.id.fov);
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.xsw);
                this.f179690h = frameLayout2;
                if (frameLayout2 != null) {
                    frameLayout2.setOnClickListener(this.F);
                    ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.f179690h, "em_aio_image_quick", null);
                }
                if (PhotoPanelAdapter.this.f179681d.get().D0 && (frameLayout = this.f179690h) != null) {
                    frameLayout.setVisibility(8);
                }
                this.f179691i = (ImageView) view.findViewById(R.id.dri);
                this.f179692m = (ImageView) view.findViewById(R.id.f165863dq4);
                this.E = (TextView) view.findViewById(R.id.drh);
            }
        }

        public PhotoPanelAdapter(PhotoListPanel photoListPanel) {
            WeakReference<PhotoListPanel> weakReference = new WeakReference<>(photoListPanel);
            this.f179681d = weakReference;
            this.f179683f = ThemeUtil.isNowThemeIsNight(weakReference.get().C, false, null);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f179682e.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            return QAlbumUtil.getMediaType(q(i3));
        }

        public int p(String str) {
            LocalMediaInfo r16 = r(str);
            if (r16 == null) {
                return -1;
            }
            return QAlbumUtil.getMediaType(r16);
        }

        public LocalMediaInfo q(int i3) {
            ArrayList<LocalMediaInfo> arrayList = this.f179682e;
            if (arrayList != null && i3 != -1 && arrayList.size() > i3) {
                return this.f179682e.get(i3);
            }
            return null;
        }

        public LocalMediaInfo r(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<LocalMediaInfo> it = this.f179682e.iterator();
            while (it.hasNext()) {
                LocalMediaInfo next = it.next();
                if (next.path.equals(str)) {
                    return next;
                }
            }
            return null;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b bVar, int i3) {
            bVar.itemView.setOnClickListener(new a(bVar));
            bVar.F.b(bVar.getAdapterPosition());
            bVar.F.a(bVar.f179689f);
            LocalMediaInfo q16 = q(bVar.getAdapterPosition());
            URLImageView uRLImageView = bVar.f179688e;
            com.tencent.mobileqq.drawable.b bVar2 = new com.tencent.mobileqq.drawable.b(this.f179681d.get().f179668w0, q16.thumbWidth, q16.thumbHeight);
            com.tencent.mobileqq.drawable.b bVar3 = new com.tencent.mobileqq.drawable.b(this.f179681d.get().f179669x0, q16.thumbWidth, q16.thumbHeight);
            URL generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(q16, "FLOW_THUMB");
            URLDrawable uRLDrawable = bVar.C;
            if (generateAlbumThumbURL != null && (uRLDrawable == null || !uRLDrawable.getURL().equals(generateAlbumThumbURL))) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                int i16 = q16.thumbWidth;
                obtain.mRequestWidth = i16;
                int i17 = q16.thumbHeight;
                obtain.mRequestHeight = i17;
                if (i16 > 0 && i17 > 0) {
                    obtain.mLoadingDrawable = bVar2;
                    obtain.mFailedDrawable = bVar3;
                } else {
                    obtain.mLoadingDrawable = this.f179681d.get().f179670y0;
                    obtain.mFailedDrawable = this.f179681d.get().f179671z0;
                }
                URLDrawable drawable = URLDrawable.getDrawable(generateAlbumThumbURL, obtain);
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoListPanel", 2, "PhotoListPanel,adapter getView(), url :" + generateAlbumThumbURL.toString());
                }
                drawable.setTag(q16);
                uRLImageView.setImageDrawable(drawable);
                bVar.C = drawable;
            }
            QUICheckBox qUICheckBox = bVar.f179689f;
            ImageView imageView = bVar.f179692m;
            qUICheckBox.setTag(Integer.valueOf(bVar.getAdapterPosition()));
            if (q16.mChecked) {
                int indexOf = this.f179681d.get().f179647f.indexOf(q16.path);
                if (indexOf >= 0) {
                    qUICheckBox.setText(String.valueOf(indexOf + 1));
                    qUICheckBox.setChecked(true);
                }
                imageView.setVisibility(0);
            } else {
                qUICheckBox.setChecked(false);
                qUICheckBox.setText("");
                imageView.setVisibility(4);
            }
            if (this.f179683f) {
                qUICheckBox.setTextColor(-1509949441);
            }
            ImageView imageView2 = bVar.f179691i;
            int itemViewType = getItemViewType(bVar.getAdapterPosition());
            if (itemViewType == 0) {
                imageView2.setVisibility(4);
                bVar.E.setVisibility(4);
            } else if (itemViewType == 1) {
                imageView2.setVisibility(0);
                TextView textView = bVar.E;
                textView.setVisibility(0);
                textView.setText(((IAlbumUtils) QRoute.api(IAlbumUtils.class)).formatTimeToString(q16.mDuration));
            } else {
                imageView2.setVisibility(4);
                bVar.E.setVisibility(4);
            }
            this.f179681d.get().getClass();
            if (AppSetting.f99565y) {
                bVar.itemView.setContentDescription(PhotoUtils.createContentDescription(itemViewType, q16, bVar.getAdapterPosition()));
                bVar.f179689f.setContentDescription(PhotoUtils.createContentDescriptionWithCheckBox(itemViewType, q16, bVar.getAdapterPosition(), qUICheckBox.isChecked()));
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(bVar, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cbi, viewGroup, false));
        }

        void u(final List<LocalMediaInfo> list) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                w(list);
            } else {
                this.f179681d.get().f179667v0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PhotoPanelAdapter.this.w(list);
                    }
                });
            }
        }

        public void v() {
            Iterator<LocalMediaInfo> it = this.f179682e.iterator();
            while (it.hasNext()) {
                it.next().mChecked = false;
            }
        }

        public void w(List<LocalMediaInfo> list) {
            this.f179682e.clear();
            if (list != null && list.size() != 0) {
                this.f179681d.get().f179658m0.setVisibility(8);
                this.f179681d.get().f179644d0.setVisibility(0);
                this.f179682e.addAll(list);
                notifyDataSetChanged();
                this.f179681d.get().c0();
                if (!this.f179681d.get().f179647f.isEmpty()) {
                    String.format(this.f179681d.get().getResources().getString(R.string.f173069h31), Integer.valueOf(this.f179681d.get().f179647f.size()));
                    return;
                } else {
                    this.f179681d.get().getResources().getString(R.string.h2w);
                    return;
                }
            }
            PhotoListPanel.R0 = 0;
            this.f179681d.get().f179658m0.setVisibility(0);
            this.f179681d.get().f179644d0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class QueryMediaTask implements Runnable {
        QueryMediaTask() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(List<LocalMediaInfo> list) {
            int i3;
            int i16;
            int size = list.size();
            PhotoListPanel.this.Q = new ArrayList<>(list.size());
            PhotoListPanel.this.f179652i = new HashMap(list.size());
            PhotoListPanel.R0 = size;
            for (int i17 = 0; i17 < size; i17++) {
                try {
                    LocalMediaInfo localMediaInfo = list.get(i17);
                    if (localMediaInfo.path != null) {
                        localMediaInfo.mMediaType = -1;
                        int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
                        if (mediaType == 0) {
                            localMediaInfo.mMediaType = 0;
                        } else if (mediaType == 1) {
                            localMediaInfo.mMediaType = 1;
                        }
                        PhotoListPanel.this.f179652i.put(localMediaInfo.path, localMediaInfo);
                        ArrayList<String> arrayList = PhotoListPanel.this.Q;
                        if (arrayList != null) {
                            arrayList.add(localMediaInfo.path);
                        }
                        localMediaInfo.position = Integer.valueOf(i17);
                        int i18 = localMediaInfo.orientation;
                        if (i18 != 90 && i18 != 270) {
                            int i19 = PhotoListPanel.this.L;
                            localMediaInfo.thumbWidth = i19 / 2;
                            localMediaInfo.thumbHeight = i19 / 2;
                            int i26 = localMediaInfo.mediaWidth;
                            if (i26 > 0 && (i16 = localMediaInfo.mediaHeight) > 0) {
                                FlowThumbDecoder.determineThumbSize(localMediaInfo, i26, i16);
                            }
                        }
                        int i27 = PhotoListPanel.this.L;
                        localMediaInfo.thumbWidth = i27 / 2;
                        localMediaInfo.thumbHeight = i27 / 2;
                        int i28 = localMediaInfo.mediaWidth;
                        if (i28 > 0 && (i3 = localMediaInfo.mediaHeight) > 0) {
                            FlowThumbDecoder.determineThumbSize(localMediaInfo, i28, i3);
                            int i29 = localMediaInfo.thumbWidth;
                            localMediaInfo.thumbWidth = localMediaInfo.thumbHeight;
                            localMediaInfo.thumbHeight = i29;
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel() && PhotoListPanel.this.Q != null) {
                        QLog.d("PhotoListPanel", 2, e16 + "get album medias size : " + list.size() + "mPhotos size" + PhotoListPanel.this.Q.size());
                    }
                }
            }
            PhotoListPanel photoListPanel = PhotoListPanel.this;
            com.tencent.mobileqq.activity.photo.j.g(list, 0, photoListPanel.Q, photoListPanel.R);
        }

        @Override // java.lang.Runnable
        public void run() {
            final ArrayList arrayList;
            final long uptimeMillis = SystemClock.uptimeMillis();
            QLog.d("PhotoListPanel", 1, "QueryMediaTask start" + uptimeMillis + "to qurey time=" + (PhotoListPanel.this.f179657m - uptimeMillis));
            l a16 = l.a(PhotoListPanel.this.C);
            final int i3 = a16.f179751d;
            final int i16 = a16.f179752e;
            Set<String> set = a16.f179753f;
            if (set != null && set.size() > 0) {
                ArrayList arrayList2 = new ArrayList(set.size());
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AppConstants.SDCARD_ROOT + it.next());
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            PhotoListPanelUtilsKt.b(8, new Function1<List<? extends LocalMediaInfo>, Unit>() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.QueryMediaTask.1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unit invoke(final List<? extends LocalMediaInfo> list) {
                    QLog.d("PhotoListPanel", 1, "get album medias cost: " + (SystemClock.uptimeMillis() - uptimeMillis) + " limitSize:" + i3 + " limitWidth:" + i16 + " blackLists:" + arrayList);
                    if (list != null && list.size() != 0) {
                        QLog.d("PhotoListPanel", 1, "get album medias size : " + list.size());
                        QueryMediaTask.this.b(list);
                        PhotoListPanel.this.f179667v0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.QueryMediaTask.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z16;
                                Iterator<String> it5 = PhotoListPanel.this.f179647f.iterator();
                                PhotoListPanel.this.P.clear();
                                while (it5.hasNext()) {
                                    String next = it5.next();
                                    Iterator it6 = list.iterator();
                                    while (true) {
                                        if (it6.hasNext()) {
                                            LocalMediaInfo localMediaInfo = (LocalMediaInfo) it6.next();
                                            if (next.equals(localMediaInfo.path)) {
                                                z16 = true;
                                                localMediaInfo.mChecked = true;
                                                PhotoListPanel.this.P.add(localMediaInfo.position);
                                                break;
                                            }
                                        } else {
                                            z16 = false;
                                            break;
                                        }
                                    }
                                    if (!z16) {
                                        it5.remove();
                                    }
                                }
                            }
                        });
                        QLog.d("PhotoListPanel", 1, "QueryMediaTask,mediaList.size :" + list.size());
                        PhotoListPanel.this.f179650h.u(list);
                        return null;
                    }
                    QLog.w("PhotoListPanel", 1, "QueryMediaTask getAlbumMedias is null");
                    PhotoListPanel.R0 = 0;
                    PhotoListPanel.this.f179667v0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.QueryMediaTask.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PhotoListPanel.this.f179658m0.setVisibility(0);
                            PhotoListPanel.this.f179644d0.setVisibility(8);
                        }
                    });
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends StaggeredGridLayoutManager {
        a(int i3, int i16) {
            super(i3, i16);
        }

        @Override // android.support.v7.widget.StaggeredGridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            if (PhotoListPanel.this.f179648f0 && super.canScrollHorizontally()) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            PhotoListPanel.this.J0 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f179703d;

        c(Runnable runnable) {
            this.f179703d = runnable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f179703d.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("PhotoListPanel", 2, "cancel shortvideo_mobile_send_confirm dialog");
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface e {
        boolean R(PhotoListPanel photoListPanel);

        boolean j(PhotoListPanel photoListPanel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        int f179706d;

        /* renamed from: e, reason: collision with root package name */
        CheckBox f179707e;

        public f() {
        }

        public void a(CheckBox checkBox) {
            this.f179707e = checkBox;
        }

        public void b(int i3) {
            this.f179706d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PhotoPanelAdapter photoPanelAdapter = PhotoListPanel.this.f179650h;
            if (photoPanelAdapter != null && photoPanelAdapter.getItemCount() > 0) {
                LocalMediaInfo q16 = PhotoListPanel.this.f179650h.q(this.f179706d);
                int itemViewType = PhotoListPanel.this.f179650h.getItemViewType(this.f179706d);
                if (!q16.mChecked) {
                    PhotoListPanel photoListPanel = PhotoListPanel.this;
                    if (com.tencent.mobileqq.utils.e.c(photoListPanel.f179647f, photoListPanel.E, PhotoListPanel.Q0)) {
                        this.f179707e.setChecked(q16.mChecked);
                        this.f179707e.setText("");
                    }
                }
                PhotoListPanel photoListPanel2 = PhotoListPanel.this;
                if (photoListPanel2.F.f179555d != 10014 || q16.mChecked || photoListPanel2.x(q16)) {
                    boolean z16 = !q16.mChecked;
                    q16.mChecked = z16;
                    this.f179707e.setChecked(z16);
                    if (q16.mChecked) {
                        if (itemViewType == 0) {
                            PhotoListPanel photoListPanel3 = PhotoListPanel.this;
                            photoListPanel3.J(q16.path, photoListPanel3.F.P);
                        }
                        PhotoListPanel.this.f179647f.add(q16.path);
                        PhotoListPanel.this.P.add(q16.position);
                        PhotoListPanel.this.getClass();
                        this.f179707e.setText(String.valueOf(PhotoListPanel.this.f179647f.size()));
                        ReportController.o(null, "CliOper", "", "", "0X8005E08", "0X8005E08", 0, 0, "", "", "", "");
                        if (PhotoListPanel.this.L0 != null) {
                            PhotoListPanel.this.L0.c(PhotoListPanel.this.getContext(), q16.path, PhotoListPanel.this.f179654j0.isChecked(), PhotoListPanel.this.f179652i, null, true);
                        }
                    } else {
                        if (itemViewType == 0) {
                            PhotoListPanel.this.h(q16.path);
                        }
                        this.f179707e.setText("");
                        PhotoListPanel.this.f179647f.remove(q16.path);
                        PhotoListPanel.this.P.remove(q16.position);
                        PhotoListPanel.this.getClass();
                    }
                    PhotoListPanel.this.d0();
                    PhotoListPanel.this.c0();
                    PhotoListPanel.this.r();
                    PhotoListPanel.this.getClass();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes10.dex */
    public interface g {
    }

    /* loaded from: classes10.dex */
    public interface h {
    }

    /* loaded from: classes10.dex */
    public interface i {
    }

    public PhotoListPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f179643d = 0.0f;
        this.f179645e = 0;
        this.f179647f = new LinkedList<>();
        this.f179657m = 0L;
        this.P = new ArrayList<>();
        this.R = new HashMap<>();
        this.f179642c0 = false;
        this.f179648f0 = true;
        this.f179665t0 = false;
        this.f179666u0 = false;
        this.f179667v0 = new Handler(Looper.getMainLooper());
        this.f179668w0 = 278921216;
        this.f179669x0 = -16777216;
        this.C0 = false;
        this.D0 = false;
        this.F0 = false;
        this.J0 = 0;
        this.K0 = -1;
        this.N0 = HardCodeUtil.qqStr(R.string.p4x);
        this.J = p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(View view, int i3, boolean z16) {
        if (!this.E.isFinishing() && !this.E.isDestroyed()) {
            if (!z16) {
                if (QLog.isColorLevel()) {
                    QLog.i("PhotoListPanel", 2, "PhotoListPanel onItemClick,clickPath not exits, just return.");
                }
                QQToast.makeText(this.E, R.string.cwd, 0).show();
                N();
                this.f179647f.clear();
                this.P.clear();
                c0();
                return;
            }
            K(view, i3, new ArrayList<>(this.f179647f));
            P();
            return;
        }
        QLog.i("PhotoListPanel", 1, "onItemClick, activity is destroyed");
    }

    private void K(View view, int i3, ArrayList<String> arrayList) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.E, IPhotoLogicFactory.PHOTO_PREVIEW_ACTIVITY_URI);
        activityURIRequest.extra().putString(QAlbumConstants.ALBUM_ID, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID);
        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, this.E0);
        activityURIRequest.extra().putString("uin", this.F.f179557e);
        activityURIRequest.extra().putString(PeakConstants.MY_UIN, this.G);
        activityURIRequest.extra().putInt("uintype", this.F.f179555d);
        activityURIRequest.extra().putString("troop_uin", this.F.f179559f);
        activityURIRequest.extra().putString("uinname", this.F.f179563i);
        activityURIRequest.extra().putInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, this.F.P);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_TROOP_SEND_MIXED_MSG, this.F0);
        activityURIRequest.extra().putBoolean(QAlbumConstants.SHOW_ALBUM, true);
        activityURIRequest.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", this.Q);
        activityURIRequest.extra().putInt(QAlbumConstants.CURRENT_SELECTED_INDEX, this.f179650h.q(i3).position.intValue());
        activityURIRequest.extra().putStringArrayList("PhotoConst.SELECTED_PATHS", arrayList);
        activityURIRequest.extra().putIntegerArrayList(QAlbumConstants.SELECTED_INDEXS, this.P);
        activityURIRequest.extra().putSerializable(QAlbumConstants.ALL_MEDIA_PATHS, (Serializable) this.f179652i);
        activityURIRequest.extra().putSerializable(QAlbumConstants.KEY_EDIT_PATHS_MAP, com.tencent.mobileqq.activity.photo.j.e(this.R));
        activityURIRequest.extra().putBoolean("KEY_IS_ANONYMOUS", com.tencent.biz.anonymous.a.h().d(this.F.f179557e));
        if (this.D != null) {
            activityURIRequest.extra().putBoolean("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", z());
            activityURIRequest.extra().putParcelable(AppConstants.Key.SESSION_INFO, this.F);
        }
        Activity activity = this.E;
        if (activity instanceof SplashActivity) {
            activityURIRequest.extra().putInt(PeakConstants.KEY_PIC_TO_EDIT_FROM, 1);
            activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
            activityURIRequest = BaseAIOUtils.n(activityURIRequest, null);
        } else if (activity instanceof LiteActivity) {
            activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
        } else {
            activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        }
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putString("key_activity_code", ChatActivityUtils.p(this.E));
        int i16 = this.F.f179555d;
        if (i16 == 9501) {
            if (this.E instanceof SplashActivity) {
                activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SplashActivity.getAliasName());
                activityURIRequest = BaseAIOUtils.n(activityURIRequest, null);
            } else {
                activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, ChatActivity.class.getName());
            }
            activityURIRequest.extra().putInt(com.tencent.mobileqq.utils.d.f307603i, 80);
            activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
            activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, true);
        } else if (i16 != 6000 && i16 != 6003 && i16 != 6005) {
            activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
            activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
            activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, true);
            activityURIRequest.extra().putInt(ConfessInfo.KEY_CONFESS_TOPICID, this.F.S);
        } else {
            activityURIRequest.extra().putInt(com.tencent.mobileqq.utils.d.f307603i, 55);
            activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, false);
            activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_FILESIZE_LIMIT, true);
        }
        activityURIRequest.extra().putInt(QAlbumConstants.CURRENT_QUALITY_TYPE, this.f179645e);
        activityURIRequest.extra().putBoolean(QAlbumConstants.KEEP_SELECTED_STATUS_AFTER_FINISH, true);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_OVERLOAD, false);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", this.M);
        activityURIRequest.extra().putBoolean(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT, true);
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT_ACTION_NAME, "0X8005E0A");
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT_REVERSE2, "0");
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_EDITBTN_REPORT_ACTION_NAME, "0X8005E0B");
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_RAWCHECKBOX_REPORT_ACTION_NAME, "0X8005E0C");
        activityURIRequest.extra().putParcelable("KEY_THUMBNAL_BOUND", com.tencent.common.galleryactivity.j.d(view.findViewById(R.id.f165862dq3)));
        activityURIRequest.extra().putParcelable(AppConstants.Key.SESSION_INFO, this.F);
        Intent intent = this.D;
        if (intent == null || !intent.hasExtra("showFlashPic")) {
            QQAppInterface qQAppInterface = this.C;
            if (qQAppInterface != null) {
            }
            Bundle extra = activityURIRequest.extra();
            IPicFlash iPicFlash = (IPicFlash) QRoute.api(IPicFlash.class);
            SessionInfo sessionInfo = this.F;
            extra.putBoolean("showFlashPic", iPicFlash.showFlashPicOption(sessionInfo.f179555d, sessionInfo.f179559f));
        }
        activityURIRequest.extra().putBoolean(PeakConstants.IS_JUMPTO_TROOP_ALBUM, A());
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 1);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationAIO.f184370j);
        a0(activityURIRequest);
        activityURIRequest.extra().putBoolean("PHOTO_PREVIEW_NEED_DRAG_KEY", true);
        activityURIRequest.extra().putBoolean(PeakConstants.VIDEO_EDIT_ENABLED, this.O0);
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(this.F.f179557e)) {
            activityURIRequest.extra().putInt(com.tencent.mobileqq.utils.d.f307603i, 2);
            activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 51);
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationFileAssistant.F);
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationFileAssistant.G);
        }
        activityURIRequest.setFlags(603979776);
        QRoute.startUri(activityURIRequest);
    }

    private void L() {
        ((IGuildSelectMediaNotifyService) this.C.getRuntimeService(IGuildSelectMediaNotifyService.class, "")).changeSelectMediaRawType(this.F, this.f179645e);
    }

    private void O(int i3) {
        String str;
        if (i3 == 0) {
            str = "0";
        } else if (i3 == 1) {
            str = "1";
        } else {
            str = "";
        }
        ReportController.o(null, "CliOper", "", "", "0X8005E09", "0X8005E09", 0, 0, str, "", "", "");
    }

    private void P() {
        if (this.E instanceof SplashActivity) {
            ReportController.o(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 1, 0, this.f179647f.size() + "", "", "", "");
        }
    }

    private void S() {
        float f16 = getResources().getDisplayMetrics().density / FontSettingManager.systemMetrics.density;
        if (FontSettingManager.isFontSizeLarge()) {
            float f17 = this.f179643d;
            if (f17 == 0.0f || f17 != f16) {
                this.f179643d = f16;
                aw.r(this.f179649g0);
                aw.r(this.f179653i0);
                aw.r(this.f179651h0);
                aw.r(this.f179659n0);
                aw.r(this.f179655k0);
                aw.r(this.f179654j0);
                aw.r(this.f179656l0);
                aw.r(this.f179658m0);
                aw.r(this.f179644d0);
                this.f179662q0.setMinimumHeight(ViewUtils.dip2px(50.0f));
                this.f179662q0.setPadding(Math.round(r1.getPaddingLeft() / f16), 0, Math.round(this.f179662q0.getPaddingRight() / f16), 0);
                float f18 = 1.0f / f16;
                this.f179654j0.setScaleX(f18);
                this.f179654j0.setScaleY(f18);
                this.f179661p0.setScaleX(f18);
                this.f179661p0.setScaleY(f18);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("PhotoListPanel", 2, "font size does not change");
        }
    }

    private void X(a61.c cVar, Pair<ArrayList<String>, ArrayList<String>> pair) {
        boolean z16;
        MessageForReplyText.SourceMsgInfo c16 = ((ab) cVar.k(119)).c();
        boolean z17 = true;
        if (c16 != null && TextUtils.isEmpty(c16.mAnonymousNickName)) {
            new ChatActivityFacade.d();
            QQAppInterface qQAppInterface = this.C;
            SessionInfo sessionInfo = this.F;
            String N = ac.N(qQAppInterface, sessionInfo.f179555d, sessionInfo.f179557e, c16.mSourceMsgSenderUin + "");
            QQAppInterface qQAppInterface2 = this.C;
            Context context = cVar.f25578c;
            String str = this.F.f179557e;
            String str2 = c16.mSourceMsgSenderUin + "";
            XEditTextEx xEditTextEx = cVar.f25587l;
            if (this.F.f179555d == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            SpannableString f16 = com.tencent.mobileqq.troop.text.a.f(qQAppInterface2, context, str, str2, N, false, xEditTextEx, z16, true);
            if (f16 != null && f16.length() != 0) {
                cVar.f25587l.getEditableText().insert(0, f16);
            }
            MessageRecord a16 = s61.a.a(this.C, this.F, c16);
            c16.mType = 0;
            if ((a16 instanceof MessageForPic) || (a16 instanceof MessageForMixedMsg)) {
                c16.oriMsgType = 1;
            }
        }
        ArrayList<AtTroopMemberInfo> arrayList = new ArrayList<>();
        String c17 = com.tencent.mobileqq.troop.text.a.c(cVar.f25587l.getEditableText(), arrayList);
        MixedMsgManager mixedMsgManager = (MixedMsgManager) this.C.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
        d.a aVar = this.P0;
        if (aVar != null) {
            aVar.f();
        }
        d.a b16 = com.tencent.mobileqq.mixedmsg.d.b(getContext());
        this.P0 = b16;
        QQAppInterface qQAppInterface3 = this.C;
        SessionInfo sessionInfo2 = this.F;
        String str3 = sessionInfo2.f179557e;
        int i3 = sessionInfo2.f179555d;
        ArrayList<String> arrayList2 = pair.first;
        if (this.f179645e != 2) {
            z17 = false;
        }
        mixedMsgManager.A(qQAppInterface3, str3, i3, arrayList2, z17, c17, arrayList, c16, b16);
        if (!pair.second.isEmpty()) {
            Y(new ArrayList<>(), pair.second, this.T);
        }
    }

    private void a0(ActivityURIRequest activityURIRequest) {
        if (((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).useGuildPhotoList(this.F)) {
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).getPhotoListCustomizationGuildAIOClassName());
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).getPhotoPreviewCustomizationGuildAIOClassName());
            activityURIRequest.setRequestCode(10015);
        } else {
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAIO.T);
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAIO.R);
            activityURIRequest.setRequestCode(10004);
        }
    }

    private static boolean b0() {
        return ((IFeatureRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "")).isFeatureSwitchEnable("aio_pic_support_webp", true);
    }

    private void k() {
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.f179649g0, "em_photo_panel_album", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.f179655k0, "em_photo_panel_original_photo", null);
    }

    private void n() {
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio")) {
            Activity activity = this.E;
            QQToast.makeText(activity, activity.getResources().getString(R.string.f237737hv), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(this.E.getIntent());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", this.E.getPackageName());
        Activity activity2 = this.E;
        if (activity2 instanceof SplashActivity) {
            intent.putExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 1);
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
            intent.putExtra("open_chatfragment", true);
        } else if (activity2 instanceof LiteActivity) {
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
        } else {
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        }
        intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, this.E.getPackageName());
        intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAIO.T);
        intent.putExtra(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationAIO.f184370j);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAIO.R);
        intent.putExtra(PeakConstants.VIDEO_EDIT_AND_THEN_PREVIEW, false);
        intent.putExtra(PeakConstants.IS_SEND_TO_AIO, true);
        ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).jumpToVideoEditPage(this.E, intent, this.f179650h.r(this.f179647f.get(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(LocalMediaInfo localMediaInfo) {
        boolean z16;
        int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
        if (mediaType == 1) {
            if (this.f179647f.size() != 0) {
                return false;
            }
            return true;
        }
        if (mediaType != 0) {
            return true;
        }
        Iterator<String> it = this.f179647f.iterator();
        while (true) {
            if (it.hasNext()) {
                if (QAlbumUtil.getMediaType(this.f179650h.r(it.next())) == 1) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (z16 || this.f179647f.size() >= this.M) {
            return false;
        }
        return true;
    }

    protected boolean C() {
        SessionInfo sessionInfo;
        if (q() == 0 || this.H0 || (sessionInfo = this.F) == null) {
            return false;
        }
        int i3 = sessionInfo.f179555d;
        if (i3 != 0 && i3 != 1000 && i3 != 1004) {
            return false;
        }
        return true;
    }

    public void D(int i3, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "onActivityResult, requestCode = " + i3);
        }
        switch (i3) {
            case 10004:
            case 10006:
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOPREVIEW_RETURE");
                }
                com.tencent.mobileqq.activity.photo.j.h(getContext(), intent, true, this.R);
                Iterator<String> it = this.f179647f.iterator();
                while (it.hasNext()) {
                    LocalMediaInfo r16 = this.f179650h.r(it.next());
                    if (r16 != null) {
                        r16.mChecked = false;
                    }
                }
                this.f179645e = intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
                this.f179647f.clear();
                this.P.clear();
                if (stringArrayListExtra != null) {
                    Iterator<String> it5 = stringArrayListExtra.iterator();
                    while (it5.hasNext()) {
                        String next = it5.next();
                        this.f179647f.add(next);
                        LocalMediaInfo r17 = this.f179650h.r(next);
                        if (r17 != null) {
                            if (!r17.mChecked) {
                                r17.mChecked = true;
                            }
                            this.P.add(r17.position);
                        }
                    }
                }
                this.f179650h.notifyDataSetChanged();
                c0();
                return;
            case 10005:
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOLIST_PANEL_SEND_RETURN");
                }
                w();
                return;
            default:
                return;
        }
    }

    public void E() {
        ArrayList arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked");
        }
        e eVar = this.f179663r0;
        if (eVar != null && eVar.j(this)) {
            return;
        }
        if (this.F.f179555d == 1) {
            try {
                ((com.tencent.mobileqq.troop.troopphoto.api.a) ((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.G)).getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER)).t(this.F.f179557e, true);
            } catch (AccountNotMatchException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked() getAppRuntime ERROR");
                }
            }
        }
        if (!this.f179647f.isEmpty()) {
            arrayList = new ArrayList(this.f179647f);
        } else {
            arrayList = null;
        }
        ArrayList arrayList2 = arrayList;
        if (this.D0) {
            this.D.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        }
        this.D.putExtra(PeakConstants.FROM_PHOTO_LIST_PANEL, true);
        this.D.putExtra(PeakConstants.REQUEST_CODE, 10006);
        this.D.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, this.f179645e);
        this.D.putExtra(PeakConstants.IS_TROOP_SEND_MIXED_MSG, this.F0);
        this.D.putExtra(PeakConstants.DISABLE_UPLOAD_TO_TROOP_ALBUM, this.f179642c0);
        this.D.putExtra(PeakConstants.UPLOAD_CHECKBOX_IS_CHECKED, A());
        this.D.putExtra(PeakConstants.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR, C());
        this.D.putExtra(PeakConstants.IS_SUPPORT_COMMENT_IN_PREVIEW, com.tencent.mobileqq.activity.photo.aiocomment.d.a(this.C, this.F));
        HashMap<LocalMediaInfo, LocalMediaInfo> hashMap = this.R;
        if (hashMap != null && !hashMap.isEmpty()) {
            this.D.putExtra(PeakConstants.SEND_NO_PRESEND, true);
        }
        SessionInfo sessionInfo = this.F;
        if (sessionInfo.f179555d == 10014) {
            try {
                String str = "select_photos_from_" + this.F.f179557e;
                this.D.putParcelableArrayListExtra(str, (ArrayList) this.F.b().get(str));
                this.D.putExtra(PeakConstants.REQUEST_CODE, 10014);
                this.D.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
                PlusPanelUtils.g(this.C, this.E, this.F, arrayList2, this.D, this.R);
            } catch (Exception e16) {
                QLog.e("PhotoListPanel", 2, e16.getMessage());
            }
        } else {
            PlusPanelUtils.g(this.C, this.E, sessionInfo, arrayList2, this.D, this.R);
            Q();
            ReportController.o(null, "CliOper", "", "", "0X8005E05", "0X8005E05", 0, 0, "", "", "", "");
        }
        r();
    }

    public void F() {
        Activity activity = this.E;
        if ((activity instanceof QBaseActivity) && ((QBaseActivity) activity).isInMultiWindow()) {
            QQToast.makeText(this.E, R.string.lwl, 0).show();
            return;
        }
        if (hf0.a.b("PhotoListPanel", 500L)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "onEditBtnClicked");
        }
        if (this.f179647f.size() > 0) {
            if (this.f179650h.p(this.f179647f.peek()) == 1) {
                n();
                return;
            }
            Intent startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(this.E, this.f179647f.get(0), true, true, true, true, true, 2, 140, 5);
            startEditPic.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, this.f179645e);
            startEditPic.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", z());
            startEditPic.putExtra(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
            this.E.startActivity(startEditPic);
            if (this.E instanceof SplashActivity) {
                ReportController.o(null, "dc00898", "", "", "0X800A06B", "0X800A06B", 0, 0, "", "", "", "");
            }
        }
    }

    public void G(final View view, final int i3) {
        if (this.f179650h == null) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A913", "0X800A913", PhotoUtils.getTypeforReport2(this.F), 0, "", "", "", "");
        int itemViewType = this.f179650h.getItemViewType(i3);
        if (this.D0) {
            I(this.f179650h.q(i3).path);
            return;
        }
        if (itemViewType == 0 || itemViewType == 1) {
            FileUtils.fileExistsAndNotEmpty(this.f179650h.q(i3).path, new FileUtils.OnFileExistsAndNotEmptyResult() { // from class: com.tencent.mobileqq.activity.aio.photo.o
                @Override // com.tencent.mobileqq.utils.FileUtils.OnFileExistsAndNotEmptyResult
                public final void onComplete(boolean z16) {
                    PhotoListPanel.this.B(view, i3, z16);
                }
            });
        }
        O(itemViewType);
    }

    protected void H() {
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "onSendBtnClicked");
        }
        e eVar = this.f179663r0;
        if (eVar != null && eVar.R(this)) {
            return;
        }
        V(false, null);
    }

    public void I(String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.E, IPhotoLogicFactory.PHOTO_PREVIEW_ACTIVITY_URI);
        Intent intent = this.D;
        if (intent != null && intent.getExtras() != null) {
            activityURIRequest.extra().putAll(this.D.getExtras());
        }
        activityURIRequest.extra().putString(QAlbumConstants.ALBUM_ID, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID);
        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, this.E0);
        activityURIRequest.extra().putString("uin", this.F.f179557e);
        activityURIRequest.extra().putInt("uintype", this.F.f179555d);
        activityURIRequest.extra().putString("troop_uin", this.F.f179559f);
        activityURIRequest.extra().putString("uinname", this.F.f179563i);
        Intent intent2 = this.D;
        if (intent2 == null || !intent2.hasExtra("showFlashPic")) {
            QQAppInterface qQAppInterface = this.C;
            if (qQAppInterface != null) {
            }
            Bundle extra = activityURIRequest.extra();
            IPicFlash iPicFlash = (IPicFlash) QRoute.api(IPicFlash.class);
            SessionInfo sessionInfo = this.F;
            extra.putBoolean("showFlashPic", iPicFlash.showFlashPicOption(sessionInfo.f179555d, sessionInfo.f179559f));
        }
        if (this.E instanceof SplashActivity) {
            activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
            activityURIRequest = BaseAIOUtils.n(activityURIRequest, null);
        } else {
            activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        }
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putString("key_activity_code", ChatActivityUtils.p(this.E));
        if (this.F.f179555d == 9501) {
            if (this.E instanceof SplashActivity) {
                activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SplashActivity.getAliasName());
                activityURIRequest = BaseAIOUtils.n(activityURIRequest, null);
            } else {
                activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, ChatActivity.class.getName());
            }
            activityURIRequest.extra().putInt(com.tencent.mobileqq.utils.d.f307603i, 80);
            activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
            activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, false);
        } else {
            activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
            activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
            activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, true);
            activityURIRequest.extra().putInt(ConfessInfo.KEY_CONFESS_TOPICID, this.F.S);
        }
        activityURIRequest.extra().putString(PeakConstants.DEST_VIDEO_ACTIVITY_CLASS_NAME, SendVideoActivity.class.getName());
        activityURIRequest.extra().putString(PeakConstants.DEST_VIDEO_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
        activityURIRequest.extra().putInt(QAlbumConstants.CURRENT_QUALITY_TYPE, this.f179645e);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_OVERLOAD, false);
        activityURIRequest.setFlags(603979776);
        activityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
        activityURIRequest.extra().putString("PhotoConst.SINGLE_PHOTO_PATH", str);
        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, this.E0);
        activityURIRequest.extra().putBoolean(PeakConstants.ALLOW_LOCK, false);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 1);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAIO.T);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationAIO.f184370j);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAIO.R);
        activityURIRequest.extra().putBoolean("PHOTO_PREVIEW_NEED_DRAG_KEY", true);
        QRoute.startUri(activityURIRequest);
    }

    void J(String str, int i3) {
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(this.F.f179557e) || this.S || !this.T) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "presendPic, path = " + str);
        }
        Bundle bundle = new Bundle();
        bundle.putString(PeakConstants.KEY_PRESEND_PATH, str);
        bundle.putInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, this.F.P);
        RichmediaService.x(bundle);
    }

    public void M(boolean z16, Intent intent) {
        if (z16) {
            this.E.startActivityForResult(intent, 10005);
        } else {
            this.E.startActivity(intent);
        }
    }

    public void N() {
        TextView textView = (TextView) this.f179658m0.findViewById(R.id.fbx);
        int i3 = getResources().getDisplayMetrics().densityDpi;
        if (i3 < 320) {
            textView.setCompoundDrawables(null, null, null, null);
        }
        if (R0 == 0) {
            this.f179658m0.setVisibility(0);
            this.f179644d0.setVisibility(8);
        }
        this.f179657m = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "densityDpi = " + i3 + "query time=" + this.f179657m);
        }
        ThreadManagerV2.excute(new QueryMediaTask(), 16, null, true);
    }

    public void Q() {
        R(true);
    }

    public void R(boolean z16) {
        if (z16) {
            if (this.f179647f.size() > 0) {
                this.f179650h.v();
            }
            this.f179647f.clear();
            this.P.clear();
            this.f179650h.notifyDataSetChanged();
            this.f179654j0.setChecked(false);
            this.R.clear();
            Intent intent = this.E.getIntent();
            if (intent != null) {
                intent.removeExtra("PhotoConst.SELECTED_PATHS");
                intent.removeExtra(QAlbumConstants.SELECTED_INDEXS);
                intent.removeExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "resetStatus selectSize:" + this.f179647f.size() + ", clear:" + z16);
        }
        c0();
        setMixedMsgMode(false);
    }

    void T(Pair<ArrayList<String>, ArrayList<String>> pair, boolean z16) {
        ArrayList<String> arrayList;
        if (pair.first.isEmpty()) {
            arrayList = pair.second;
        } else {
            arrayList = pair.first;
        }
        String str = arrayList.get(0);
        LocalMediaInfo r16 = this.f179650h.r(str);
        if (r16 == null) {
            return;
        }
        com.tencent.mobileqq.pic.f.b("TAG", "sendVideo", "info = " + r16 + ",sendInBackground = " + z16);
        Intent intent = new Intent(this.E, (Class<?>) SendVideoActivity.class);
        intent.putExtra(PeakConstants.SEND_IN_BACKGROUND, z16);
        if (!pair.second.isEmpty()) {
            ArrayList<String> arrayList2 = new ArrayList<>(1);
            arrayList2.add(str);
            intent.putStringArrayListExtra(PeakConstants.PHOTO_PATHS_BY_FILE, arrayList2);
        } else {
            intent.putExtra("file_send_path", str);
            intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, r16.fileSize);
            intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, r16.mDuration);
        }
        intent.putExtra("uin", this.F.f179557e);
        intent.putExtra("uintype", this.F.f179555d);
        intent.putExtra(PeakConstants.SEND_SIZE_SPEC, this.f179645e);
        intent.putExtra(ShortVideoConstants.FILE_SOURCE, ShortVideoConstants.FILE_SOURCE_ALBUM_FLOW);
        String stringExtra = this.E.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        String stringExtra2 = this.E.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", stringExtra);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", stringExtra2);
        if (!r16.isSystemMeidaStore) {
            ReportController.o(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
        }
        if (this.f179645e == 2) {
            com.tencent.mobileqq.utils.e.o(0, 1);
        }
        intent.putExtra(ShortVideoConstants.START_INIT_ACTIVITY_AFTER_SENDED, false);
        if (z16) {
            Z(intent);
        } else {
            this.E.startActivity(intent);
        }
    }

    protected void U(ArrayList<String> arrayList, int i3) {
        ReceiptMsgManager.n().u(this.C, this.F, arrayList, i3);
    }

    public boolean V(boolean z16, a61.c cVar) {
        return W(cVar, this.f179647f, z16);
    }

    public boolean W(a61.c cVar, List<String> list, boolean z16) {
        boolean z17;
        boolean z18;
        int i3;
        boolean z19;
        Pair<ArrayList<String>, ArrayList<String>> pair = new Pair<>(new ArrayList(), new ArrayList());
        SendByFile sendByFile = this.L0;
        int i16 = 2;
        if (sendByFile != null) {
            if (this.f179645e == 2) {
                z19 = true;
            } else {
                z19 = false;
            }
            pair = sendByFile.b(list, z19, this.f179652i, null);
        } else {
            pair.first.addAll(list);
        }
        if (o() > 0 && z16 && cVar != null && !pair.first.isEmpty()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            X(cVar, pair);
            int i17 = this.F.f179555d;
            if (i17 == 0) {
                i3 = 1;
            } else {
                if (i17 != 1) {
                    if (i17 == 3000) {
                        i16 = 3;
                    } else {
                        i3 = 0;
                    }
                }
                i3 = i16;
            }
            ReportController.o(this.C, "CliOper", "", "", "0X8009BEB", "0X8009BEB", i3, 0, "", "", "", "");
        } else {
            com.tencent.mobileqq.activity.richmedia.f.l(list);
            if (A() && C()) {
                z18 = true;
            } else {
                z18 = false;
            }
            Y(pair.first, pair.second, this.T);
            if (z18) {
                LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(LpReportInfoConfig.ACTION_TYPE_AIO_SYNC_QZONE, 1, 5), false, false);
                RetentionReport.report(8);
            }
        }
        Q();
        return z17;
    }

    public void Y(@NonNull final ArrayList<String> arrayList, final ArrayList<String> arrayList2, final boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "sendMedias, paths.size() = " + arrayList.size() + ",allowPresend = " + z16);
        }
        boolean s16 = s(arrayList);
        if (!s16) {
            s16 = s(arrayList2);
        }
        if (!s16) {
            if (QLog.isColorLevel()) {
                QLog.e("PhotoListPanel", 2, "PhotoListPanel sendMedias,pics not exits, just return.");
            }
            if (f() || !arrayList.isEmpty() || !arrayList2.isEmpty()) {
                QQToast.makeText(this.E, R.string.cwh, 0).show();
            }
            N();
            this.f179647f.clear();
            this.P.clear();
            c0();
            return;
        }
        if (!t()) {
            return;
        }
        if (y(arrayList, arrayList2)) {
            DialogUtil.createCustomDialog(this.E, 232, null, getResources().getString(R.string.f173101he2), new c(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.7
                @Override // java.lang.Runnable
                public void run() {
                    PhotoListPanel.this.getClass();
                    PhotoListPanel.this.m(arrayList, arrayList2, z16);
                    com.tencent.mobileqq.shortvideo.h.f287891c = System.currentTimeMillis();
                }
            }), new d()).show();
            if (QLog.isColorLevel()) {
                QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
                return;
            }
            return;
        }
        m(arrayList, arrayList2, z16);
    }

    protected void Z(Intent intent) {
        final com.tencent.mobileqq.activity.shortvideo.h hVar = new com.tencent.mobileqq.activity.shortvideo.h((BaseActivity) this.E, intent);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.3
            @Override // java.lang.Runnable
            public void run() {
                PhotoListPanel.this.l(hVar);
            }
        });
    }

    public void c0() {
        Activity activity = this.E;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.10
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    String string = PhotoListPanel.this.E.getResources().getString(R.string.cvd);
                    if (PhotoListPanel.this.A()) {
                        string = PhotoListPanel.this.E.getResources().getString(R.string.cvf);
                    }
                    boolean z17 = false;
                    boolean z18 = true;
                    if (PhotoListPanel.this.f179647f.size() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        PhotoListPanel.this.f179661p0.setContentDescription(string + PhotoListPanel.this.f179647f.size() + HardCodeUtil.qqStr(R.string.p5a));
                        string = string + "(" + PhotoListPanel.this.f179647f.size() + ")";
                    }
                    PhotoListPanel.this.f179661p0.setText(string);
                    PhotoListPanel.this.f179661p0.setEnabled(z16);
                    if (!z16) {
                        PhotoListPanel.this.f179653i0.setEnabled(false);
                        PhotoListPanel.this.f179654j0.setEnabled(true);
                        PhotoListPanel.this.f179655k0.setEnabled(true);
                        PhotoListPanel.this.f179656l0.setEnabled(true);
                        PhotoListPanel.this.f179649g0.setEnabled(true);
                        PhotoListPanel.this.e0();
                    } else {
                        PhotoListPanel photoListPanel = PhotoListPanel.this;
                        if (photoListPanel.f179650h.p(photoListPanel.f179647f.peek()) == 1) {
                            PhotoListPanel photoListPanel2 = PhotoListPanel.this;
                            TextView textView = photoListPanel2.f179653i0;
                            if (!photoListPanel2.O0 || PhotoListPanel.this.f179647f.size() != 1 || PhotoListPanel.this.A()) {
                                z18 = false;
                            }
                            textView.setEnabled(z18);
                            PhotoListPanel photoListPanel3 = PhotoListPanel.this;
                            if (!photoListPanel3.f179641b0) {
                                photoListPanel3.f179649g0.setEnabled(false);
                            }
                        } else {
                            PhotoListPanel.this.f179654j0.setEnabled(true);
                            PhotoListPanel.this.f179655k0.setEnabled(true);
                            PhotoListPanel.this.f179656l0.setEnabled(true);
                            PhotoListPanel photoListPanel4 = PhotoListPanel.this;
                            TextView textView2 = photoListPanel4.f179653i0;
                            if (photoListPanel4.f179647f.size() == 1 && !PhotoListPanel.this.A()) {
                                z17 = true;
                            }
                            textView2.setEnabled(z17);
                        }
                        PhotoListPanel.this.e0();
                    }
                    PhotoListPanel.this.getClass();
                }
            });
        }
    }

    public void d0() {
        int i3;
        int i16;
        int[] findFirstVisibleItemPositions = ((StaggeredGridLayoutManager) this.f179646e0).findFirstVisibleItemPositions(null);
        int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) this.f179646e0).findLastVisibleItemPositions(null);
        if (findFirstVisibleItemPositions.length > 0) {
            i3 = findFirstVisibleItemPositions[0];
        } else {
            i3 = 0;
        }
        if (findLastVisibleItemPositions.length > 0) {
            i16 = findLastVisibleItemPositions[0];
        } else {
            i16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("check", 2, "updateCheckView first=" + i3 + "lastvisible=" + i16);
        }
        for (int i17 = i3; i17 <= i16; i17++) {
            PhotoPanelAdapter.b bVar = (PhotoPanelAdapter.b) this.f179644d0.findViewHolderForAdapterPosition(i17);
            LocalMediaInfo q16 = this.f179650h.q(i17);
            if (q16 != null) {
                int indexOf = this.f179647f.indexOf(q16.path);
                if (QLog.isColorLevel()) {
                    QLog.d("check", 2, "updateCheckView mIndex=" + indexOf);
                }
                if (indexOf >= 0 && bVar != null) {
                    bVar.f179689f.setText(String.valueOf(indexOf + 1));
                    bVar.f179689f.setChecked(true);
                    bVar.f179692m.setVisibility(0);
                } else if (bVar == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("check", 2, "updateCheckView view is null?????=");
                    }
                } else {
                    bVar.f179689f.setChecked(false);
                    bVar.f179689f.setText("");
                    bVar.f179692m.setVisibility(4);
                }
            }
        }
        Iterator<Integer> it = this.P.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue < i3 || intValue > i16) {
                this.f179650h.notifyItemChanged(intValue);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    void e0() {
        if (this.V) {
            return;
        }
        int i3 = this.f179645e;
        if (i3 != 0) {
            if (i3 == 2) {
                com.tencent.mobileqq.activity.photo.album.j.l(this.f179656l0, this.f179647f, this.f179652i, true, this.E, null, null);
                this.f179654j0.setChecked(true);
                return;
            }
            return;
        }
        this.f179654j0.setChecked(false);
    }

    public boolean f() {
        if (!z() && !com.tencent.biz.anonymous.a.h().d(this.F.f179557e)) {
            return true;
        }
        return false;
    }

    public void f0() {
        View findViewById = findViewById(R.id.sjf);
        if (findViewById != null) {
            findViewById.setBackgroundColor(getContext().getResources().getColor(R.color.qui_common_border_standard));
        }
    }

    public void g(int i3) {
        if (this.S || !this.T) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "cancelAllPresendPic, type = " + i3);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(PeakConstants.KEY_PRESEND_CANCEL_TYPE, i3);
        RichmediaService.t(bundle);
    }

    void h(String str) {
        if (this.S || !this.T) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "cancelPresendPic, path = " + str);
        }
        Bundle bundle = new Bundle();
        bundle.putString(PeakConstants.KEY_PRESEND_PATH, str);
        bundle.putInt(PeakConstants.KEY_PRESEND_CANCEL_TYPE, 1018);
        RichmediaService.u(bundle);
    }

    public HashMap<String, String> i() {
        return com.tencent.mobileqq.activity.photo.j.a(this.R);
    }

    public f j() {
        return new f();
    }

    protected void l(com.tencent.mobileqq.activity.shortvideo.h hVar) {
        hVar.g();
        String str = hVar.f186345c;
        if (str != null && !str.equals("")) {
            hVar.d();
        }
    }

    void m(@NonNull ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z16) {
        boolean z17 = z();
        int i3 = this.f179645e;
        HashMap hashMap = new HashMap();
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < arrayList.size(); i18++) {
            String str = arrayList.get(i18);
            if (this.f179650h.p(str) == 1) {
                LocalMediaInfo r16 = this.f179650h.r(str);
                if (r16 != null) {
                    SendVideoInfo sendVideoInfo = new SendVideoInfo();
                    sendVideoInfo.fileSize = r16.fileSize;
                    sendVideoInfo.duration = r16.mDuration;
                    hashMap.put(Integer.valueOf(i18), sendVideoInfo);
                    i17++;
                }
            } else {
                i16++;
            }
        }
        ReportController.o(null, "CliOper", "", "", "0X8009AAF", "0X8009AAF", PhotoUtils.getTypeforReportSpcialDiscuss(this.F), 0, String.valueOf(i16), String.valueOf(i17), "", "");
        if (z17 && i16 > 0 && i17 == 0) {
            U(arrayList, i3);
            return;
        }
        Intent intent = new Intent(this.E, (Class<?>) SendPhotoActivity.class);
        intent.putStringArrayListExtra(PeakConstants.PHOTO_PATHS_BY_FILE, arrayList2);
        intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, this.E0);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        if (!hashMap.isEmpty()) {
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
        }
        intent.putExtra(PeakConstants.PHOTO_COUNT, arrayList.size());
        intent.putExtra("uin", this.F.f179557e);
        intent.putExtra("uintype", this.F.f179555d);
        intent.putExtra("troop_uin", this.F.f179559f);
        intent.putExtra(ConfessInfo.KEY_CONFESS_TOPICID, this.F.S);
        intent.putExtra(PeakConstants.SEND_SIZE_SPEC, i3);
        intent.putExtra(PeakConstants.IS_WAIT_DEST_RESULT, true);
        intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, this.F.P);
        intent.putExtra("key_pic_send_source", 8);
        if (arrayList.size() == 1) {
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList);
        }
        intent.putExtra("need_status_bar", !this.E.getIntent().getBooleanExtra("KEY_OPEN_MINI_CHAT", false));
        if (z16 && i3 == 2) {
            g(1020);
        }
        M(p.b(z16, i3, intent), intent);
    }

    public int o() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.f179647f.size(); i16++) {
            if (this.f179650h.p(this.f179647f.get(i16)) == 0) {
                i3++;
            }
        }
        return i3;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        int id5 = compoundButton.getId();
        if (id5 == R.id.h1y) {
            if (z16) {
                SendByFile sendByFile = this.L0;
                if (sendByFile != null) {
                    sendByFile.d(getContext(), this.f179647f, z16, this.f179652i, null);
                }
                this.f179654j0.setChecked(true);
                this.f179645e = 2;
                com.tencent.mobileqq.activity.photo.album.j.l(this.f179656l0, this.f179647f, this.f179652i, true, this.E, null, null);
                this.f179655k0.setContentDescription(HardCodeUtil.qqStr(R.string.p5s));
                ReportController.o(null, "CliOper", "", "", "0X8005E07", "0X8005E07", 0, 0, "", "", "", "");
            } else {
                this.f179645e = 0;
                this.f179654j0.setChecked(false);
                this.f179656l0.setVisibility(4);
                this.f179655k0.setContentDescription(HardCodeUtil.qqStr(R.string.p4j));
            }
            L();
        } else if (id5 == R.id.cxg) {
            this.I0 = z16;
            c0();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f164256p2) {
            E();
        } else if (id5 == R.id.ekt) {
            F();
        } else if (id5 != R.id.f166661h24 && id5 != R.id.h1z) {
            if (id5 == R.id.send_btn) {
                Iterator<Integer> it = this.P.iterator();
                while (it.hasNext()) {
                    ReportController.o(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", it.next().intValue() + 1, 0, "2", "", "", "");
                }
                int typeforReport2 = PhotoUtils.getTypeforReport2(this.F);
                ReportController.o(null, "dc00898", "", "", "0X800A912", "0X800A912", this.P.size(), 0, "" + typeforReport2, "", "", "");
                H();
            } else if (id5 == R.id.kk5) {
                if (this.F.f179555d == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean C = C();
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                userInfo.qzone_uin = this.G;
                userInfo.nickname = this.H;
                if (z16) {
                    Activity activity = this.E;
                    SessionInfo sessionInfo = this.F;
                    QZoneHelper.forwardToQunAlbumListSelect(activity, userInfo, sessionInfo.f179557e, sessionInfo.f179563i, 10008);
                } else if (C) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_personal_album_enter_model", 0);
                    bundle.putString("key_title", this.E.getString(R.string.gp6));
                    bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_IS_SELECT_VIDEO, false);
                    if (!TextUtils.isEmpty(this.M0)) {
                        bundle.putString(QZoneHelper.QZonePersonalAlbumContants.KEY_DEFAULT_ALBUM_ID, this.M0);
                        bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_FROM_UPLOAD, true);
                    }
                    QZoneHelper.forwardToPersonalAlbumSelect(this.E, userInfo, bundle, 10009);
                    LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(LpReportInfoConfig.ACTION_TYPE_AIO_SYNC_QZONE, 1, 4), false, false);
                }
            } else if (id5 != R.id.fhh && id5 != R.id.f167081kk3 && id5 == R.id.cxg) {
                boolean A = A();
                if (C()) {
                    if (A) {
                        i3 = 2;
                    } else {
                        i3 = 3;
                    }
                    LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(LpReportInfoConfig.ACTION_TYPE_AIO_SYNC_QZONE, 1, i3), false, false);
                } else if (A) {
                    QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
                    reportInfo.toUin = Long.valueOf(this.G).longValue();
                    reportInfo.actionType = "459";
                    reportInfo.subactionType = "3";
                    QZoneClickReport.report(this.G, reportInfo, true);
                } else {
                    QZoneClickReport.ReportInfo reportInfo2 = new QZoneClickReport.ReportInfo();
                    reportInfo2.toUin = Long.valueOf(this.G).longValue();
                    reportInfo2.actionType = "459";
                    reportInfo2.subactionType = "2";
                    QZoneClickReport.report(this.G, reportInfo2, true);
                }
            }
        } else if (!this.f179654j0.isChecked()) {
            this.f179654j0.setChecked(true);
        } else {
            this.f179654j0.setChecked(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.a aVar = this.P0;
        if (aVar != null) {
            aVar.f();
            this.P0 = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    protected int p() {
        return (int) ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
    }

    protected int q() {
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_C2C_AIO_ENABLE_SYNC_IMAGE_TO_QZONE, 1);
    }

    void r() {
        View view = this.f179660o0;
        if (view != null && view.getVisibility() == 0) {
            this.f179660o0 = null;
            this.f179666u0 = false;
            this.f179650h.notifyDataSetChanged();
        }
    }

    protected boolean s(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return false;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (FileUtils.fileExistsAndNotEmpty(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void setCustomOnClickListener(e eVar) {
        this.f179663r0 = eVar;
    }

    public void setImageOnly(boolean z16) {
        boolean z17;
        Boolean bool = this.G0;
        if (bool == null && !z16) {
            this.D.removeExtra("showFlashPic");
        } else {
            Intent intent = this.D;
            if (!z16 && bool.booleanValue()) {
                z17 = true;
            } else {
                z17 = false;
            }
            intent.putExtra("showFlashPic", z17);
        }
        MediaFileFilter mediaFileFilter = this.A0;
        if (mediaFileFilter == null) {
            return;
        }
        if (z16) {
            this.B0 = mediaFileFilter;
            this.A0 = MediaFileFilter.getFilter(1);
            return;
        }
        MediaFileFilter mediaFileFilter2 = this.B0;
        if (mediaFileFilter2 != null) {
            this.A0 = mediaFileFilter2;
            this.B0 = null;
        }
    }

    public void setLastRequestCode(int i3) {
        this.K0 = i3;
    }

    public void setMediaFileFilter(int i3) {
        this.A0 = MediaFileFilter.getFilter(i3);
        if (b0()) {
            this.A0.needWebp = true;
        }
    }

    public void setMixedMsgMode(boolean z16) {
        this.F0 = z16;
    }

    public void setReceiptMode(boolean z16, QQAppInterface qQAppInterface) {
        boolean z17;
        this.D.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", z16);
        if (this.f179642c0 != z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        setImageOnly(z16);
        this.f179642c0 = z16;
        if (z16) {
            this.M = Math.min(com.tencent.mobileqq.receipt.a.a(qQAppInterface), this.M);
            this.f179644d0.setOnTouchListener(null);
        } else {
            this.f179644d0.setOnTouchListener(null);
            this.M = this.D.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
            if (this.F.f179555d == 9501) {
                this.M = 5;
            }
        }
        if (z17) {
            Q();
        }
    }

    public void setSelectLimitListener(i iVar) {
        this.f179664s0 = iVar;
    }

    protected boolean t() {
        boolean z16;
        boolean z17;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory.exists() && externalStorageDirectory.canRead()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Environment.getExternalStorageState().equals("mounted") && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            QQToast.makeText(this.E, 1, R.string.h9v, 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            QLog.w("PhotoListPanel", 1, "hasSDCardAndSpace() media mounted:" + Environment.getExternalStorageState().equals("mounted") + ", externalDir.exists():" + externalStorageDirectory.exists() + ", externalDir.getAbsolutePath():" + externalStorageDirectory.getAbsolutePath() + ", externalDir.canWrite():" + externalStorageDirectory.canWrite() + ", externalDir.canRead():" + externalStorageDirectory.canRead());
            return false;
        }
        if (Utils.z() > 512000) {
            return true;
        }
        ShortVideoPreviewActivity.showAlertDialog(this.E, R.string.hlp);
        return false;
    }

    public void u(QQAppInterface qQAppInterface, Activity activity, com.tencent.mobileqq.activity.aio.p pVar, Intent intent) {
        v();
        this.C = qQAppInterface;
        this.D = intent;
        if (intent == null) {
            this.D = new Intent();
        }
        if (this.D.hasExtra("showFlashPic")) {
            this.G0 = Boolean.valueOf(this.D.getBooleanExtra("showFlashPic", false));
        }
        this.S = this.D.getBooleanExtra("key_disable_presend", false);
        this.V = this.D.getBooleanExtra("key_disable_quality_cb", false);
        this.W = this.D.getBooleanExtra("key_disable_edit_btn", false);
        this.f179640a0 = this.D.getBooleanExtra("key_disable_send_btn", false);
        this.U = this.D.getBooleanExtra("key_new_lbs_client", false);
        this.f179641b0 = this.D.getBooleanExtra("key_allow_mix_select", true);
        this.G = this.D.getStringExtra("key_my_uin");
        this.H = this.D.getStringExtra("key_my_nick");
        this.I = this.D.getStringExtra("key_my_head_dir");
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "init, mDisablePresend = " + this.S);
        }
        if (pVar instanceof SessionInfo) {
            this.F = (SessionInfo) pVar;
        }
        this.E = activity;
        Intent intent2 = activity.getIntent();
        this.M = this.D.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
        int i3 = this.F.f179555d;
        if (i3 == 9501) {
            this.M = 5;
            this.D.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 5);
        } else if (i3 == 10014) {
            com.tencent.mobileqq.activity.photo.j.i(getContext(), this.R, ((IGuildSelectMediaNotifyService) qQAppInterface.getRuntimeService(IGuildSelectMediaNotifyService.class, "")).getSelectedMediaInfos(this.F));
        }
        this.N = this.D.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
        this.A0 = MediaFileFilter.getFilter(this.D.getIntExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 0));
        this.C0 = this.D.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
        this.D0 = this.D.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
        this.E0 = this.D.getIntExtra(PeakConstants.SEND_BUSINESS_TYPE, 1052);
        if (this.C0) {
            MediaFileFilter mediaFileFilter = this.A0;
            mediaFileFilter.needVideo = false;
            mediaFileFilter.needGif = false;
        }
        this.A0.needWebp = true;
        this.K = (int) getResources().getDimension(R.dimen.f158876rd);
        this.L = (int) getResources().getDimension(R.dimen.f158877re);
        int i16 = this.f179668w0;
        int i17 = this.L;
        this.f179670y0 = new com.tencent.mobileqq.drawable.b(i16, i17, i17);
        int i18 = this.f179669x0;
        int i19 = this.L;
        this.f179671z0 = new com.tencent.mobileqq.drawable.b(i18, i19, i19);
        if (intent2.hasExtra("PhotoConst.SELECTED_PATHS")) {
            ArrayList<String> stringArrayListExtra = intent2.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
            if (stringArrayListExtra != null) {
                this.f179647f.addAll(stringArrayListExtra);
            }
            ArrayList<Integer> integerArrayListExtra = intent2.getIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS);
            if (integerArrayListExtra != null) {
                this.P.addAll(integerArrayListExtra);
            }
            intent2.removeExtra("PhotoConst.SELECTED_PATHS");
            intent2.removeExtra(QAlbumConstants.SELECTED_INDEXS);
        } else if (this.D.hasExtra("PhotoConst.SELECTED_PATHS")) {
            ArrayList<String> stringArrayListExtra2 = this.D.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
            if (stringArrayListExtra2 != null) {
                this.f179647f.addAll(stringArrayListExtra2);
            }
            ArrayList<Integer> integerArrayListExtra2 = this.D.getIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS);
            if (integerArrayListExtra2 != null) {
                this.P.addAll(integerArrayListExtra2);
            }
        }
        this.L0 = new SendByFile().g(this.J).f(f());
        this.f179645e = this.D.getIntExtra("key_quality_type", 0);
        this.f179662q0 = findViewById(R.id.jst);
        this.f179649g0 = (TextView) findViewById(R.id.f164256p2);
        this.f179651h0 = (FrameLayout) findViewById(R.id.upw);
        this.f179653i0 = (TextView) findViewById(R.id.ekt);
        this.f179659n0 = findViewById(R.id.fhy);
        this.f179654j0 = (QUICheckBox) findViewById(R.id.h1y);
        this.f179655k0 = (TextView) findViewById(R.id.f166661h24);
        this.f179656l0 = (TextView) findViewById(R.id.h1z);
        this.f179658m0 = findViewById(R.id.f_y);
        this.f179661p0 = (TextView) findViewById(R.id.send_btn);
        this.f179649g0.setOnClickListener(this);
        this.f179653i0.setOnClickListener(this);
        if (this.V) {
            this.f179654j0.setVisibility(4);
            this.f179655k0.setVisibility(4);
            this.f179656l0.setVisibility(4);
        } else {
            this.f179654j0.setOnCheckedChangeListener(this);
            this.f179654j0.setContentDescription(HardCodeUtil.qqStr(R.string.p5u));
            this.f179655k0.setOnClickListener(this);
            this.f179655k0.setContentDescription(HardCodeUtil.qqStr(R.string.p56));
            this.f179656l0.setOnClickListener(this);
        }
        if (this.W) {
            this.f179653i0.setVisibility(8);
        }
        if (this.f179640a0) {
            this.f179661p0.setVisibility(4);
        }
        this.f179661p0.setOnClickListener(this);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.f179661p0, "em_aio_image", null);
        this.f179644d0 = (RecyclerView) findViewById(R.id.cg6);
        this.f179646e0 = new a(1, 0);
        this.f179650h = new PhotoPanelAdapter(this);
        this.f179644d0.setLayoutManager(this.f179646e0);
        this.f179644d0.setAdapter(this.f179650h);
        this.f179644d0.addOnScrollListener(new b());
        c0();
        w();
        f0();
        k();
        S();
        this.O0 = ABTestUtil.getVideoEditABTest(this.G);
    }

    public void v() {
        bp.f316777d = bp.a();
    }

    public void w() {
        if (this.S) {
            return;
        }
        this.T = PlusPanelUtils.x(this.F, this.U);
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "initPresend! mAllowPresend = " + this.T);
        }
        if (this.T) {
            SessionInfo sessionInfo = this.F;
            BinderWarpper binderWarpper = new BinderWarpper(new y(sessionInfo.f179555d, sessionInfo.f179557e, sessionInfo.f179559f, this.G, sessionInfo.S).asBinder());
            Bundle bundle = new Bundle();
            bundle.putParcelable(PeakConstants.BINDER_PRESENDSERVICE, binderWarpper);
            RichmediaService.w(bundle);
        }
    }

    protected boolean y(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        boolean z16;
        boolean z17;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                break;
            }
            if (this.f179650h.p(arrayList.get(i3)) == 1) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (com.tencent.mobileqq.shortvideo.h.f287891c != 0 && System.currentTimeMillis() - com.tencent.mobileqq.shortvideo.h.f287891c < MiniBoxNoticeInfo.MIN_5) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "upload video isConfirmed=" + z17 + " allowUploadInXGTime=" + com.tencent.mobileqq.shortvideo.h.f287891c);
        }
        if (NetworkUtil.isMobileNetWork(this.E) && !z17 && z16) {
            return true;
        }
        return false;
    }

    protected boolean z() {
        return this.D.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    }

    public void setImageCountChangedListener(g gVar) {
    }

    public void setImageSentListener(h hVar) {
    }

    public void setOnSwipeUpAndDragListener(bp bpVar) {
    }
}
