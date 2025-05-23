package com.tencent.mobileqq.emotionintegrate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.qq.wx.voice.util.ErrorCode;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.anonymous.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.component.network.utils.Base64;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.image.sharp.SharpImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.ad.emoji.api.ICommercialEmoji;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.w;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.ZPlanPicExtraData;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IAIOEmoticonUtils;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.api.IEmoticonQBoxAuthListener;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionUtils;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.ai.emoticon.AiPanelInfo;
import com.tencent.mobileqq.emotionintegrate.EmotionAdapter;
import com.tencent.mobileqq.emotionintegrate.EmotionDataSource;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.temp.api.IGuildEmoPreviewDataSourceApi;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.dw;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.aio.MsgRevokeEvent;
import com.tencent.qqnt.aio.emoticon.api.IAIOEmoticonApi;
import com.tencent.qqnt.aio.locate.api.IMsgLocationApi;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetJumpInfoReqBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetJumpInfoRspBody;
import com.tencent.qqnt.kernel.nativeinterface.IEmojiHotPicGetJumpInfoResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import v03.a;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AIOEmotionFragment extends AIOEmotionBaseFragment implements Handler.Callback, EmotionGallery.a, Gallery.OnScollListener, EmotionDownGIFCallback.a, AdapterView.OnItemLongClickListener, com.tencent.mobileqq.richmediabrowser.g, DragView.OnGestureChangeListener, DragView.OnDragChangeListener, AdapterView.OnItemSelectedListener, EmotionDataSource.a, View.OnClickListener, AudioPlayerBase.b, CommonAudioPlayer.a, SimpleEventReceiver<MsgRevokeEvent> {
    static IPatchRedirector $redirector_;
    public static IPicEmoticonInfo O0;
    public static p P0;
    private static int Q0;
    private HashMap<Long, Float> A0;
    private float B0;
    private int C0;
    private boolean D0;
    private boolean E0;
    private EmotionDataSource F0;
    private Rect G;
    private float G0;
    final WeakReferenceHandler H;
    private int H0;
    EmotionGallery I;
    private IZPlanEmoticonApi.b I0;
    EmotionAdapter J;
    private boolean J0;
    TextView K;
    private ArrayList<Long> K0;
    Button L;
    private com.tencent.mobileqq.ad.emoji.b L0;
    TextView M;
    private AiPanelInfo M0;
    TextView N;
    private EmoticonObserver N0;
    LinearLayout P;
    TextView Q;
    TextView R;
    TextView S;
    View T;
    ImageView U;
    ImageView V;
    ImageView W;
    com.tencent.common.galleryactivity.l X;
    ImageView Y;
    DragView Z;

    /* renamed from: a0, reason: collision with root package name */
    RelativeLayout f205031a0;

    /* renamed from: b0, reason: collision with root package name */
    View f205032b0;

    /* renamed from: c0, reason: collision with root package name */
    RelativeLayout f205033c0;

    /* renamed from: d0, reason: collision with root package name */
    RelativeLayout f205034d0;

    /* renamed from: e0, reason: collision with root package name */
    TriangleView f205035e0;

    /* renamed from: f0, reason: collision with root package name */
    RelativeLayout f205036f0;

    /* renamed from: g0, reason: collision with root package name */
    PttAudioPlayView f205037g0;

    /* renamed from: h0, reason: collision with root package name */
    PttAudioWaveView f205038h0;

    /* renamed from: i0, reason: collision with root package name */
    private CommonAudioPlayer f205039i0;

    /* renamed from: j0, reason: collision with root package name */
    private WeakReference<URLDrawable> f205040j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f205041k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f205042l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f205043m0;

    /* renamed from: n0, reason: collision with root package name */
    protected View f205044n0;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f205045o0;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f205046p0;

    /* renamed from: q0, reason: collision with root package name */
    private RelativeLayout f205047q0;

    /* renamed from: r0, reason: collision with root package name */
    private ImageView f205048r0;

    /* renamed from: s0, reason: collision with root package name */
    private ImageView f205049s0;

    /* renamed from: t0, reason: collision with root package name */
    SessionInfo f205050t0;

    /* renamed from: u0, reason: collision with root package name */
    AIOContact f205051u0;

    /* renamed from: v0, reason: collision with root package name */
    Emoticon f205052v0;

    /* renamed from: w0, reason: collision with root package name */
    IPicEmoticonInfo f205053w0;

    /* renamed from: x0, reason: collision with root package name */
    ShareActionSheet f205054x0;

    /* renamed from: y0, reason: collision with root package name */
    private l f205055y0;

    /* renamed from: z0, reason: collision with root package name */
    private List<URLDrawable> f205056z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$10, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass10 implements IEmoticonQBoxAuthListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f205057a;

        AnonymousClass10(QQAppInterface qQAppInterface) {
            this.f205057a = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this, (Object) qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.api.IEmoticonQBoxAuthListener
        public void onGetAuthResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3, str) { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.10.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f205059d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f205060e;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$10$1$a */
                    /* loaded from: classes12.dex */
                    class a implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                return;
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            MarketFaceItemBuilder.i(anonymousClass1.f205060e, AnonymousClass10.this.f205057a);
                            MarketFaceItemBuilder.k(2);
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$10$1$b */
                    /* loaded from: classes12.dex */
                    class b implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        b() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            } else {
                                MarketFaceItemBuilder.k(1);
                            }
                        }
                    }

                    {
                        this.f205059d = i3;
                        this.f205060e = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass10.this, Integer.valueOf(i3), str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (this.f205059d == 1) {
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            AIOEmotionFragment.this.Yi(anonymousClass10.f205057a);
                        } else {
                            MarketFaceItemBuilder.m(new a(), new b(), AIOEmotionFragment.this.D);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$11, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass11 implements IEmoticonQBoxAuthListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f205064a;

        AnonymousClass11(QQAppInterface qQAppInterface) {
            this.f205064a = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this, (Object) qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.api.IEmoticonQBoxAuthListener
        public void onGetAuthResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3, str) { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.11.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f205066d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f205067e;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$11$1$a */
                    /* loaded from: classes12.dex */
                    class a implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                return;
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            MarketFaceItemBuilder.i(anonymousClass1.f205067e, AnonymousClass11.this.f205064a);
                            MarketFaceItemBuilder.k(2);
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$11$1$b */
                    /* loaded from: classes12.dex */
                    class b implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        b() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            } else {
                                MarketFaceItemBuilder.k(1);
                            }
                        }
                    }

                    {
                        this.f205066d = i3;
                        this.f205067e = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass11.this, Integer.valueOf(i3), str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (this.f205066d == 1) {
                            AIOEmotionFragment.this.Wi();
                        } else {
                            MarketFaceItemBuilder.m(new a(), new b(), AIOEmotionFragment.this.D);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$12, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass12 implements IEmoticonQBoxAuthListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f205071a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f205072b;

        AnonymousClass12(Bundle bundle, QQAppInterface qQAppInterface) {
            this.f205071a = bundle;
            this.f205072b = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AIOEmotionFragment.this, bundle, qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.api.IEmoticonQBoxAuthListener
        public void onGetAuthResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3, str) { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.12.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f205074d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f205075e;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$12$1$a */
                    /* loaded from: classes12.dex */
                    class a implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                return;
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            MarketFaceItemBuilder.i(anonymousClass1.f205075e, AnonymousClass12.this.f205072b);
                            MarketFaceItemBuilder.k(2);
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$12$1$b */
                    /* loaded from: classes12.dex */
                    class b implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        b() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            } else {
                                MarketFaceItemBuilder.k(1);
                            }
                        }
                    }

                    {
                        this.f205074d = i3;
                        this.f205075e = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass12.this, Integer.valueOf(i3), str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (this.f205074d == 1) {
                            AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                            AIOEmotionFragment.this.Xi(anonymousClass12.f205071a);
                        } else {
                            MarketFaceItemBuilder.m(new a(), new b(), AIOEmotionFragment.this.D);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$13, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass13 implements IEmoticonQBoxAuthListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f205079a;

        AnonymousClass13(QQAppInterface qQAppInterface) {
            this.f205079a = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this, (Object) qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.api.IEmoticonQBoxAuthListener
        public void onGetAuthResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3, str) { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.13.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f205081d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f205082e;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$13$1$a */
                    /* loaded from: classes12.dex */
                    class a implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                return;
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            MarketFaceItemBuilder.i(anonymousClass1.f205082e, AnonymousClass13.this.f205079a);
                            MarketFaceItemBuilder.k(2);
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$13$1$b */
                    /* loaded from: classes12.dex */
                    class b implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        b() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            } else {
                                MarketFaceItemBuilder.k(1);
                            }
                        }
                    }

                    {
                        this.f205081d = i3;
                        this.f205082e = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass13.this, Integer.valueOf(i3), str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (this.f205081d == 1) {
                            AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                            AIOEmotionFragment.this.Ph(anonymousClass13.f205079a);
                        } else {
                            MarketFaceItemBuilder.m(new a(), new b(), AIOEmotionFragment.this.D);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$14, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass14 implements IEmoticonQBoxAuthListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f205086a;

        AnonymousClass14(QQAppInterface qQAppInterface) {
            this.f205086a = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this, (Object) qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.api.IEmoticonQBoxAuthListener
        public void onGetAuthResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3, str) { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.14.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f205088d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f205089e;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$14$1$a */
                    /* loaded from: classes12.dex */
                    class a implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                return;
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            MarketFaceItemBuilder.i(anonymousClass1.f205089e, AnonymousClass14.this.f205086a);
                            MarketFaceItemBuilder.k(2);
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment$14$1$b */
                    /* loaded from: classes12.dex */
                    class b implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        b() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            } else {
                                MarketFaceItemBuilder.k(1);
                            }
                        }
                    }

                    {
                        this.f205088d = i3;
                        this.f205089e = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass14.this, Integer.valueOf(i3), str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (this.f205088d == 1) {
                            AIOEmotionFragment.this.fi();
                        } else {
                            MarketFaceItemBuilder.m(new a(), new b(), AIOEmotionFragment.this.D);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MessageRecord f205107a;

        a(MessageRecord messageRecord) {
            this.f205107a = messageRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this, (Object) messageRecord);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                AIOEmotionFragment.this.Ui(this.f205107a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements QueryCallback<EmoticonPackage> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f205109a;

        b(QQAppInterface qQAppInterface) {
            this.f205109a = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this, (Object) qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void postQuery(EmoticonPackage emoticonPackage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                return;
            }
            if (emoticonPackage == null) {
                AIOEmotionFragment.this.cj(this.f205109a, 7);
                return;
            }
            BaseActivity baseActivity = AIOEmotionFragment.this.getBaseActivity();
            QQAppInterface qQAppInterface = this.f205109a;
            AIOEmotionFragment aIOEmotionFragment = AIOEmotionFragment.this;
            MarketFaceItemBuilder.e(7, baseActivity, qQAppInterface, emoticonPackage, aIOEmotionFragment.f205053w0, aIOEmotionFragment.f205050t0, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements QueryCallback<EmoticonPackage> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f205111a;

        c(QQAppInterface qQAppInterface) {
            this.f205111a = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this, (Object) qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void postQuery(EmoticonPackage emoticonPackage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                return;
            }
            if (emoticonPackage == null || emoticonPackage.name == null || (emoticonPackage.mobileFeetype == 0 && emoticonPackage.downloadCount == 0)) {
                AIOEmotionFragment.this.cj(this.f205111a, 6);
                return;
            }
            int i3 = this.f205111a.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis - i3 > 86400 || currentTimeMillis < i3) {
                AIOEmotionFragment.this.cj(this.f205111a, 6);
                return;
            }
            BaseActivity baseActivity = AIOEmotionFragment.this.getBaseActivity();
            QQAppInterface qQAppInterface = this.f205111a;
            AIOEmotionFragment aIOEmotionFragment = AIOEmotionFragment.this;
            MarketFaceItemBuilder.e(6, baseActivity, qQAppInterface, emoticonPackage, aIOEmotionFragment.f205053w0, aIOEmotionFragment.f205050t0, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d extends EmoticonObserver {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements QueryCallback<Emoticon> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f205114a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f205115b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f205116c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f205117d;

            a(int i3, QQAppInterface qQAppInterface, int i16, String str) {
                this.f205114a = i3;
                this.f205115b = qQAppInterface;
                this.f205116c = i16;
                this.f205117d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, d.this, Integer.valueOf(i3), qQAppInterface, Integer.valueOf(i16), str);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.QueryCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void postQuery(Emoticon emoticon) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticon);
                    return;
                }
                int i3 = this.f205114a;
                AIOEmotionFragment aIOEmotionFragment = AIOEmotionFragment.this;
                MarketFaceItemBuilder.j(i3, aIOEmotionFragment.D, this.f205115b, emoticon, this.f205116c, this.f205117d, aIOEmotionFragment.f205050t0, true);
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.EmoticonObserver, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            String qqStr;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            if ((i3 != 6 && i3 != 7 && i3 != 107) || obj == null) {
                return;
            }
            EmoticonResp emoticonResp = (EmoticonResp) obj;
            if (z16) {
                i16 = emoticonResp.delEpId;
                String str = emoticonResp.keySeq;
                if (str != null && !str.equals("")) {
                    qqStr = emoticonResp.keySeq;
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.j8m);
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.j8n);
                i16 = ErrorCode.WX_TTS_ERROR_TEXT_TO_GBK;
            }
            int i17 = i16;
            String str2 = qqStr;
            if (TextUtils.isEmpty(emoticonResp.emoticonId)) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOEmotionFragment", 2, "auth type emoticon id is null");
                }
            } else {
                QQAppInterface sh5 = AIOEmotionFragment.this.sh();
                if (sh5 != null) {
                    ((IEmoticonManagerService) sh5.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticon(String.valueOf(emoticonResp.epId), emoticonResp.emoticonId, new a(i3, sh5, i17, str2));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800B71D", "0X800B71D", 0, 0, "", "", "", "");
                AIOEmotionFragment.this.fi();
                com.tencent.mobileqq.emotionintegrate.report.b bVar = com.tencent.mobileqq.emotionintegrate.report.b.f205282a;
                bVar.b(bVar.a("em_bas_precipitation"));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements ShareActionSheet.OnItemClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
                return;
            }
            int i3 = actionSheetItem.action;
            AIOEmotionFragment.this.f205054x0.dismiss();
            AIOEmotionFragment.this.li(i3, actionSheetItem);
            try {
                AIOEmotionFragment.this.Oi(actionSheetItem);
            } catch (Exception e16) {
                QLog.i("AIOEmotionFragment", 1, "reportShareActionSheetClick", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements QueryCallback<EmoticonPackage> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f205121a;

        g(QQAppInterface qQAppInterface) {
            this.f205121a = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this, (Object) qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void postQuery(EmoticonPackage emoticonPackage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
            } else if (emoticonPackage == null) {
                AIOEmotionFragment.this.cj(this.f205121a, 32);
            } else {
                AIOEmotionFragment.this.ai(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f205123d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f205124e;

        h(String str, String str2) {
            this.f205123d = str;
            this.f205124e = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AIOEmotionFragment.this, str, str2);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((ICommercialEmoji) QRoute.api(ICommercialEmoji.class)).handleClick(this.f205123d, this.f205124e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f205126d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MessageForPic f205127e;

        i(int i3, MessageForPic messageForPic) {
            this.f205126d = i3;
            this.f205127e = messageForPic;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AIOEmotionFragment.this, Integer.valueOf(i3), messageForPic);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                AIOEmotionFragment.this.xh("0X800A7E7");
                AIOEmotionFragment aIOEmotionFragment = AIOEmotionFragment.this;
                aIOEmotionFragment.qj(aIOEmotionFragment.T, false);
                if (this.f205126d == 1) {
                    AIOEmotionFragment.this.xh("0X800A7E9");
                    EmojiHomeUiPlugin.openEmojiDetailPage(AIOEmotionFragment.this.getBaseActivity(), AIOEmotionFragment.this.sh().getAccount(), 8, this.f205127e.picExtraData.emojiPkgId, false, false);
                } else {
                    AIOEmotionFragment.this.xh("0X800A7E8");
                    Intent intent = new Intent(AIOEmotionFragment.this.getBaseActivity(), (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", this.f205127e.picExtraData.webUrl);
                    AIOEmotionFragment.this.getBaseActivity().startActivity(intent);
                }
                com.tencent.mobileqq.emotionintegrate.h.b(AIOEmotionFragment.this.T);
                AIOEmotionFragment.this.Pi("");
            } else if (motionEvent.getAction() == 0) {
                AIOEmotionFragment aIOEmotionFragment2 = AIOEmotionFragment.this;
                aIOEmotionFragment2.qj(aIOEmotionFragment2.T, true);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class j implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                AIOEmotionFragment aIOEmotionFragment = AIOEmotionFragment.this;
                aIOEmotionFragment.qj(aIOEmotionFragment.T, false);
                if (((IZPlanEmoticonApi) QRoute.api(IZPlanEmoticonApi.class)).checkCreateRole()) {
                    String zPlanEmoticonCreateRoleScheme = ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getZPlanEmoticonCreateRoleScheme();
                    SessionInfo sessionInfo = AIOEmotionFragment.this.f205050t0;
                    if (sessionInfo == null) {
                        return false;
                    }
                    String updateSchemeURLWithUin = ((IZPlanApi) QRoute.api(IZPlanApi.class)).updateSchemeURLWithUin(zPlanEmoticonCreateRoleScheme, sessionInfo.f179557e);
                    if (!TextUtils.isEmpty(updateSchemeURLWithUin)) {
                        ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(AIOEmotionFragment.this.D, updateSchemeURLWithUin);
                        AIOEmotionFragment.this.J0 = true;
                        return false;
                    }
                }
                BaseActivity baseActivity = AIOEmotionFragment.this.getBaseActivity();
                if (!baseActivity.isFinishing()) {
                    baseActivity.setResult(1001);
                    baseActivity.finish();
                }
                com.tencent.mobileqq.emotionintegrate.h.b(AIOEmotionFragment.this.T);
                AIOEmotionFragment.this.Pi("");
            } else if (motionEvent.getAction() == 0) {
                AIOEmotionFragment aIOEmotionFragment2 = AIOEmotionFragment.this;
                aIOEmotionFragment2.qj(aIOEmotionFragment2.T, true);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class k implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f205130d;

        k(String str) {
            this.f205130d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this, (Object) str);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                AIOEmotionFragment aIOEmotionFragment = AIOEmotionFragment.this;
                aIOEmotionFragment.qj(aIOEmotionFragment.T, false);
                if (!TextUtils.isEmpty(this.f205130d)) {
                    QQAppInterface sh5 = AIOEmotionFragment.this.sh();
                    BaseActivity baseActivity = AIOEmotionFragment.this.getBaseActivity();
                    AIOEmotionFragment aIOEmotionFragment2 = AIOEmotionFragment.this;
                    AIOEmotionFragment.Ii(sh5, baseActivity, aIOEmotionFragment2.f205052v0.epId, aIOEmotionFragment2.sh().getAccount(), null, -1, this.f205130d);
                    QQAppInterface sh6 = AIOEmotionFragment.this.sh();
                    Emoticon emoticon = AIOEmotionFragment.this.f205052v0;
                    ReportController.o(sh6, "dc00898", "", "", "0X800C289", "0X800C289", 0, 0, "", "", emoticon.epId, emoticon.eId);
                } else {
                    EmojiHomeUiPlugin.openEmojiDetailPage(AIOEmotionFragment.this.getBaseActivity(), AIOEmotionFragment.this.sh().getAccount(), 8, AIOEmotionFragment.this.f205052v0.epId, false, false);
                }
                AIOEmotionFragment.this.xh("0X800997F");
                com.tencent.mobileqq.emotionintegrate.h.b(AIOEmotionFragment.this.T);
            } else if (motionEvent.getAction() == 0) {
                AIOEmotionFragment aIOEmotionFragment3 = AIOEmotionFragment.this;
                aIOEmotionFragment3.qj(aIOEmotionFragment3.T, true);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class l extends EmotionJsonDownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f205132a;

        /* renamed from: b, reason: collision with root package name */
        private Context f205133b;

        /* renamed from: c, reason: collision with root package name */
        private IPicEmoticonInfo f205134c;

        /* renamed from: d, reason: collision with root package name */
        private QQAppInterface f205135d;

        /* renamed from: e, reason: collision with root package name */
        private SessionInfo f205136e;

        /* renamed from: f, reason: collision with root package name */
        private QQProgressDialog f205137f;

        public l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this);
            }
        }

        public void a(int i3, QQAppInterface qQAppInterface, Context context, IPicEmoticonInfo iPicEmoticonInfo, SessionInfo sessionInfo, QQProgressDialog qQProgressDialog) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), qQAppInterface, context, iPicEmoticonInfo, sessionInfo, qQProgressDialog);
                return;
            }
            this.f205132a = i3;
            this.f205135d = qQAppInterface;
            this.f205133b = context;
            this.f205134c = iPicEmoticonInfo;
            this.f205136e = sessionInfo;
            this.f205137f = qQProgressDialog;
        }

        @Override // com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener
        public void onJsonComplete(EmoticonPackage emoticonPackage, int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, emoticonPackage, Integer.valueOf(i3), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOEmotionFragment", 2, "onJsonComplete:" + emoticonPackage.epId + " ,currEpid:" + this.f205134c.getEmoticon().epId);
            }
            int i16 = this.f205132a;
            if (i16 == 32) {
                if (i3 != 0 || Long.parseLong(emoticonPackage.epId) == Long.parseLong(this.f205134c.getEmoticon().epId)) {
                    z16 = false;
                }
                AIOEmotionFragment.this.ai(z16);
                return;
            }
            if (i3 == 0) {
                if (Long.parseLong(emoticonPackage.epId) != Long.parseLong(this.f205134c.getEmoticon().epId)) {
                    return;
                }
                this.f205135d.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int) (System.currentTimeMillis() / 1000)).commit();
                MarketFaceItemBuilder.e(this.f205132a, this.f205133b, this.f205135d, emoticonPackage, this.f205134c, this.f205136e, this.f205137f, true);
                Message obtainMessage = AIOEmotionFragment.this.H.obtainMessage(1000);
                obtainMessage.obj = emoticonPackage.name;
                AIOEmotionFragment.this.H.sendMessage(obtainMessage);
                return;
            }
            MarketFaceItemBuilder.e(1000 + i16, this.f205133b, this.f205135d, emoticonPackage, this.f205134c, this.f205136e, this.f205137f, true);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71702);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 56)) {
            redirector.redirect((short) 56);
        } else {
            Q0 = 0;
        }
    }

    public AIOEmotionFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.H = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.f205040j0 = null;
        this.f205041k0 = true;
        this.f205042l0 = false;
        this.f205043m0 = true;
        this.f205055y0 = null;
        this.f205056z0 = new ArrayList();
        this.A0 = new HashMap<>();
        this.B0 = 1.0f;
        this.C0 = -1;
        this.D0 = false;
        this.E0 = false;
        this.J0 = false;
        this.K0 = new ArrayList<>();
        this.N0 = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Bi(y yVar, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            qj(this.T, false);
            Hi(yVar);
        } else if (motionEvent.getAction() == 0) {
            qj(this.T, true);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ci(int i3, int i16, p pVar, int i17, String str, EmojiHotPicGetJumpInfoRspBody emojiHotPicGetJumpInfoRspBody) {
        if (i17 == 0 && str.isEmpty()) {
            com.tencent.mobileqq.ad.emoji.b bVar = new com.tencent.mobileqq.ad.emoji.b();
            bVar.i(emojiHotPicGetJumpInfoRspBody.getJumpIcon());
            bVar.m(emojiHotPicGetJumpInfoRspBody.getEmojiName());
            bVar.h(emojiHotPicGetJumpInfoRspBody.getJumpDesc());
            bVar.k(emojiHotPicGetJumpInfoRspBody.getJumpUrl());
            bVar.o(i3);
            bVar.n(i16);
            bVar.l(pVar.g());
            this.L0 = bVar;
            this.H.removeMessages(1003);
            this.H.obtainMessage(1003, bVar).sendToTarget();
            return;
        }
        QLog.e("AIOEmotionFragment", 2, "getHotPicJumpInfo result: " + i17 + ", errMsg: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Di(com.tencent.mobileqq.ad.emoji.b bVar, String str, String str2, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            qj(this.T, false);
            if (bVar.g() == 2) {
                BaseActivity baseActivity = getBaseActivity();
                if (!baseActivity.isFinishing()) {
                    baseActivity.setResult(1002);
                    baseActivity.finish();
                }
            } else {
                ((ICommercialEmoji) QRoute.api(ICommercialEmoji.class)).handleClick(str, str2);
                xh("0X800A7E7");
                com.tencent.mobileqq.emotionintegrate.h.b(this.T);
                Pi(str);
            }
        } else if (motionEvent.getAction() == 0) {
            qj(this.T, true);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Ei(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            qj(this.T, false);
            BaseActivity baseActivity = getBaseActivity();
            if (!baseActivity.isFinishing()) {
                baseActivity.setResult(1002);
                baseActivity.finish();
            }
        } else if (motionEvent.getAction() == 0) {
            qj(this.T, true);
        }
        return false;
    }

    private boolean Fi(p pVar) {
        Parcelable f16 = pVar.f();
        if (f16 == null || !(f16 instanceof IPicEmoticonInfo)) {
            return true;
        }
        int imageJobType = ((IPicEmoticonInfo) f16).getImageJobType();
        if (imageJobType != 2 && imageJobType != 4) {
            return true;
        }
        return false;
    }

    private boolean Gi(p pVar) {
        PicElement picElement;
        if (!(pVar instanceof y) || pVar.r()) {
            return false;
        }
        MessageRecord messageRecord = ((y) pVar).f205303a;
        if (!(messageRecord instanceof MessageForPic) || (picElement = ((MessageForPic) messageRecord).getPicElement()) == null) {
            return false;
        }
        if ((picElement.getPicSubType() == 11 && t.f205295a.a()) || pVar.x() || pVar.m()) {
            return true;
        }
        return !t.f205295a.c();
    }

    private void Hi(y yVar) {
        if (ej().booleanValue()) {
            ji(yVar);
        } else {
            ki();
        }
    }

    public static void Ii(BaseQQAppInterface baseQQAppInterface, Activity activity, String str, String str2, String str3, int i3, String str4) {
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        if (iMiniAppService.isMiniAppUrl(str4)) {
            QLog.w("AIOEmotionFragment", 1, "openUrl, start miniapp, url=" + str4);
            iMiniAppService.startMiniApp(activity, str4, 2202, null);
            return;
        }
        if (yi(str4)) {
            QLog.w("AIOEmotionFragment", 1, "openUrl, open webview, url=" + str4);
            Ji(activity, str, str2, str3, i3, str4);
            return;
        }
        ax c16 = bi.c(baseQQAppInterface, activity, str4);
        if (c16 != null) {
            QLog.w("AIOEmotionFragment", 1, "openUrl, jump by action, url=" + str4);
            c16.b();
            return;
        }
        QLog.w("AIOEmotionFragment", 1, "openUrl, unknown url, url=" + str4);
    }

    private static void Ji(Activity activity, String str, String str2, String str3, int i3, String str4) {
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str4);
        if (str3 == null) {
            str3 = activity.getIntent().getStringExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN);
            i3 = activity.getIntent().getIntExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, -1);
        }
        intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, i3);
        intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN, str3);
        intent.putExtra("selfuin", str2);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
        intent.putExtra("show_right_close_button", false);
        intent.putExtra("emojimall_detail_id", str);
        intent.putExtra("hide_more_button", false);
        intent.putExtra("isShowAd", false);
        activity.startActivity(intent);
    }

    private void Ki() {
        boolean z16;
        String str;
        URLDrawable uRLDrawable;
        if (this.f205039i0 == null) {
            CommonAudioPlayer commonAudioPlayer = new CommonAudioPlayer(this.D, this);
            this.f205039i0 = commonAudioPlayer;
            commonAudioPlayer.M();
            this.f205039i0.R(this);
            QQAppInterface sh5 = sh();
            if (sh5 != null) {
                ((IAudioDeviceService) sh5.getRuntimeService(IAudioDeviceService.class)).registerAudioDeviceListener(this.f205039i0);
            }
        }
        this.f205039i0.stop();
        IPicEmoticonInfo iPicEmoticonInfo = this.f205053w0;
        if (iPicEmoticonInfo != null) {
            String replace = MarketFaceConstants.emoticonSoundPath.replace("[epId]", iPicEmoticonInfo.getEmoticon().epId).replace("[eId]", this.f205053w0.getEmoticon().eId);
            boolean z17 = false;
            this.f205042l0 = false;
            QQAppInterface sh6 = sh();
            if (sh6 != null) {
                this.f205041k0 = com.tencent.mobileqq.qqaudio.audioplayer.c.b(sh6);
                MediaPlayerManager q16 = MediaPlayerManager.q(sh6);
                if (q16.t()) {
                    q16.D(true);
                }
            }
            boolean f16 = com.tencent.mobileqq.qqaudio.audioplayer.c.f(BaseApplication.getContext());
            boolean c16 = com.tencent.mobileqq.qqaudio.audioplayer.c.c(BaseApplication.getContext());
            this.f205039i0.C(1);
            if (this.f205039i0.u(replace)) {
                if (c16 && f16) {
                    c16 = com.tencent.mobileqq.qqaudio.audioplayer.c.d(BaseApplication.getContext());
                }
                com.tencent.mobileqq.activity.aio.audiopanel.b.a(getBaseActivity(), this.f205041k0, f16, c16);
                if (!f16 && !c16) {
                    z17 = true;
                }
                xj(z17, this.f205041k0);
                BaseActivity baseActivity = getBaseActivity();
                if (baseActivity != null) {
                    baseActivity.getWindow().addFlags(128);
                }
                WeakReference<URLDrawable> weakReference = this.f205040j0;
                if (weakReference != null && (uRLDrawable = weakReference.get()) != null) {
                    EmotionUtils.startSoundDrawablePlay(uRLDrawable);
                }
                this.f205038h0.setProgress(0.0f);
                this.f205037g0.setPlayState(true);
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                EmoticonOperateReport.reportNewSoundEvent(sh6, "0X800A935", -1, this.f205053w0.getEmoticon().epId);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (z16) {
                str = "0";
            } else {
                str = "1";
            }
            hashMap.put("playResult", str);
            hashMap.put(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, "2");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), StatisticCollector.EMOTION_SOUND_PLAY, z16, 0L, 0L, hashMap, null);
        }
    }

    private void Li() {
        getBaseActivity().overridePendingTransition(0, R.anim.f154469ad);
    }

    private void Mi() {
        com.tencent.mobileqq.emotionintegrate.report.b bVar = com.tencent.mobileqq.emotionintegrate.report.b.f205282a;
        HashMap<String, Object> a16 = bVar.a("em_bas_edit_emoticons");
        a16.put("emoticons", this.K.getText());
        bVar.b(a16);
    }

    private void Ni() {
        CharSequence text = this.K.getText();
        if (!TextUtils.isEmpty(text)) {
            com.tencent.mobileqq.emotionintegrate.report.b bVar = com.tencent.mobileqq.emotionintegrate.report.b.f205282a;
            HashMap<String, Object> a16 = bVar.a("em_bas_edit_emoticons");
            a16.put("emoticons", text);
            bVar.c(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph(QQAppInterface qQAppInterface) {
        ((IEmoticonManagerService) qQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(this.f205052v0.epId, new c(qQAppInterface));
        EmoticonOperateReport.reportFavAddEmotionEvent(qQAppInterface, 2, null, this.f205052v0.eId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pi(String str) {
        String charSequence = this.Q.getText().toString();
        String charSequence2 = this.M.getText().toString();
        com.tencent.mobileqq.emotionintegrate.report.b bVar = com.tencent.mobileqq.emotionintegrate.report.b.f205282a;
        HashMap<String, Object> a16 = bVar.a("em_bas_source_channel");
        a16.put("relation_content", charSequence + "," + charSequence2);
        a16.put("jump_link", str);
        bVar.b(a16);
        com.tencent.mobileqq.emotionintegrate.report.c.f205285a.e(charSequence2 + charSequence + str);
    }

    private void Qh(QQAppInterface qQAppInterface, MessageForPic messageForPic) {
        Context context = this.D;
        if (context != null) {
            com.tencent.mobileqq.activity.aio.photo.c.b(context, messageForPic.path, qQAppInterface, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height), null);
            EmoticonOperateReport.reportFavAddEmotionEvent(qQAppInterface, 2, messageForPic.md5, null);
            new x61.e().d(qQAppInterface, null, messageForPic);
        }
    }

    private void Qi(String str) {
        String charSequence = this.Q.getText().toString();
        String charSequence2 = this.M.getText().toString();
        com.tencent.mobileqq.emotionintegrate.report.b bVar = com.tencent.mobileqq.emotionintegrate.report.b.f205282a;
        HashMap<String, Object> a16 = bVar.a("em_bas_source_channel");
        a16.put("relation_content", charSequence + "," + charSequence2);
        a16.put("jump_link", str);
        bVar.c(a16);
        com.tencent.mobileqq.emotionintegrate.report.c.f205285a.f(charSequence2 + charSequence + str);
    }

    private static void Rh() {
        QQAppInterface qQAppInterface;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) runtime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            MediaPlayerManager q16 = MediaPlayerManager.q(qQAppInterface);
            if ((q16.s() instanceof MessageForMarketFace) && q16.t()) {
                q16.D(true);
            }
        }
    }

    private void Ri(y yVar) {
        if (yVar == null) {
            QLog.e("AIOEmotionFragment", 1, "[requestAIEmtionDetail] fail: item is null.");
            return;
        }
        PicElement B = yVar.B();
        if (B == null) {
            QLog.e("AIOEmotionFragment", 1, "[requestAIEmtionDetail] fail: picElement is null.");
            return;
        }
        int i3 = B.templateID;
        final String g16 = yVar.g();
        int Vh = Vh(B.getPicSubType());
        QLog.i("AIOEmotionFragment", 1, "[requestAIEmtionDetail] templateID:" + i3 + "\uff0csrcType:" + Vh);
        com.tencent.qqnt.msg.f.e().getHotPicJumpInfo(new EmojiHotPicGetJumpInfoReqBody(i3, g16, Vh), new IEmojiHotPicGetJumpInfoResultCallback() { // from class: com.tencent.mobileqq.emotionintegrate.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IEmojiHotPicGetJumpInfoResultCallback
            public final void onResult(int i16, String str, EmojiHotPicGetJumpInfoRspBody emojiHotPicGetJumpInfoRspBody) {
                AIOEmotionFragment.this.zi(g16, i16, str, emojiHotPicGetJumpInfoRspBody);
            }
        });
    }

    private boolean Sh(com.tencent.mobileqq.ad.emoji.b bVar) {
        String b16 = bVar.b();
        String e16 = bVar.e();
        String a16 = bVar.a();
        String d16 = bVar.d();
        if (!TextUtils.isEmpty(b16) && !TextUtils.isEmpty(e16) && !TextUtils.isEmpty(a16) && !TextUtils.isEmpty(d16)) {
            return true;
        }
        return false;
    }

    private void Si(MessageRecord messageRecord) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getBaseActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_EMOTICON, QQPermissionConstants.Business.SCENE.EMOTICON_SAVE));
        if (qQPermission == null) {
            QLog.i("AIOEmotionFragment", 1, "save emoticon qqPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            Ui(messageRecord);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a(messageRecord));
        }
    }

    private void Th(Intent intent, MessageRecord messageRecord) {
        if (ti()) {
            QLog.i("AIOEmotionFragment", 1, "isFromGuildPreview set extra");
            intent.putExtra("extra.MSG_ID", messageRecord.uniseq);
            intent.putExtra(IGuildForwardUtilsApi.EXTRA_GUILD_CHAT_TYPE, 4);
            intent.putExtra(IGuildForwardUtilsApi.EXTRA_GUILD_ID, ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(messageRecord) + "");
            intent.putExtra(IGuildForwardUtilsApi.EXTRA_GUILD_CHANNEL_ID, messageRecord.frienduin);
        }
    }

    private void Ti() {
        this.N.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean Uh() {
        int i3;
        boolean z16 = false;
        if (!(P0 instanceof y)) {
            QLog.d("AIOEmotionFragment", 1, "considerFillPreviewDataFromDataCenter mCurData is not MsgEmoticonPreviewData");
            return false;
        }
        List<?> emoticonDataStore = ((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).getEmoticonDataStore();
        if (emoticonDataStore != null && !emoticonDataStore.isEmpty()) {
            y yVar = (y) P0;
            boolean booleanValue = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("emoticon_preview_add_click_item_120842419", Boolean.TRUE).booleanValue();
            QLog.i("AIOEmotionFragment", 1, "considerFillPreviewDataFromDataCenter() ----- switchOn:" + booleanValue);
            if (booleanValue) {
                aa.f(emoticonDataStore, yVar.f205303a);
            }
            this.J.setData(emoticonDataStore);
            this.J.notifyDataSetChanged();
            p pVar = P0;
            if (pVar != null) {
                i3 = this.J.f(pVar);
            } else {
                i3 = 0;
            }
            this.I.setSelection(i3);
            Object[] objArr = new Object[2];
            objArr[0] = "considerFillPreviewDataFromDataCenter size:" + emoticonDataStore.size() + ", pos:" + i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(", mCurData is null:");
            if (P0 == null) {
                z16 = true;
            }
            sb5.append(z16);
            objArr[1] = sb5.toString();
            QLog.d("AIOEmotionFragment", 1, objArr);
            return true;
        }
        QLog.d("AIOEmotionFragment", 1, "considerFillPreviewDataFromDataCenter emoticonPreviewDataList empty return false");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui(MessageRecord messageRecord) {
        xh("0X8009983");
        File Yh = Yh(messageRecord);
        if (Yh != null) {
            com.tencent.mobileqq.activity.aio.photo.c.n(getBaseActivity(), Yh, Utils.Crc64String(Yh.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
        }
    }

    private int Vh(int i3) {
        if (i3 == 1) {
            return 7;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 != 3) {
            if (i3 == 7) {
                return 1;
            }
            if (i3 != 10) {
                if (i3 == 13) {
                    return 2;
                }
                if (i3 != 14) {
                    return 0;
                }
                return 8;
            }
            return 5;
        }
        return 4;
    }

    private void Vi(MessageForPic messageForPic) {
        final String str;
        PicElement picElement = messageForPic.getPicElement();
        if (picElement != null) {
            str = aj.a(picElement);
        } else {
            str = messageForPic.path;
        }
        if (str != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.g
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.mobileqq.wxshare.d.g(str);
                }
            }, 16, null, true);
        } else {
            QLog.e("AIOEmotionFragment", 1, "sendEmoPicToWechat picPath is null.");
        }
    }

    private EmotionDataSource Wh() {
        if (Q0 == 0) {
            return new aa(getBaseActivity().getIntent(), (y) P0, this.f205050t0, this.f205051u0);
        }
        Object createGuildEmoPreviewDataSource = ((IGuildEmoPreviewDataSourceApi) QRoute.api(IGuildEmoPreviewDataSourceApi.class)).createGuildEmoPreviewDataSource(getBaseActivity().getIntent(), P0, this.f205050t0);
        if (createGuildEmoPreviewDataSource instanceof EmotionDataSource) {
            return (EmotionDataSource) createGuildEmoPreviewDataSource;
        }
        return new aa(getBaseActivity().getIntent(), (y) P0, this.f205050t0, this.f205051u0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wi() {
        IPicEmoticonInfo iPicEmoticonInfo = this.f205053w0;
        if (iPicEmoticonInfo == null) {
            QLog.e("AIOEmotionFragment", 1, "ACTION_SEND_TO_CHANNEL mPicEmotionInfo is null");
            return;
        }
        O0 = iPicEmoticonInfo;
        Intent intent = new Intent();
        intent.putExtra("forward_type", 9);
        intent.putExtra(AppConstants.Key.FORWARD_EMOTION_FROM_PREVIEW, true);
        intent.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
        intent.putExtra("forward_source_sub_business_type", "biz_src_jc_gif");
        com.tencent.mobileqq.richmediabrowser.utils.e.c(getActivity(), intent);
    }

    private static Intent Xh(Context context, MessageRecord messageRecord, SessionInfo sessionInfo, AIOContact aIOContact, Rect rect, boolean z16, boolean z17, Bundle bundle) {
        int i3;
        String str;
        Q0 = 0;
        if (!(context instanceof PublicFragmentActivity) && (context instanceof BaseActivity) && com.tencent.imcore.message.report.a.d() && ((BaseActivity) context).getChatFragment() != null) {
            i3 = 1;
        } else {
            i3 = 5;
        }
        Rh();
        if (rect != null) {
            rect.top -= ImmersiveUtils.getStatusBarHeight(context);
            rect.bottom -= ImmersiveUtils.getStatusBarHeight(context);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("enterEmotionPreview, type:");
            if (MessageForMarketFace.class.isInstance(messageRecord)) {
                str = "Emotion";
            } else {
                str = "GIF";
            }
            sb5.append(str);
            QLog.i("AIOEmotionFragment", 2, sb5.toString());
        }
        P0 = new y(messageRecord);
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.SESSION_INFO, sessionInfo);
        intent.putExtra("nt_aio_contact_info", aIOContact);
        intent.putExtra("from_chat_history", false);
        intent.putExtra("hide_emo_position", z16);
        intent.putExtra("need_reload_data", z17);
        intent.putExtra("report_enter_type", i3);
        intent.putExtra("public_fragment_window_feature", 1);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (rect != null) {
            intent.putExtra("KEY_THUMBNAL_BOUND", rect);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xi(Bundle bundle) {
        IPicEmoticonInfo iPicEmoticonInfo = this.f205053w0;
        if (iPicEmoticonInfo == null) {
            QLog.e("AIOEmotionFragment", 2, "ACTION_SEND_TO_SPECIFIED_FRIEND mPicEmotionInfo is null");
            return;
        }
        O0 = iPicEmoticonInfo;
        Intent intent = new Intent();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("forward_type", 9);
        bundle2.putBoolean(AppConstants.Key.FORWARD_EMOTION_FROM_PREVIEW, true);
        intent.putExtras(bundle2);
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(super.getBaseActivity(), intent, (Class<?>) ForwardRecentTranslucentActivity.class, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gif");
    }

    private File Yh(MessageRecord messageRecord) {
        MessageForPic messageForPic = (MessageForPic) messageRecord;
        if (!TextUtils.isEmpty(messageForPic.path)) {
            return new File(messageForPic.path);
        }
        return AbsDownloader.getFile(URLDrawableHelper.getURL(messageForPic, 1).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yi(QQAppInterface qQAppInterface) {
        boolean z16;
        IPicEmoticonInfo iPicEmoticonInfo;
        if (this.f205052v0 != null && (iPicEmoticonInfo = this.f205053w0) != null) {
            O0 = iPicEmoticonInfo;
            ((IEmoticonManagerService) qQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(this.f205052v0.epId, new b(qQAppInterface));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("error mEmoticon, ");
        if (this.f205052v0 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("AIOEmotionFragment", 1, sb5.toString());
    }

    private boolean Zh() {
        p pVar = P0;
        if (pVar.m() && !pVar.q() && pi() && (pVar instanceof y)) {
            return true;
        }
        return false;
    }

    private void Zi(int i3) {
        TextView textView = this.K;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(boolean z16) {
        if (z16) {
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 9);
            bundle.putBoolean(AppConstants.Key.FORWARD_EMOTION_FROM_PREVIEW, true);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            this.f205054x0.setIntentForStartForwardRecentActivity(intent);
        }
        this.f205054x0.show();
    }

    private void aj(int i3) {
        View view = this.T;
        if (view == null) {
            return;
        }
        if (view.getVisibility() != 0 && i3 == 0) {
            Qi("");
        }
        this.T.setVisibility(i3);
    }

    private void bi() {
        this.f205038h0.setProgress(0.0f);
        this.f205037g0.setPlayState(false);
        xj(false, false);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            baseActivity.getWindow().clearFlags(128);
        }
    }

    private void bj(int i3, String str) {
        View view = this.T;
        if (view == null) {
            return;
        }
        if (view.getVisibility() != 0 && i3 == 0) {
            Qi(str);
        }
        this.T.setVisibility(i3);
    }

    public static void ci(Context context, MessageRecord messageRecord, SessionInfo sessionInfo, AIOContact aIOContact, Rect rect, boolean z16, boolean z17, Bundle bundle) {
        Intent Xh = Xh(context, messageRecord, sessionInfo, aIOContact, rect, z16, z17, bundle);
        if ((context instanceof MultiForwardActivity) && messageRecord.isMultiMsg) {
            MultiForwardActivity multiForwardActivity = (MultiForwardActivity) context;
            if (multiForwardActivity.getIntent() != null) {
                Xh.putExtra(PeakConstants.KEY_MULTI_FORWARD_SEQ, multiForwardActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", 0L));
                Xh.putExtra(PeakConstants.KEY_IS_MULTI_FROWARD_MSG, true);
            }
        }
        if (context instanceof Activity) {
            PublicFragmentActivity.b.e(context, Xh, PublicTransFragmentActivity.class, AIOEmotionFragment.class, 30007);
            ((Activity) context).overridePendingTransition(R.anim.f154468ac, 0);
        } else {
            PublicFragmentActivity.b.c(Xh, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(QQAppInterface qQAppInterface, int i3) {
        if (this.f205055y0 == null) {
            this.f205055y0 = new l();
        }
        if (this.f205053w0 != null && this.f205052v0 != null) {
            this.f205055y0.a(i3, qQAppInterface, getBaseActivity(), this.f205053w0, this.f205050t0, null);
            IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) qQAppInterface.getRuntimeService(IEmojiManagerService.class);
            iEmojiManagerService.getEmojiListenerManager().addEmotionJsonDownloadListener(this.f205055y0);
            iEmojiManagerService.startDownloadEmosmJson(this.f205052v0.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
            return;
        }
        QLog.d("AIOEmotionFragment", 1, "error in json downloading");
        ai(false);
    }

    public static void di(Context context, EmoticonInfo emoticonInfo, Rect rect) {
        Intent intent = new Intent();
        if (rect != null) {
            rect.top -= ImmersiveUtils.getStatusBarHeight(context);
            rect.bottom -= ImmersiveUtils.getStatusBarHeight(context);
            intent.putExtra("KEY_THUMBNAL_BOUND", rect);
        }
        Rh();
        if (QLog.isColorLevel()) {
            QLog.i("AIOEmotionFragment", 2, "enterEmotionPreview, type: FAV");
        }
        Q0 = 1;
        P0 = new u(emoticonInfo);
        intent.putExtra("from_chat_history", false);
        intent.putExtra("public_fragment_window_feature", 1);
        if (context instanceof Activity) {
            PublicFragmentActivity.b.a(context, intent, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
            ((Activity) context).overridePendingTransition(R.anim.f154468ac, 0);
        } else {
            PublicFragmentActivity.b.c(intent, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
        }
    }

    private void dj() {
        if (this.f205039i0 != null) {
            bi();
            this.f205039i0.stop();
        }
    }

    public static void ei(Context context, MessageRecord messageRecord, SessionInfo sessionInfo, Rect rect) {
        String str = sessionInfo.f179563i;
        if (str == null) {
            str = "";
        }
        ci(context, messageRecord, sessionInfo, new AIOContact(4, sessionInfo.f179557e, sessionInfo.f179559f, str), rect, true, true, null);
        Q0 = 2;
        Object createGuildEmoPreviewData = ((IGuildEmoPreviewDataSourceApi) QRoute.api(IGuildEmoPreviewDataSourceApi.class)).createGuildEmoPreviewData(messageRecord);
        if (createGuildEmoPreviewData instanceof y) {
            QLog.i("AIOEmotionFragment", 1, "create guild pic data, GuildID=" + sessionInfo.f179559f + " ChannelId=" + sessionInfo.f179557e);
            P0 = (y) createGuildEmoPreviewData;
        }
    }

    private Boolean ej() {
        return Boolean.valueOf(com.tencent.mobileqq.aio.helper.h.f189065a.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi() {
        if (!(((p) this.I.getSelectedItem()) instanceof y)) {
            return;
        }
        AIOContact aIOContact = this.f205051u0;
        if (aIOContact != null) {
            com.tencent.qqnt.chathistory.api.a aVar = new com.tencent.qqnt.chathistory.api.a(aIOContact.e(), this.f205051u0.j(), this.f205051u0.g(), 0);
            Bundle bundle = new Bundle();
            String stringExtra = getBaseActivity().getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = getBaseActivity().getClass().getName();
            }
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", stringExtra);
            ((IChatHistoryApi) QRoute.api(IChatHistoryApi.class)).jumpHistoryTab(getBaseActivity(), aVar, 2, bundle);
            return;
        }
        QLog.e("AIOEmotionFragment", 1, "[galleryEmotionList] error, mNTAIOContact is null!");
    }

    private boolean fj(IPicEmoticonInfo iPicEmoticonInfo) {
        if (iPicEmoticonInfo == null || !iPicEmoticonInfo.isNewSoundType() || iPicEmoticonInfo.getWaveformArray() == null) {
            return false;
        }
        this.f205034d0.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f205038h0.getLayoutParams();
        QLog.d("AIOEmotionFragment", 2, "tryUpdateNewAudioEmoAudioInfo");
        this.f205038h0.setProgress(0.0f);
        this.f205038h0.setMaxTopBottomPadding(4);
        layoutParams.width = BaseAIOUtils.f(39.0f, this.D.getResources());
        this.f205038h0.setAudioData(iPicEmoticonInfo.getWaveformArray(), BaseAIOUtils.f(39.0f, this.D.getResources()), iPicEmoticonInfo.getVoiceLength());
        kj(iPicEmoticonInfo.getWaveBackgroundColor(), iPicEmoticonInfo.getWaveForegroundColor());
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void gj(final y yVar) {
        Zi(4);
        this.T.setVisibility(0);
        this.U.setImageDrawable(null);
        this.U.setVisibility(8);
        this.V.setVisibility(8);
        this.M.setVisibility(0);
        this.M.setText(R.string.yqe);
        this.P.setVisibility(8);
        this.S.setVisibility(0);
        if (ej().booleanValue()) {
            this.S.setText(R.string.yqf);
            Ri(yVar);
        } else {
            this.S.setText(R.string.f170215yq0);
        }
        this.T.setClickable(true);
        this.T.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.emotionintegrate.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Bi;
                Bi = AIOEmotionFragment.this.Bi(yVar, view, motionEvent);
                return Bi;
            }
        });
    }

    private String hi(a.C11384a c11384a, boolean z16) {
        com.tencent.mobileqq.config.business.w a16 = com.tencent.mobileqq.config.business.w.INSTANCE.a();
        Emoticon emoticon = this.f205052v0;
        w.b b16 = a16.b(emoticon.epId, emoticon.eId);
        if (z16 && c11384a != null) {
            return c11384a.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
        }
        if (b16 != null && b16.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String() != null) {
            return b16.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00db, code lost:
    
        if (((com.tencent.mobileqq.emosm.api.IEmoticonManagerService) r6.getRuntimeService(com.tencent.mobileqq.emosm.api.IEmoticonManagerService.class)).isEpidInTabcache(r9.f205052v0.epId) != false) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void hj(EmoticonInfo emoticonInfo) {
        boolean z16;
        String str;
        Emoticon emoticon = this.f205052v0;
        boolean z17 = true;
        if (emoticon != null && emoticon.jobType != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        v03.a aVar = v03.a.f440717a;
        boolean b16 = aVar.b(emoticon.epId);
        a.C11384a a16 = aVar.a(this.f205052v0.epId);
        this.P.setVisibility(8);
        if (z16 && emoticonInfo != 0) {
            xh("0X800997E");
            if ((emoticonInfo instanceof IPicEmoticonInfo) && ((IPicEmoticonInfo) emoticonInfo).isNewSoundType()) {
                this.V.setVisibility(0);
            } else {
                this.V.setVisibility(8);
            }
            String hi5 = hi(a16, b16);
            this.T.setClickable(true);
            this.T.setOnTouchListener(new k(hi5));
            this.U.setImageDrawable(emoticonInfo.getDrawable(getBaseActivity(), this.D.getResources().getDisplayMetrics().density));
            this.U.setVisibility(0);
            EmoticonPackage c16 = r.c(this.f205052v0.epId);
            if (b16 && a16 != null) {
                str = a16.getNameText();
            } else if (c16 != null) {
                str = c16.name;
            } else {
                str = null;
            }
            QQAppInterface sh5 = sh();
            if (sh5 != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.length() > 11) {
                        this.M.setText(str.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    } else {
                        this.M.setText(str);
                    }
                } else {
                    cj(sh5, 4);
                }
            }
            z17 = false;
            if (b16 && a16 != null) {
                this.S.setText(a16.getAddText());
                mj(this.S);
            } else if (z17) {
                this.S.setText(HardCodeUtil.qqStr(R.string.j8r));
                mj(this.S);
            } else {
                this.S.setText(HardCodeUtil.qqStr(R.string.j8q));
                mj(this.S);
            }
            this.S.setTextSize(16.0f);
            bj(0, hi5);
            return;
        }
        aj(4);
    }

    private void ij() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.M.getLayoutParams();
        if (this.U.getVisibility() != 8) {
            marginLayoutParams.leftMargin = 0;
            this.M.setLayoutParams(marginLayoutParams);
            return;
        }
        int dpToPx = ViewUtils.dpToPx(12.0f);
        if (FontSettingManager.isFontSizeLarge()) {
            dpToPx = (int) FontSettingManager.revertSize2Normal(this.D, dpToPx);
        }
        marginLayoutParams.leftMargin = dpToPx;
        this.M.setLayoutParams(marginLayoutParams);
    }

    private void ji(y yVar) {
        PicElement B;
        String makeSamePage = gi().getMakeSamePage();
        if (yVar != null && (B = yVar.B()) != null) {
            makeSamePage = makeSamePage + "&template_id=" + B.templateID;
        }
        String str = makeSamePage;
        QLog.i("AIOEmotionFragment", 1, "[goToMakeSame] makeSamePage = " + str);
        Ii(sh(), getBaseActivity(), "", sh().getAccount(), null, -1, str);
    }

    private void jj(TextView textView) {
        if (textView == null) {
            QLog.e("AIOEmotionFragment", 1, "updateEmotionTv: albumNameTextView == null");
        } else {
            textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_primary));
        }
    }

    private void ki() {
        BaseActivity baseActivity = getBaseActivity();
        if (!baseActivity.isFinishing()) {
            baseActivity.setResult(1003);
            baseActivity.finish();
        }
    }

    private void kj(int i3, int i16) {
        this.f205035e0.setDrawColor(i3);
        this.f205036f0.setBackgroundDrawable(new com.tencent.mobileqq.structmsg.f(i3, 1, 1, BaseAIOUtils.f(22.0f, this.D.getResources())));
        this.f205037g0.setThemeColor(i16);
        this.f205038h0.setProgressColor(i16);
        this.f205038h0.postInvalidate();
    }

    private void lj(TextView textView) {
        String str;
        if (si()) {
            str = "#FFFFFF";
        } else {
            str = "#03081A";
        }
        if (textView != null) {
            textView.setTextColor(Color.parseColor(str));
        }
    }

    private void mj(TextView textView) {
        if (textView == null) {
            QLog.e("AIOEmotionFragment", 1, "updateCollectTv: collectTextView == null");
        } else {
            textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_secondary));
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ((IAIOEmoticonUtils) QRoute.api(IAIOEmoticonUtils.class)).getAlbumRightArrow(textView.getResources()), (Drawable) null);
        }
    }

    @Nullable
    private AiPanelInfo ni() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("105602", "");
        if (loadAsString.isEmpty()) {
            return new AiPanelInfo();
        }
        try {
            return (AiPanelInfo) new Gson().fromJson(loadAsString, AiPanelInfo.class);
        } catch (Exception unused) {
            return new AiPanelInfo();
        }
    }

    private void nj(final p pVar) {
        int i3;
        PicElement picElement;
        String h16 = pVar.h();
        String g16 = pVar.g();
        if (TextUtils.isDigitsOnly(h16) && !"0".equals(h16) && !TextUtils.isEmpty(g16)) {
            final int parseInt = Integer.parseInt(h16);
            com.tencent.mobileqq.ad.emoji.b bVar = this.L0;
            if (bVar != null && bVar.f() == parseInt) {
                QLog.i("AIOEmotionFragment", 1, "updateCommercialEmoticonArea with cache, pkgId:" + parseInt);
                this.H.removeMessages(1003);
                this.H.obtainMessage(1003, this.L0).sendToTarget();
                return;
            }
            QLog.d("AIOEmotionFragment", 1, "updateCommercialEmoticonArea emotionPkgId:" + h16 + ", emotionMD5:" + g16);
            final int i16 = 0;
            if (pVar instanceof y) {
                MessageRecord messageRecord = ((y) pVar).f205303a;
                if (!(messageRecord instanceof MessageForPic) || (picElement = ((MessageForPic) messageRecord).getPicElement()) == null) {
                    return;
                }
                i3 = Vh(picElement.getPicSubType());
                Integer num = picElement.picSubSubType;
                if (num != null) {
                    i16 = num.intValue();
                }
            } else if (pVar instanceof u) {
                i3 = 7;
            } else {
                QLog.d("AIOEmotionFragment", 1, "emoticonPreviewData not msg or fav type");
                return;
            }
            com.tencent.qqnt.msg.f.e().getHotPicJumpInfo(new EmojiHotPicGetJumpInfoReqBody(parseInt, pVar.g(), i3), new IEmojiHotPicGetJumpInfoResultCallback() { // from class: com.tencent.mobileqq.emotionintegrate.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IEmojiHotPicGetJumpInfoResultCallback
                public final void onResult(int i17, String str, EmojiHotPicGetJumpInfoRspBody emojiHotPicGetJumpInfoRspBody) {
                    AIOEmotionFragment.this.Ci(i16, parseInt, pVar, i17, str, emojiHotPicGetJumpInfoRspBody);
                }
            });
        }
    }

    private boolean oi() {
        CommonAudioPlayer commonAudioPlayer = this.f205039i0;
        if (commonAudioPlayer == null) {
            return false;
        }
        return commonAudioPlayer.r();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void oj(final com.tencent.mobileqq.ad.emoji.b bVar) {
        if (bVar == null) {
            return;
        }
        String b16 = bVar.b();
        String e16 = bVar.e();
        String a16 = bVar.a();
        final String d16 = bVar.d();
        final String c16 = bVar.c();
        if (!Sh(bVar)) {
            yj(bVar);
            return;
        }
        if (bVar.g() == 2) {
            this.M.setText(R.string.ypx);
            SpannableString spannableString = new SpannableString(e16);
            spannableString.setSpan(new h(d16, c16), 0, e16.length(), 33);
            this.N.setText(spannableString);
            this.N.setMovementMethod(LinkMovementMethod.getInstance());
            this.N.setVisibility(0);
            this.S.setText(R.string.ypz);
        } else {
            this.M.setText(e16);
            this.S.setText(a16);
        }
        this.M.setVisibility(0);
        this.S.setVisibility(0);
        bj(0, d16);
        this.T.setClickable(true);
        this.T.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.emotionintegrate.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Di;
                Di = AIOEmotionFragment.this.Di(bVar, d16, c16, view, motionEvent);
                return Di;
            }
        });
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mGifRoundCorner = this.H0;
            this.U.setImageDrawable(URLDrawable.getDrawable(b16, obtain));
            this.U.setVisibility(0);
            ij();
        } catch (Throwable th5) {
            QLog.d("AIOEmotionFragment", 1, "CommercialEmoticon set icon error:", th5);
        }
    }

    private boolean pi() {
        int e16;
        AIOContact aIOContact = this.f205051u0;
        if (aIOContact == null || (e16 = aIOContact.e()) == 1 || e16 == 2) {
            return true;
        }
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void pj() {
        Zi(4);
        this.T.setVisibility(0);
        this.U.setImageDrawable(null);
        this.U.setVisibility(8);
        this.V.setVisibility(8);
        this.M.setVisibility(0);
        this.M.setText(R.string.f224386is);
        this.P.setVisibility(8);
        this.S.setVisibility(0);
        this.S.setText(R.string.ypz);
        this.T.setClickable(true);
        this.T.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.emotionintegrate.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Ei;
                Ei = AIOEmotionFragment.this.Ei(view, motionEvent);
                return Ei;
            }
        });
    }

    private boolean qi(p pVar) {
        PicElement picElement;
        if (wi(pVar) || !(pVar instanceof y)) {
            return false;
        }
        MessageRecord messageRecord = ((y) pVar).f205303a;
        if (!(messageRecord instanceof MessageForPic) || (picElement = ((MessageForPic) messageRecord).getPicElement()) == null) {
            return false;
        }
        int picSubType = picElement.getPicSubType();
        QLog.i("AIOEmotionFragment", 1, "isCommercialEmoticon picSubType:" + picSubType);
        if (picSubType != 13 && picSubType != 7) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(View view, boolean z16) {
        Drawable albumBg;
        if (view == null) {
            QLog.e("AIOEmotionFragment", 1, "updateDetailArea: detailArea == null");
            return;
        }
        if (z16) {
            albumBg = ((IAIOEmoticonUtils) QRoute.api(IAIOEmoticonUtils.class)).getAlbumPressBg(view.getResources());
        } else {
            albumBg = ((IAIOEmoticonUtils) QRoute.api(IAIOEmoticonUtils.class)).getAlbumBg(view.getResources());
        }
        view.setBackground(albumBg);
    }

    private boolean ri(p pVar) {
        PicElement picElement;
        if (wi(pVar)) {
            return false;
        }
        if (pVar instanceof u) {
            return true;
        }
        if (!(pVar instanceof y)) {
            return false;
        }
        MessageRecord messageRecord = ((y) pVar).f205303a;
        if (!(messageRecord instanceof MessageForPic) || (picElement = ((MessageForPic) messageRecord).getPicElement()) == null) {
            return false;
        }
        int picSubType = picElement.getPicSubType();
        QLog.i("AIOEmotionFragment", 1, "isCommercialEmoticonFromFav picSubType:" + picSubType);
        if (picSubType != 1) {
            return false;
        }
        return true;
    }

    private void rj(boolean z16) {
        int[] iArr;
        ImageView imageView = this.U;
        if (imageView == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        if (z16) {
            iArr = new int[]{ViewUtils.dpToPx(42.0f), ViewUtils.dpToPx(42.0f), ViewUtils.dpToPx(35.0f), ViewUtils.dpToPx(10.0f)};
        } else {
            iArr = new int[]{ViewUtils.dpToPx(50.0f), ViewUtils.dpToPx(50.0f), ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(6.0f)};
        }
        if (FontSettingManager.isFontSizeLarge()) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = (int) FontSettingManager.revertSize2Normal(this.D, iArr[i3]);
            }
        }
        marginLayoutParams.width = iArr[0];
        marginLayoutParams.height = iArr[1];
        marginLayoutParams.leftMargin = iArr[2];
        marginLayoutParams.rightMargin = iArr[3];
        this.U.setLayoutParams(marginLayoutParams);
        ij();
    }

    private boolean si() {
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        if (QLog.isColorLevel()) {
            QLog.d("AIOEmotionFragment", 2, "isDarkMode: " + isNowThemeIsNight);
        }
        return isNowThemeIsNight;
    }

    private boolean sj() {
        Drawable drawable;
        int intrinsicHeight;
        float G = this.I.G();
        if (this.A0.containsKey(this.J.h(this.C0)) && G != this.A0.get(this.J.h(this.C0)).floatValue()) {
            return true;
        }
        View selectedView = this.I.getSelectedView();
        if (!(selectedView instanceof ImageView) || (drawable = ((ImageView) selectedView).getDrawable()) == null) {
            return false;
        }
        if (drawable instanceof com.tencent.mobileqq.magicface.drawable.c) {
            intrinsicHeight = BaseAIOUtils.f(100.0f, this.D.getResources());
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        this.B0 = G;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f205033c0.getLayoutParams();
        layoutParams.topMargin = ((int) ((intrinsicHeight * G) / 2.0f)) + BaseAIOUtils.f(5.0f, this.D.getResources());
        this.f205033c0.setLayoutParams(layoutParams);
        if (QLog.isColorLevel()) {
            QLog.d("AIOEmotionFragment", 2, "updateEmotionNameLayout scale:", Float.valueOf(G), " topMargin:", Integer.valueOf(layoutParams.topMargin));
        }
        if (intrinsicHeight > 0) {
            return true;
        }
        return false;
    }

    private boolean ti() {
        if (Q0 == 2) {
            return true;
        }
        return false;
    }

    private void tj(int i3, p pVar) {
        String str;
        float f16;
        CustomEmotionData a16 = pVar.a();
        if (a16 == null) {
            Zi(4);
            return;
        }
        if (!TextUtils.isEmpty(a16.modifyWord)) {
            str = a16.modifyWord;
        } else {
            str = a16.ocrWord;
        }
        if (TextUtils.isEmpty(str)) {
            this.K.setTextColor(this.D.getResources().getColor(R.color.qui_common_text_secondary));
            this.K.setText(this.D.getResources().getString(R.string.inl));
        } else {
            wj(this.K);
            this.K.setText(str);
        }
        float G = this.I.G();
        if (QLog.isColorLevel()) {
            QLog.d("AIOEmotionFragment", 2, "updateEmotionOcr scale=" + G + "originalScale=" + G);
        }
        if (this.A0.containsKey(this.J.h(i3))) {
            f16 = this.A0.get(this.J.h(i3)).floatValue();
        } else {
            f16 = G;
        }
        if (f16 > 0.0f && G <= f16) {
            this.f205033c0.setVisibility(0);
            long k3 = pVar.k();
            if (!this.K0.contains(Long.valueOf(k3))) {
                Ni();
                this.K0.add(Long.valueOf(k3));
            }
            Zi(0);
            this.L.setVisibility(0);
        }
        this.I.bringToFront();
        if (sj() && ea.V(this.D, sh().getCurrentUin())) {
            ea.T3(this.D, sh().getCurrentUin(), false);
            LinearLayout linearLayout = new LinearLayout(this.D);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            ImageView imageView = new ImageView(this.D);
            imageView.setImageDrawable(this.D.getResources().getDrawable(R.drawable.caw));
            linearLayout.addView(imageView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.bottomMargin = -BaseAIOUtils.f(7.0f, this.D.getResources());
            layoutParams.topMargin = BaseAIOUtils.f(3.0f, this.D.getResources());
            imageView.setLayoutParams(layoutParams);
            TextView textView = new TextView(this.D);
            textView.setTextColor(this.D.getResources().getColor(R.color.f158017al3));
            textView.setTextSize(14.0f);
            textView.setGravity(17);
            textView.setText(this.D.getResources().getString(R.string.inw));
            textView.setBackgroundResource(R.drawable.cay);
            linearLayout.addView(textView);
            int f17 = BaseAIOUtils.f(7.0f, this.D.getResources());
            textView.setPadding(f17, 0, f17, 0);
            PopupWindow popupWindow = new PopupWindow(linearLayout, -2, -2);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);
            textView.measure(0, 0);
            this.K.post(new Runnable(popupWindow, textView) { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ PopupWindow f205099d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TextView f205100e;

                {
                    this.f205099d = popupWindow;
                    this.f205100e = textView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AIOEmotionFragment.this, popupWindow, textView);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Context context = AIOEmotionFragment.this.D;
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        PopupWindow popupWindow2 = this.f205099d;
                        TextView textView2 = AIOEmotionFragment.this.K;
                        popupWindow2.showAsDropDown(textView2, (textView2.getMeasuredWidth() / 2) - (this.f205100e.getMeasuredWidth() / 2), 0);
                    }
                }
            });
        }
    }

    private boolean ui() {
        int i3 = Q0;
        if (i3 != 0 && i3 != 2) {
            return false;
        }
        return true;
    }

    private void uj(y yVar) {
        xh("0X800A7E6");
        MessageForPic messageForPic = (MessageForPic) yVar.f205303a;
        int i3 = messageForPic.picExtraData.from;
        this.P.setVisibility(8);
        this.I.bringToFront();
        if (!TextUtils.isEmpty(messageForPic.picExtraData.source)) {
            if (messageForPic.picExtraData.source.length() > 11) {
                this.M.setText(messageForPic.picExtraData.source.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX);
            } else {
                this.M.setText(messageForPic.picExtraData.source);
            }
        }
        aj(0);
        this.T.setClickable(true);
        this.T.setOnTouchListener(new i(i3, messageForPic));
        if (i3 == 1) {
            if (((IEmoticonManagerService) sh().getRuntimeService(IEmoticonManagerService.class)).isEpidInTabcache(messageForPic.picExtraData.emojiPkgId)) {
                this.S.setText(this.D.getResources().getString(R.string.ii7));
                mj(this.S);
            } else {
                this.S.setText(this.D.getResources().getString(R.string.ii8));
                mj(this.S);
            }
        } else {
            this.S.setText(this.D.getResources().getString(R.string.ii9));
            mj(this.S);
        }
        this.S.setTextSize(16.0f);
        URL c16 = com.tencent.mobileqq.activity.aio.item.i.c(messageForPic);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mGifRoundCorner = this.H0;
        obtain.mPlayGifImage = true;
        this.U.setImageDrawable(URLDrawable.getDrawable(c16, obtain));
        this.U.setVisibility(0);
    }

    private boolean vi() {
        Bundle arguments = getArguments();
        if (arguments == null || arguments.getInt("key_source", 0) != 1) {
            return false;
        }
        return true;
    }

    private void vj(TextView textView) {
        si();
        if (textView != null) {
            textView.setTextColor(Color.parseColor("#999999"));
        }
    }

    private static boolean wi(p pVar) {
        String h16 = pVar.h();
        String g16 = pVar.g();
        QLog.d("AIOEmotionFragment", 1, "isGetJumpInfoParamInvalid emotionPkgId:" + h16 + ", emotionMD5:" + g16);
        if (TextUtils.isEmpty(h16) || TextUtils.equals("0", h16) || TextUtils.isEmpty(g16)) {
            return true;
        }
        return false;
    }

    private void wj(TextView textView) {
        String str;
        if (textView == null) {
            QLog.e("AIOEmotionFragment", 1, "updateEmotionTv: emotionNameTextView == null");
            return;
        }
        if (si()) {
            Button button = this.L;
            if (button != null && button.getVisibility() == 0) {
                str = "#666666";
            } else {
                str = "#FFFFFF";
            }
        } else {
            str = "#000000";
        }
        textView.setTextColor(Color.parseColor(str));
    }

    private boolean xi(p pVar) {
        if (!(pVar instanceof y) || pVar.r()) {
            return false;
        }
        if (!(this.F0 instanceof aa)) {
            QLog.e("AIOEmotionFragment", 1, "isPicNotReady dataSource is not MsgEmotionDataSource, dataSource:" + this.F0);
            return false;
        }
        return !((aa) r0).g(pVar);
    }

    private static boolean yi(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
            return false;
        }
        return true;
    }

    private void yj(com.tencent.mobileqq.ad.emoji.b bVar) {
        if (bVar.g() == 2) {
            pj();
        }
        if (Zh()) {
            QLog.i("AIOEmotionFragment", 1, "updateCommercialEmotionAreaView AI Emotion");
        } else {
            QLog.i("AIOEmotionFragment", 1, "updateCommercialEmotionAreaView Emotion INVISIBLE");
            aj(4);
        }
        QLog.i("AIOEmotionFragment", 1, "updateCommercialEmotionAreaView  emojiItem invalid, emojiItem:" + bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zi(String str, int i3, String str2, EmojiHotPicGetJumpInfoRspBody emojiHotPicGetJumpInfoRspBody) {
        if (i3 == 0 && str2.isEmpty()) {
            com.tencent.mobileqq.ad.emoji.b bVar = new com.tencent.mobileqq.ad.emoji.b();
            bVar.i(emojiHotPicGetJumpInfoRspBody.getJumpIcon());
            bVar.m(emojiHotPicGetJumpInfoRspBody.getEmojiName());
            bVar.h(emojiHotPicGetJumpInfoRspBody.getJumpDesc());
            bVar.k(emojiHotPicGetJumpInfoRspBody.getJumpUrl());
            bVar.n(emojiHotPicGetJumpInfoRspBody.getJumpId());
            bVar.l(str);
            this.L0 = bVar;
            QLog.i("AIOEmotionFragment", 1, "[requestAIEmtionDetail] rspInfo: " + bVar);
            this.H.removeMessages(1003);
            this.H.obtainMessage(1003, bVar).sendToTarget();
            return;
        }
        QLog.e("AIOEmotionFragment", 1, "[requestAIEmtionDetail] result: " + i3 + ", errMsg: " + str2);
    }

    private void zj(y yVar, int i3) {
        float f16;
        ZPlanPicExtraData zPlanPicExtraData = ((MessageForPic) yVar.f205303a).picExtraData.mZPlanPicInfo;
        this.M.setVisibility(0);
        aj(0);
        this.T.setClickable(true);
        this.T.setOnTouchListener(new j());
        this.I0 = new IZPlanEmoticonApi.b(yVar) { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.8
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ y f205101a;

            {
                this.f205101a = yVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this, (Object) yVar);
                }
            }

            @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi.b
            public void a(@Nullable Drawable drawable, @NonNull String str, @NonNull String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, drawable, str, str2);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(drawable, str, str2) { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.8.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Drawable f205103d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f205104e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ String f205105f;

                        {
                            this.f205103d = drawable;
                            this.f205104e = str;
                            this.f205105f = str2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass8.this, drawable, str, str2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            y yVar2 = AnonymousClass8.this.f205101a;
                            if (yVar2 != null && yVar2.x()) {
                                ImageView imageView = AIOEmotionFragment.this.U;
                                if (imageView != null) {
                                    imageView.setImageDrawable(this.f205103d);
                                    AIOEmotionFragment.this.U.setVisibility(0);
                                }
                                TextView textView = AIOEmotionFragment.this.M;
                                if (textView != null) {
                                    textView.setText(this.f205104e);
                                }
                                TextView textView2 = AIOEmotionFragment.this.S;
                                if (textView2 != null) {
                                    textView2.setText(this.f205105f);
                                    return;
                                }
                                return;
                            }
                            QLog.d("AIOEmotionFragment", 1, "ZPlanEmoticonDetailUtil onGetViewInfo not zplan give up");
                        }
                    });
                }
            }
        };
        ((IZPlanEmoticonApi) QRoute.api(IZPlanEmoticonApi.class)).setZPlanEmoticonDetailView(this.I0);
        this.K.setText(zPlanPicExtraData.getName());
        mj(this.S);
        this.I.bringToFront();
        float G = this.I.G();
        if (this.A0.containsKey(this.J.h(i3))) {
            f16 = this.A0.get(this.J.h(i3)).floatValue();
        } else {
            f16 = G;
        }
        if (yVar.s() && f16 > 0.0f && G <= f16) {
            Zi(0);
            this.f205033c0.setVisibility(0);
        } else {
            Zi(4);
            this.f205033c0.setVisibility(4);
        }
        sj();
        if (!((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin())) {
            this.S.setVisibility(4);
            this.T.setOnTouchListener(null);
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionGallery.a
    public void F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        Long h16 = this.J.h(this.I.getSelectedItemPosition());
        if (!this.A0.containsKey(h16)) {
            this.A0.put(h16, Float.valueOf(this.I.G()));
        }
        Message obtainMessage = this.H.obtainMessage(1002);
        obtainMessage.arg1 = 4;
        this.H.sendMessage(obtainMessage);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Oi(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        int i3;
        int i16;
        SessionInfo sessionInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) actionSheetItem);
            return;
        }
        if (!com.tencent.imcore.message.report.a.d()) {
            return;
        }
        int i17 = actionSheetItem.action;
        int i18 = 4;
        HashMap<String, Object> hashMap = null;
        if (i17 != 2) {
            if (i17 != 39) {
                if (i17 != 48) {
                    if (i17 != 54) {
                        if (i17 != 65) {
                            if (i17 != 166) {
                                if (i17 != 171) {
                                    i3 = 0;
                                } else {
                                    i3 = 3;
                                }
                            } else {
                                i16 = 2;
                            }
                        } else {
                            hashMap = com.tencent.mobileqq.emotionintegrate.report.a.f205279a.a("em_bas_view_expression");
                            i16 = 5;
                        }
                    } else {
                        hashMap = com.tencent.mobileqq.emotionintegrate.report.a.f205279a.a("em_bas_location_chat");
                        i3 = 7;
                    }
                } else {
                    hashMap = com.tencent.mobileqq.emotionintegrate.report.a.f205279a.a("em_bas_add_expression");
                    i16 = 4;
                }
                if (hashMap != null) {
                    com.tencent.mobileqq.emotionintegrate.report.a.f205279a.c(hashMap);
                }
                sessionInfo = this.f205050t0;
                if (sessionInfo != null) {
                    i18 = ii(sessionInfo.f179555d);
                }
                int intExtra = getBaseActivity().getIntent().getIntExtra("report_enter_type", 5);
                if (QLog.isColorLevel()) {
                    QLog.i("AIOEmotionFragment", 2, "reportShareActionSheetClick action=" + actionSheetItem.action + ",fromType=" + i16 + ",sessionType=" + i18 + ",enterType=" + intExtra);
                }
                ReportController.o(null, "dc00898", "", "", "0X800C36D", "0X800C36D", i16, 0, String.valueOf(i18), String.valueOf(intExtra), "", "");
            }
            hashMap = com.tencent.mobileqq.emotionintegrate.report.a.f205279a.a("em_bas_emoji_download");
            i3 = 6;
        } else {
            i3 = 1;
        }
        i16 = i3;
        if (hashMap != null) {
        }
        sessionInfo = this.f205050t0;
        if (sessionInfo != null) {
        }
        int intExtra2 = getBaseActivity().getIntent().getIntExtra("report_enter_type", 5);
        if (QLog.isColorLevel()) {
        }
        ReportController.o(null, "dc00898", "", "", "0X800C36D", "0X800C36D", i16, 0, String.valueOf(i18), String.valueOf(intExtra2), "", "");
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void Tg(AudioPlayerBase audioPlayerBase, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, audioPlayerBase, Integer.valueOf(i3), str);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void V3(AudioPlayerBase audioPlayerBase, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, audioPlayerBase, Integer.valueOf(i3), str);
            return;
        }
        IPicEmoticonInfo iPicEmoticonInfo = this.f205053w0;
        if (iPicEmoticonInfo != null && iPicEmoticonInfo.isNewSoundType()) {
            this.H.post(new Runnable(audioPlayerBase.q(), MarketFaceConstants.emoticonSoundPath.replace("[epId]", this.f205053w0.getEmoticon().epId).replace("[eId]", this.f205053w0.getEmoticon().eId), i3, audioPlayerBase) { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.20
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f205095d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f205096e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f205097f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ AudioPlayerBase f205098h;

                {
                    this.f205095d = r6;
                    this.f205096e = r7;
                    this.f205097f = i3;
                    this.f205098h = audioPlayerBase;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AIOEmotionFragment.this, r6, r7, Integer.valueOf(i3), audioPlayerBase);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f205095d.equalsIgnoreCase(this.f205096e)) {
                        float n3 = this.f205097f / this.f205098h.n();
                        if (n3 > 0.0f) {
                            QLog.i("AIOEmotionFragment", 2, "AudioPlayer on onProgressChanged, playPosition = " + n3);
                            AIOEmotionFragment.this.f205038h0.setProgress(n3);
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void W8(AudioPlayerBase audioPlayerBase, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) audioPlayerBase, (Object) str);
        } else {
            bi();
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.a
    public void d2(boolean z16, MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Boolean.valueOf(z16), messageForPic);
            return;
        }
        QLog.i("AIOEmotionFragment", 1, "onUIResult suc=" + z16);
        if (z16) {
            this.J.notifyDataSetChanged();
            this.Y.setVisibility(0);
        } else {
            Context context = this.D;
            QQToast.makeText(context, context.getString(R.string.d0c), 0).show();
        }
        this.X.hide();
        this.I.enableDoubleTap(true);
        this.I.enableScaleGesture(true);
        messageForPic.isDownStatusReady = true;
        try {
            QQAppInterface sh5 = sh();
            int i3 = ChatActivity.f175053a0;
            MqqHandler handler = sh5.getHandler(ChatActivity.class);
            if (handler != null) {
                handler.sendEmptyMessage(39);
            }
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer.a
    public void e(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        boolean f16 = com.tencent.mobileqq.qqaudio.audioplayer.c.f(BaseApplication.getContext());
        boolean c16 = com.tencent.mobileqq.qqaudio.audioplayer.c.c(BaseApplication.getContext());
        com.tencent.mobileqq.activity.aio.audiopanel.b.a(getBaseActivity(), z17, f16, c16);
        if (!this.f205039i0.r() || f16 || c16) {
            z18 = false;
        }
        xj(z18, z17);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void f9(AudioPlayerBase audioPlayerBase, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) audioPlayerBase, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    public View generateRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) layoutInflater, (Object) viewGroup);
        }
        return layoutInflater.inflate(R.layout.f167591bd, viewGroup, false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<MsgRevokeEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (ArrayList) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        ArrayList<Class<MsgRevokeEvent>> arrayList = new ArrayList<>();
        arrayList.add(MsgRevokeEvent.class);
        return arrayList;
    }

    public AiPanelInfo gi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AiPanelInfo) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (this.M0 == null) {
            this.M0 = ni();
        }
        return this.M0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        Object selectedItem;
        float f16;
        Drawable drawable;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = 4;
        switch (message.what) {
            case 1000:
                Object obj = message.obj;
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOEmotionFragment", 2, "update album name:" + str);
                    }
                    this.M.setText(str);
                    break;
                }
                break;
            case 1001:
                int i16 = message.arg1;
                int i17 = message.arg2;
                int i18 = this.C0;
                if (i16 != i18 || i17 != 0) {
                    if (i16 != i18) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.C0 = i16;
                    this.f205040j0 = null;
                    if (i16 != -1) {
                        selectedItem = this.J.getItem(i16);
                    } else {
                        selectedItem = this.I.getSelectedItem();
                    }
                    p pVar = (p) selectedItem;
                    if (pVar != null && (this.E0 || this.J.j(i16))) {
                        Ti();
                        if (this.D0) {
                            if (z16 && oi()) {
                                QLog.d("AIOEmotionFragment", 2, "MSG_UPDATE_EMOTION_UI stopAudio");
                                dj();
                            }
                            if (!pVar.x()) {
                                this.f205033c0.setVisibility(4);
                                Zi(4);
                                this.L.setVisibility(4);
                                aj(4);
                            }
                            if (qi(pVar) && t.f205295a.d()) {
                                nj(pVar);
                                break;
                            }
                        } else {
                            t tVar = t.f205295a;
                            if (!tVar.g() || i16 != -1) {
                                this.f205053w0 = null;
                            }
                            this.I.setInterceptTouchEventReturn(true);
                            this.S.setVisibility(0);
                            this.f205034d0.setVisibility(8);
                            if (pVar.r()) {
                                float G = this.I.G();
                                EmoticonInfo f17 = pVar.f();
                                if (f17 != 0) {
                                    if ((f17 instanceof IPicEmoticonInfo) && i16 != -1) {
                                        IPicEmoticonInfo iPicEmoticonInfo = (IPicEmoticonInfo) f17;
                                        if (iPicEmoticonInfo.getEmoticon() != null) {
                                            if (this.A0.containsKey(this.J.h(i16))) {
                                                f16 = this.A0.get(this.J.h(i16)).floatValue();
                                            } else {
                                                f16 = G;
                                            }
                                            if (f16 > 0.0f && G <= f16) {
                                                Zi(0);
                                                this.f205033c0.setVisibility(0);
                                            }
                                            this.f205053w0 = iPicEmoticonInfo;
                                            this.f205052v0 = iPicEmoticonInfo.getEmoticon();
                                            this.K.setText(iPicEmoticonInfo.getEmoticon().name);
                                            this.I.bringToFront();
                                            QLog.d("AIOEmotionFragment", 1, "getView emotion name:" + iPicEmoticonInfo.getEmoticon().name);
                                            if (fj(iPicEmoticonInfo) && (drawable = (Drawable) message.obj) != null && (drawable instanceof URLDrawable)) {
                                                this.f205040j0 = new WeakReference<>((URLDrawable) drawable);
                                            }
                                        }
                                    }
                                    sj();
                                }
                                if (i16 != -1) {
                                    this.L.setVisibility(4);
                                    hj(f17);
                                }
                            } else if (pVar.x() && pi()) {
                                zj((y) pVar, i16);
                            } else if (pVar.m() && !pVar.q() && pi()) {
                                gj((y) pVar);
                            } else if (qi(pVar)) {
                                nj(pVar);
                                if (tVar.f()) {
                                    tj(i16, pVar);
                                }
                            } else if (pVar.o() && !pVar.q()) {
                                pj();
                            } else {
                                this.f205033c0.setVisibility(4);
                                this.L.setVisibility(4);
                                Zi(4);
                                aj(4);
                                if (tVar.e() && ri(pVar)) {
                                    nj(pVar);
                                } else if (pVar.l()) {
                                    uj((y) pVar);
                                }
                                tj(i16, pVar);
                            }
                            if (xi(pVar)) {
                                this.Y.setVisibility(8);
                                this.X.show();
                                this.X.start(0);
                                this.I.enableDoubleTap(false);
                                this.I.enableScaleGesture(false);
                                ((aa) this.F0).o(this.I, this.H, pVar, this);
                            } else {
                                this.Y.setVisibility(0);
                                this.X.hide();
                                this.I.enableDoubleTap(true);
                                this.I.enableScaleGesture(true);
                            }
                            rj(pVar.x());
                            com.tencent.mobileqq.emotionintegrate.h.c(this.T, pVar);
                            break;
                        }
                    }
                }
                break;
            case 1002:
                int i19 = message.arg1;
                if (i19 == 0) {
                    p pVar2 = (p) this.I.getSelectedItem();
                    if (pVar2 != null) {
                        if (!pVar2.r() && !pVar2.x()) {
                            if (pVar2.a() != null) {
                                i3 = 0;
                            }
                            if (i3 == 0 && ((textView = this.K) == null || TextUtils.isEmpty(textView.getText()))) {
                                QLog.i("AIOEmotionFragment", 1, "no text so do not display remark prompt info");
                                break;
                            } else {
                                this.L.setVisibility(i3);
                                Zi(i3);
                                this.f205033c0.setVisibility(i3);
                                break;
                            }
                        } else {
                            this.L.setVisibility(4);
                            Zi(0);
                            this.f205033c0.setVisibility(0);
                            break;
                        }
                    }
                } else {
                    Zi(i19);
                    this.L.setVisibility(i19);
                    this.f205033c0.setVisibility(i19);
                    break;
                }
                break;
            case 1003:
                Object obj2 = message.obj;
                if (obj2 instanceof com.tencent.mobileqq.ad.emoji.b) {
                    oj((com.tencent.mobileqq.ad.emoji.b) obj2);
                    break;
                }
                break;
        }
        return true;
    }

    public int ii(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, i3)).intValue();
        }
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 != 1004 && i3 != 1008 && i3 != 1009 && i3 != 1010 && i3 != 1011 && i3 != 1020 && i3 != 1021 && i3 != 1022 && i3 != 1023 && i3 != 1024 && i3 != 1025 && i3 != 1036 && i3 != 10002 && i3 != 10003 && i3 != 10004) {
            return 4;
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    protected void initTitleBar(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        super.initTitleBar(view);
        if (vh()) {
            ImageView imageView = (ImageView) view.findViewById(R.id.ivTitleBtnRightImage);
            this.f205048r0 = imageView;
            imageView.setImageResource(R.drawable.qui_more_icon_navigation_01_selector);
            ImageView imageView2 = this.f205048r0;
            imageView2.setPadding(0, imageView2.getPaddingTop(), this.f205048r0.getPaddingRight(), this.f205048r0.getPaddingBottom());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f205048r0.getLayoutParams();
            float f16 = 36;
            layoutParams.height = BaseAIOUtils.f(f16, getResources());
            layoutParams.width = BaseAIOUtils.f(f16, getResources());
            this.f205048r0.setLayoutParams(layoutParams);
            ImageView imageView3 = (ImageView) view.findViewById(R.id.dsn);
            this.f205049s0 = imageView3;
            imageView3.setImageResource(R.drawable.k4l);
            this.f205049s0.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f205049s0.getLayoutParams();
            layoutParams2.height = BaseAIOUtils.f(f16, getResources());
            layoutParams2.width = BaseAIOUtils.f(f16, getResources());
            layoutParams2.rightMargin = 0;
            this.f205049s0.setLayoutParams(layoutParams2);
            this.f205049s0.setContentDescription(getString(R.string.w7z));
            this.f205049s0.setOnClickListener(new e());
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    protected void initViewWithBusiness(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
            return;
        }
        super.initViewWithBusiness(view);
        Intent intent = getBaseActivity().getIntent();
        this.G = (Rect) intent.getParcelableExtra("KEY_THUMBNAL_BOUND");
        this.f205050t0 = (SessionInfo) intent.getParcelableExtra(AppConstants.Key.SESSION_INFO);
        this.f205051u0 = (AIOContact) intent.getParcelableExtra("nt_aio_contact_info");
        mi();
        EmotionGallery emotionGallery = (EmotionGallery) view.findViewById(R.id.gallery);
        this.I = emotionGallery;
        emotionGallery.setAdapter((SpinnerAdapter) this.J);
        this.I.setOnScaleChangeListener(this);
        this.I.setOnScollListener(this);
        this.I.setSpacing(this.D.getResources().getDimensionPixelSize(R.dimen.f158920sg));
        this.I.setOnItemLongClickListener(this);
        this.I.setOnItemSelectedListener(this);
        this.f205031a0 = (RelativeLayout) view.findViewById(R.id.jo9);
        this.f205032b0 = view.findViewById(R.id.a4f);
        DragView dragView = (DragView) view.findViewById(R.id.bq8);
        this.Z = dragView;
        dragView.init();
        this.Z.setGestureChangeListener(this);
        this.Z.setDragChangeListener(this);
        this.Z.setRatioModify(false);
        TextView textView = (TextView) view.findViewById(R.id.k3);
        this.K = textView;
        wj(textView);
        this.L = (Button) view.findViewById(R.id.l9d);
        TextView textView2 = (TextView) view.findViewById(R.id.bh_);
        this.M = textView2;
        jj(textView2);
        this.N = (TextView) view.findViewById(R.id.ugq);
        TextView textView3 = (TextView) view.findViewById(R.id.bh8);
        this.S = textView3;
        textView3.setTextSize(16.0f);
        this.P = (LinearLayout) view.findViewById(R.id.f164520sy2);
        TextView textView4 = (TextView) view.findViewById(R.id.a1b);
        this.Q = textView4;
        lj(textView4);
        TextView textView5 = (TextView) view.findViewById(R.id.utv);
        this.R = textView5;
        vj(textView5);
        View findViewById = view.findViewById(R.id.bvp);
        this.T = findViewById;
        qj(findViewById, false);
        this.U = (ImageView) view.findViewById(R.id.bh9);
        this.V = (ImageView) view.findViewById(R.id.f164973a64);
        this.L.setOnClickListener(this);
        this.K.setOnClickListener(this);
        sh().addObserver(this.N0);
        this.Y = (ImageView) this.C.findViewById(R.id.ivTitleBtnRightImage);
        this.W = (ImageView) view.findViewById(R.id.f164114k0);
        com.tencent.common.galleryactivity.l lVar = new com.tencent.common.galleryactivity.l();
        this.X = lVar;
        lVar.b(super.getBaseActivity(), this.W);
        this.f205033c0 = (RelativeLayout) view.findViewById(R.id.f164117oq);
        this.f205034d0 = (RelativeLayout) view.findViewById(R.id.f164505ou);
        this.f205035e0 = (TriangleView) view.findViewById(R.id.c3l);
        this.f205036f0 = (RelativeLayout) view.findViewById(R.id.f164506ov);
        this.f205037g0 = (PttAudioPlayView) view.findViewById(R.id.f164507ow);
        PttAudioWaveView pttAudioWaveView = (PttAudioWaveView) view.findViewById(R.id.f164512ox);
        this.f205038h0 = pttAudioWaveView;
        pttAudioWaveView.setCanSupportSlide(false);
        this.f205038h0.setShowProgressLine(false);
        this.f205037g0.setPttPauseOrStopDrawable(R.drawable.b9z);
        kj(IPicEmoticonInfo.DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR, IPicEmoticonInfo.DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR);
        this.f205037g0.setOnClickListener(this);
        this.f205038h0.setOnClickListener(this);
        this.f205034d0.setVisibility(8);
        this.f205047q0 = (RelativeLayout) view.findViewById(R.id.f166476h52);
        com.tencent.mobileqq.activity.aio.photo.b.d().a(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        float f16 = getResources().getDisplayMetrics().density;
        this.G0 = f16;
        this.H0 = (int) (f16 * 6.0f);
        if (FontSettingManager.isFontSizeLarge()) {
            FontSettingManager.resetViewSize2Normal(this.D, this.T);
        }
        if (!Uh() && getBaseActivity().getIntent().getBooleanExtra("need_reload_data", true) && this.F0 != null) {
            QLog.d("AIOEmotionFragment", 1, "initViewWithBusiness dataSource=" + this.F0);
            this.F0.d(this, P0, false);
        }
        try {
            SharpImage.playByTag(2);
        } catch (Throwable th5) {
            QLog.e("AIOEmotionFragment", 1, "[initViewWithBusiness] SharpImage.playByTag error!", th5);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void j5(AudioPlayerBase audioPlayerBase, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, audioPlayerBase, Integer.valueOf(i3), str);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer.a
    public void k(boolean z16, boolean z17, boolean z18, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z26 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
            return;
        }
        if (z17 && z16) {
            z17 = com.tencent.mobileqq.qqaudio.audioplayer.c.d(BaseApplication.getContext());
        }
        com.tencent.mobileqq.activity.aio.audiopanel.b.a(getBaseActivity(), z18, z16, z17);
        if (!this.f205039i0.r() || z16 || z17) {
            z26 = false;
        }
        xj(z26, z18);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void k9(AudioPlayerBase audioPlayerBase, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, audioPlayerBase, Integer.valueOf(i3), str);
            return;
        }
        QLog.e("AIOEmotionFragment", 2, "AudioPlayer on onError, errorCode = " + i3);
        QQToast.makeText(this.D, 1, R.string.fyj, 0).show();
        bi();
    }

    protected void li(int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        String str;
        boolean z16;
        int i16;
        String str2;
        int i17;
        boolean z17;
        int i18;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3, (Object) actionSheetItem);
            return;
        }
        QQAppInterface sh5 = sh();
        if (sh5 == null) {
            QLog.d("AIOEmotionFragment", 1, "error runtime");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOEmotionFragment", 1, "handleClickMenuItem, action:" + i3);
        }
        p pVar = (p) this.I.getSelectedItem();
        if (!(pVar instanceof y)) {
            return;
        }
        y yVar = (y) pVar;
        MessageRecord messageRecord = yVar.f205303a;
        if (i3 != 2) {
            if (i3 != 9) {
                if (i3 != 39) {
                    if (i3 != 48) {
                        if (i3 != 54) {
                            if (i3 != 166) {
                                if (i3 != 171) {
                                    if (i3 != 65) {
                                        if (i3 != 66) {
                                            if (i3 != 72) {
                                                if (i3 != 73) {
                                                    return;
                                                }
                                            } else {
                                                Bundle bundle = new Bundle();
                                                bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                                                bundle.putInt("key_direct_show_uin_type", actionSheetItem.uinType);
                                                bundle.putString("key_direct_show_uin", actionSheetItem.uin);
                                                if (messageRecord instanceof MessageForMarketFace) {
                                                    Emoticon emoticon = this.f205052v0;
                                                    if (emoticon != null && (str3 = emoticon.epId) != null && MarketFaceItemBuilder.h(Integer.parseInt(str3))) {
                                                        ((com.tencent.mobileqq.emosm.o) sh5.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).W0(Integer.parseInt(this.f205052v0.epId), this.f205052v0.eId, new AnonymousClass12(bundle, sh5), 3000);
                                                        return;
                                                    } else {
                                                        Xi(bundle);
                                                        return;
                                                    }
                                                }
                                                bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                                                Intent g16 = com.tencent.mobileqq.activity.aio.item.i.g((MessageForPic) messageRecord, this.f205050t0, sh5, this.D);
                                                g16.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
                                                g16.putExtras(bundle);
                                                if (ti()) {
                                                    Th(g16, messageRecord);
                                                }
                                                g16.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE, false);
                                                ForwardBaseOption.startForwardActivityForResult(super.getBaseActivity(), g16, (Class<?>) ForwardRecentTranslucentActivity.class, 1, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gif");
                                                return;
                                            }
                                        } else {
                                            if (com.tencent.biz.anonymous.a.m(messageRecord)) {
                                                a.C0789a e16 = com.tencent.biz.anonymous.a.e(messageRecord);
                                                if (e16.f78366b == null) {
                                                    i18 = 2;
                                                    if (e16.f78365a != 2) {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.i("AIOEmotionFragment", 2, "Anonymous report : an_id is null");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                } else {
                                                    i18 = 2;
                                                }
                                                byte[] a16 = e16.a();
                                                if (a16 != null && e16.f78365a != i18) {
                                                    String encode = URLEncoder.encode(Base64.encodeToString(a16, i18));
                                                    com.tencent.biz.anonymous.a.h().q(messageRecord.frienduin, encode, messageRecord);
                                                    NewReportPlugin.R(sh5, messageRecord.frienduin, encode, sh5.getCurrentAccountUin(), com.tencent.biz.anonymous.a.h().j(messageRecord.frienduin, encode));
                                                    return;
                                                }
                                                return;
                                            }
                                            NewReportPlugin.T((BaseActivity) this.D, messageRecord.senderuin, messageRecord.frienduin, sh5.getCurrentAccountUin(), NewReportPlugin.u(this.f205050t0.f179555d), null);
                                            return;
                                        }
                                    } else {
                                        int i19 = this.f205050t0.f179555d;
                                        if (i19 != 1 && i19 != 3000) {
                                            i17 = 1;
                                        } else {
                                            i17 = 2;
                                        }
                                        ReportController.o(null, "dc00898", "", "", "0X8009EA7", "0X8009EA7", i17, 0, "", "", "", "");
                                        if (messageRecord instanceof MessageForMarketFace) {
                                            Emoticon emoticon2 = this.f205052v0;
                                            if (emoticon2 != null && this.f205053w0 != null) {
                                                String str4 = emoticon2.epId;
                                                if (str4 != null && MarketFaceItemBuilder.h(Integer.parseInt(str4))) {
                                                    ((com.tencent.mobileqq.emosm.o) sh5.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).W0(Integer.parseInt(this.f205052v0.epId), this.f205052v0.eId, new AnonymousClass14(sh5), 3000);
                                                    return;
                                                } else {
                                                    fi();
                                                    return;
                                                }
                                            }
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("error mEmoticon, ");
                                            if (this.f205052v0 == null) {
                                                z17 = true;
                                            } else {
                                                z17 = false;
                                            }
                                            sb5.append(z17);
                                            QLog.d("AIOEmotionFragment", 1, sb5.toString());
                                            return;
                                        }
                                        fi();
                                        return;
                                    }
                                } else {
                                    if (messageRecord instanceof MessageForPic) {
                                        MessageForPic messageForPic = (MessageForPic) messageRecord;
                                        Intent g17 = com.tencent.mobileqq.activity.aio.item.i.g(messageForPic, this.f205050t0, sh5, this.D);
                                        g17.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
                                        g17.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                                        Th(g17, messageRecord);
                                        g17.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE, false);
                                        g17.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
                                        g17.putExtra("forward_source_sub_business_type", "biz_src_jc_gif");
                                        if (messageForPic.ntChatType == 119) {
                                            g17.setFlags(0);
                                        }
                                        com.tencent.mobileqq.richmediabrowser.utils.e.c(getActivity(), g17);
                                        return;
                                    }
                                    if (messageRecord instanceof MessageForMarketFace) {
                                        Emoticon emoticon3 = this.f205052v0;
                                        if (emoticon3 != null && (str2 = emoticon3.epId) != null && MarketFaceItemBuilder.h(Integer.parseInt(str2))) {
                                            ((com.tencent.mobileqq.emosm.o) sh5.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).W0(Integer.parseInt(this.f205052v0.epId), this.f205052v0.eId, new AnonymousClass11(sh5), 3000);
                                            return;
                                        } else {
                                            Wi();
                                            return;
                                        }
                                    }
                                    return;
                                }
                            } else {
                                if (messageRecord instanceof MessageForPic) {
                                    File file = new File(((MessageForPic) messageRecord).path);
                                    if (file.exists()) {
                                        ((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList((Activity) this.D, file.getAbsolutePath(), "image/*");
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        } else {
                            if (getBaseActivity().getIntent().getBooleanExtra("from_chat_history", false)) {
                                i16 = 2;
                            } else {
                                i16 = 1;
                            }
                            ReportController.o(null, "dc00898", "", "", "0X8009EA8", "0X8009EA8", i16, 0, "", "", "", "");
                            String str5 = this.f205050t0.f179559f;
                            if (TextUtils.isEmpty(str5)) {
                                str5 = this.f205050t0.f179557e;
                            }
                            String str6 = str5;
                            if (ti()) {
                                try {
                                    if (this.f205050t0.b().getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 0).byteValue() == 1) {
                                        getBaseActivity().getIntent().putExtra(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
                                    }
                                    getActivity().finish();
                                } catch (Exception e17) {
                                    QLog.e("AIOEmotionFragment", 1, "LOCATE_TO_CHAT_POS error:" + e17);
                                }
                            }
                            if (this.f205051u0 != null) {
                                IMsgLocationApi iMsgLocationApi = (IMsgLocationApi) QRoute.api(IMsgLocationApi.class);
                                BaseActivity baseActivity = getBaseActivity();
                                SessionInfo sessionInfo = this.f205050t0;
                                iMsgLocationApi.jumpToTargetNTAIOPosition(baseActivity, sessionInfo.f179555d, sessionInfo.f179557e, str6, messageRecord.shmsgseq, messageRecord.uniseq, this.f205051u0.e(), this.f205051u0.j());
                            } else {
                                IMsgLocationApi iMsgLocationApi2 = (IMsgLocationApi) QRoute.api(IMsgLocationApi.class);
                                BaseActivity baseActivity2 = getBaseActivity();
                                SessionInfo sessionInfo2 = this.f205050t0;
                                iMsgLocationApi2.jumpToTargetNTAIOPosition(baseActivity2, sessionInfo2.f179555d, sessionInfo2.f179557e, str6, messageRecord.shmsgseq, messageRecord.uniseq);
                            }
                            Li();
                            return;
                        }
                    } else {
                        xh("0X8009982");
                        boolean z18 = messageRecord instanceof MessageForPic;
                        if (z18) {
                            MessageForPic messageForPic2 = (MessageForPic) messageRecord;
                            com.tencent.mobileqq.activity.aio.item.i.i(sh5, messageForPic2.senderuin, messageForPic2.md5, "0X8009F3E", "");
                        }
                        if (messageRecord instanceof MessageForMarketFace) {
                            Emoticon emoticon4 = this.f205052v0;
                            if (emoticon4 != null && this.f205053w0 != null) {
                                String str7 = emoticon4.epId;
                                if (str7 != null && MarketFaceItemBuilder.h(Integer.parseInt(str7))) {
                                    ((com.tencent.mobileqq.emosm.o) sh5.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).W0(Integer.parseInt(this.f205052v0.epId), this.f205052v0.eId, new AnonymousClass13(sh5), 3000);
                                    return;
                                } else {
                                    Ph(sh5);
                                    return;
                                }
                            }
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("error mEmoticon, ");
                            if (this.f205052v0 == null) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            sb6.append(z16);
                            QLog.d("AIOEmotionFragment", 1, sb6.toString());
                            return;
                        }
                        if (ti() && z18) {
                            QLog.i("AIOEmotionFragment", 1, "addPicToFavEmoForGuild");
                            Qh(sh5, (MessageForPic) messageRecord);
                            return;
                        }
                        if (!z18) {
                            QLog.e("AIOEmotionFragment", 1, "mr not MessageForPic");
                            return;
                        }
                        MessageForPic messageForPic3 = (MessageForPic) messageRecord;
                        URLDrawable drawable = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL(messageForPic3, 1), -1, -1, null, null, false);
                        drawable.setTag(messageRecord);
                        this.f205056z0.add(drawable);
                        if (messageForPic3.picExtraData == null) {
                            messageForPic3.picExtraData = new PicMessageExtraData();
                        }
                        String h16 = yVar.h();
                        if (TextUtils.isDigitsOnly(h16)) {
                            messageForPic3.picExtraData.jumpId = Integer.parseInt(h16);
                        }
                        com.tencent.mobileqq.activity.aio.photo.c.e(this.D, sh5, drawable, messageRecord.frienduin, getBaseActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height), null, messageForPic3.picExtraData);
                        EmoticonOperateReport.reportFavAddEmotionEvent(sh5, 2, messageForPic3.md5, null);
                        new x61.e().d(sh5, null, messageForPic3);
                        return;
                    }
                } else {
                    Si(messageRecord);
                    return;
                }
            } else {
                if (messageRecord instanceof MessageForPic) {
                    Vi((MessageForPic) messageRecord);
                    return;
                }
                return;
            }
        }
        xh("0X8009981");
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic4 = (MessageForPic) messageRecord;
            com.tencent.mobileqq.activity.aio.item.i.i(sh5, messageForPic4.senderuin, messageForPic4.md5, "0X8009F3D", "");
        }
        if (messageRecord instanceof MessageForMarketFace) {
            Emoticon emoticon5 = this.f205052v0;
            if (emoticon5 != null && (str = emoticon5.epId) != null && MarketFaceItemBuilder.h(Integer.parseInt(str))) {
                ((com.tencent.mobileqq.emosm.o) sh5.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).W0(Integer.parseInt(this.f205052v0.epId), this.f205052v0.eId, new AnonymousClass10(sh5), 3000);
                return;
            } else {
                Yi(sh5);
                return;
            }
        }
        Intent g18 = com.tencent.mobileqq.activity.aio.item.i.g((MessageForPic) messageRecord, this.f205050t0, sh5, this.D);
        g18.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
        Th(g18, messageRecord);
        g18.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE, false);
        ForwardBaseOption.startForwardActivityForResult(super.getBaseActivity(), g18, 1, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gif");
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDataSource.a
    public void m5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
        } else {
            this.H.post(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.21
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOEmotionFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AIOEmotionFragment aIOEmotionFragment = AIOEmotionFragment.this;
                        com.tencent.mobileqq.activity.aio.photo.b.b((Activity) aIOEmotionFragment.D, (RelativeLayout) aIOEmotionFragment.C);
                    }
                }
            });
        }
    }

    public void mi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
            return;
        }
        if (P0 == null) {
            QLog.d("AIOEmotionFragment", 1, "initDataResource fail");
            return;
        }
        if (ui() && (P0 instanceof y)) {
            this.F0 = Wh();
        } else if (Q0 == 1 && (P0 instanceof u)) {
            this.F0 = new v(sh(), (u) P0);
        }
        if (this.F0 == null) {
            QLog.d("AIOEmotionFragment", 1, "initDataResource fail dataSource is null.");
        } else {
            this.J = new EmotionAdapter(getBaseActivity(), this.H, P0);
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.a
    public void nf(int i3, MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, i3, (Object) messageForPic);
        } else {
            this.X.start(i3 / 100);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1) {
            ShareActionSheet shareActionSheet = this.f205054x0;
            if (shareActionSheet != null && shareActionSheet.isShowing()) {
                this.f205054x0.dismiss();
            }
            if (i16 != -1) {
                QLog.e("AIOEmotionFragment", 1, "[onActivityResult] failed! resultCode=", Integer.valueOf(i16));
                return;
            }
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, this.D.getString(R.string.hvn));
            Bundle bundle = new Bundle(intent.getExtras());
            Intent intent2 = new Intent();
            intent2.putExtras(bundle);
            if (super.sh() != null) {
                ForwardUtils.w(super.sh(), super.getBaseActivity(), this.D, intent2, ThreadManager.getUIHandler());
                return;
            }
            return;
        }
        if (i16 == -1 && i3 == 2) {
            this.H.removeMessages(1001);
            this.H.obtainMessage(1001, -1, 1).sendToTarget();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        if (getBaseActivity() != null) {
            getBaseActivity().finish();
            Li();
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        CustomEmotionData a16;
        String str;
        QQAppInterface sh5;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) view);
        } else {
            boolean z16 = false;
            if (view.getId() != R.id.l9d && view.getId() != R.id.k3) {
                if (view.getId() != R.id.f164507ow && view.getId() != R.id.f164512ox) {
                    if (view.getId() == R.id.f164199mz && (sh5 = sh()) != null) {
                        boolean f16 = com.tencent.mobileqq.qqaudio.audioplayer.c.f(BaseApplication.getContext());
                        boolean c16 = com.tencent.mobileqq.qqaudio.audioplayer.c.c(BaseApplication.getContext());
                        boolean z17 = !this.f205041k0;
                        this.f205041k0 = z17;
                        com.tencent.mobileqq.qqaudio.audioplayer.c.i(z17, sh5);
                        boolean oi5 = oi();
                        this.f205039i0.g(1, this.f205041k0);
                        if (!f16 && !c16 && oi5) {
                            z16 = true;
                        }
                        xj(z16, this.f205041k0);
                    }
                } else if (oi()) {
                    dj();
                    IPicEmoticonInfo iPicEmoticonInfo = this.f205053w0;
                    if (iPicEmoticonInfo != null && iPicEmoticonInfo.getEmoticon() != null) {
                        EmoticonOperateReport.reportNewSoundEvent(sh(), "0X800A9E1", -1, this.f205053w0.getEmoticon().epId);
                    }
                } else {
                    Ki();
                    IPicEmoticonInfo iPicEmoticonInfo2 = this.f205053w0;
                    if (iPicEmoticonInfo2 != null && iPicEmoticonInfo2.getEmoticon() != null) {
                        EmoticonOperateReport.reportNewSoundEvent(sh(), "0X800A9E0", -1, this.f205053w0.getEmoticon().epId);
                    }
                }
            } else if (!hf0.a.b("AIOEmotionFragment", 1000L) && this.L.getVisibility() == 0 && (pVar = (p) this.I.getSelectedItem()) != null && (a16 = pVar.a()) != null) {
                if (!TextUtils.isEmpty(a16.modifyWord)) {
                    str = a16.modifyWord;
                } else {
                    str = a16.ocrWord;
                }
                Intent intent = new Intent(getBaseActivity(), (Class<?>) EditActivity.class);
                intent.putExtra("title", R.string.inp);
                intent.putExtra("limit", 10);
                intent.putExtra("action", 105);
                intent.putExtra("key_emo_id", a16.emoId);
                intent.putExtra("key_input_tip", getResources().getString(R.string.inq));
                intent.putExtra("current", str);
                intent.putExtra("canPostNull", false);
                intent.putExtra("multiLine", false);
                ReportController.o(null, "dc00898", "", "", "0X800A7C1", "0X800A7C1", this.F0.a(), 0, "", "", "", "");
                startActivityForResult(intent, 2);
                Mi();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onClickDragView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
        }
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onContentMove(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Float.valueOf(f16));
            return;
        }
        this.f205032b0.setAlpha(f16);
        this.f205031a0.setAlpha(f16);
        if (f16 < 0.9f) {
            this.F.setVisibility(4);
            ImageView imageView = this.f205048r0;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            ImageView imageView2 = this.f205049s0;
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            aj(4);
            Zi(4);
            this.L.setVisibility(4);
            this.W.setVisibility(4);
            this.f205033c0.setVisibility(4);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Object[] objArr = new Object[2];
        boolean z16 = false;
        objArr[0] = "onCreate, mCurDataIsNull:";
        if (P0 == null) {
            z16 = true;
        }
        objArr[1] = Boolean.valueOf(z16);
        QLog.d("AIOEmotionFragment", 1, objArr);
        if (P0 == null) {
            try {
                P0 = p.z(bundle);
            } catch (Exception e16) {
                QLog.d("AIOEmotionFragment", 1, "onCreate exception:", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 18, this, layoutInflater, viewGroup, bundle);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AIOEmotionFragment", 1, "onCreateView");
            }
            p pVar = P0;
            if (pVar != null && pVar.r()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            this.E = i3;
            this.f205043m0 = getBaseActivity().getIntent().getBooleanExtra("need_more_btn", true);
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            com.tencent.mobileqq.emotionintegrate.h.a(getBaseActivity(), onCreateView, this.f205050t0);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        this.H.removeCallbacksAndMessages(null);
        if (this.f205055y0 != null) {
            ((IEmojiManagerService) sh().getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().removeEmotionJsonDownloadListener(this.f205055y0);
            this.f205055y0 = null;
        }
        sh().removeObserver(this.N0);
        EmotionDataSource emotionDataSource = this.F0;
        if (emotionDataSource != null) {
            emotionDataSource.e();
        }
        if (!this.f205056z0.isEmpty()) {
            Iterator<URLDrawable> it = this.f205056z0.iterator();
            while (it.hasNext()) {
                it.next().setTag(null);
            }
        }
        CommonAudioPlayer commonAudioPlayer = this.f205039i0;
        if (commonAudioPlayer != null) {
            if (commonAudioPlayer.r()) {
                this.f205039i0.stop();
            }
            QQAppInterface sh5 = sh();
            if (sh5 != null) {
                ((IAudioDeviceService) sh5.getRuntimeService(IAudioDeviceService.class)).unRegisterAudioDeviceListener(this.f205039i0);
            }
            this.f205039i0.j();
        }
        View view = this.f205044n0;
        if (view != null) {
            view.setVisibility(4);
            this.f205044n0 = null;
        }
        aj(4);
        Zi(4);
        this.f205040j0 = null;
        PttAudioPlayView pttAudioPlayView = this.f205037g0;
        if (pttAudioPlayView != null) {
            pttAudioPlayView.b();
        }
        PttAudioWaveView pttAudioWaveView = this.f205038h0;
        if (pttAudioWaveView != null) {
            pttAudioWaveView.e();
        }
        EmotionAdapter emotionAdapter = this.J;
        if (emotionAdapter != null) {
            emotionAdapter.k();
        }
        ((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).onAIOEmotionFragmentDestroy();
        com.tencent.mobileqq.activity.aio.photo.b.d().f(this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SharpImage.pauseByTag(2);
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onGestureFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && !baseActivity.isFinishing()) {
            baseActivity.finish();
            baseActivity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        if (vi()) {
            return false;
        }
        xh("0X8009980");
        if (this.F0.b()) {
            rh();
        }
        return false;
    }

    @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else if (this.J.j(i3)) {
            this.Z.setOriginRect(this.G);
        } else {
            this.Z.setOriginRect(null);
        }
    }

    @Override // com.tencent.widget.DragView.OnDragChangeListener
    public int[] onModifyCurViewSize() {
        Drawable drawable;
        int intrinsicWidth;
        int intrinsicHeight;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (int[]) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        EmotionAdapter.a d16 = this.J.d();
        if (d16 instanceof EmotionAdapter.e) {
            EmotionAdapter.e eVar = (EmotionAdapter.e) d16;
            intrinsicWidth = eVar.f205150a.getWidth();
            intrinsicHeight = eVar.f205150a.getHeight();
        } else {
            ImageView imageView = (ImageView) this.I.getSelectedView();
            if (imageView == null || (drawable = imageView.getDrawable()) == null) {
                return null;
            }
            intrinsicWidth = (int) (drawable.getIntrinsicWidth() * this.I.G());
            intrinsicHeight = (int) (drawable.getIntrinsicHeight() * this.I.G());
        }
        return new int[]{intrinsicWidth, intrinsicHeight};
    }

    @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) adapterView);
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        super.onPause();
        if (oi()) {
            dj();
        }
        EmotionAdapter emotionAdapter = this.J;
        if (emotionAdapter != null) {
            EmotionAdapter.a d16 = emotionAdapter.d();
            if (d16 instanceof EmotionAdapter.e) {
                EmotionAdapter.e eVar = (EmotionAdapter.e) d16;
                BaseVideoView baseVideoView = eVar.f205153d;
                if (!baseVideoView.isMute()) {
                    baseVideoView.setMute(true);
                }
                eVar.f205152c.setImageResource(R.drawable.mnf);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof MsgRevokeEvent) {
            v5(((MsgRevokeEvent) simpleBaseEvent).getMsgId());
        }
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onResetPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        p pVar = (p) this.I.getSelectedItem();
        if (pVar == null) {
            return;
        }
        this.f205031a0.setAlpha(1.0f);
        int i3 = 0;
        this.F.setVisibility(0);
        ImageView imageView = this.f205048r0;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.f205049s0;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        Ti();
        if (pVar.r()) {
            aj(0);
            this.L.setVisibility(4);
            Zi(0);
            this.f205033c0.setVisibility(0);
            return;
        }
        if (qi(pVar)) {
            nj(pVar);
            return;
        }
        if (pVar.l()) {
            aj(0);
        } else {
            aj(4);
        }
        if (pVar.a() == null) {
            i3 = 4;
        }
        this.L.setVisibility(i3);
        Zi(i3);
        this.f205033c0.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        EmotionGallery emotionGallery;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.J0 && (emotionGallery = this.I) != null) {
            p pVar = (p) emotionGallery.getSelectedItem();
            if ((pVar instanceof y) && pVar.x()) {
                zj((y) pVar, this.C0);
            }
            this.J0 = false;
        }
        AIOContact aIOContact = this.f205051u0;
        if (aIOContact != null) {
            com.tencent.mobileqq.emotionintegrate.report.b.f205282a.d(aIOContact.e());
            com.tencent.mobileqq.emotionintegrate.report.c.f205285a.h(this.f205051u0.e());
        } else {
            com.tencent.mobileqq.emotionintegrate.report.c.f205285a.a();
        }
        EmotionGallery emotionGallery2 = this.I;
        if (emotionGallery2 != null && (emotionGallery2.getSelectedItem() instanceof p)) {
            p pVar2 = (p) this.I.getSelectedItem();
            com.tencent.mobileqq.emotionintegrate.report.b.f205282a.e(new View(this.D), pVar2);
            com.tencent.mobileqq.emotionintegrate.report.c cVar = com.tencent.mobileqq.emotionintegrate.report.c.f205285a;
            cVar.i(pVar2);
            cVar.g();
        } else {
            com.tencent.mobileqq.emotionintegrate.report.c.f205285a.b();
        }
        super.onResume();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bundle);
            return;
        }
        super.onSaveInstanceState(bundle);
        if (P0 != null) {
            QLog.d("AIOEmotionFragment", 1, "onSaveInstanceState");
            P0.y(bundle, Q0);
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionGallery.a
    public void onScaleEnd(float f16) {
        float G;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Float.valueOf(f16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOEmotionFragment", 2, "onScaleEnd scale:" + f16);
        }
        Message obtainMessage = this.H.obtainMessage(1002);
        Long h16 = this.J.h(this.I.getSelectedItemPosition());
        if (this.A0.containsKey(h16)) {
            G = this.A0.get(h16).floatValue();
        } else {
            G = this.I.G();
        }
        if (f16 > G) {
            i3 = 4;
        }
        obtainMessage.arg1 = i3;
        this.H.sendMessage(obtainMessage);
    }

    @Override // com.tencent.widget.Gallery.OnScollListener
    public void onScrollEnd(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
            return;
        }
        if (!this.D0) {
            return;
        }
        int selectedItemPosition = this.I.getSelectedItemPosition();
        QLog.d("AIOEmotionFragment", 1, "getView onScrollEnd:" + i3 + " currentPosition:" + this.I.getSelectedItemPosition() + " selectPos: " + selectedItemPosition + " hasScrolled: " + this.D0);
        if (this.I.G() == this.B0) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        this.D0 = false;
        this.E0 = true;
        this.H.removeMessages(1001);
        this.H.obtainMessage(1001, selectedItemPosition, i16).sendToTarget();
    }

    @Override // com.tencent.widget.Gallery.OnScollListener
    public void onScrollStart(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3);
            return;
        }
        QLog.d("AIOEmotionFragment", 1, "getView onScrollStart:" + i3 + " currentPosition:" + this.I.getSelectedItemPosition() + " hasScrolled: " + this.D0);
        this.E0 = true;
        if (!this.D0) {
            this.D0 = true;
            this.H.removeMessages(1001);
            this.H.obtainMessage(1001, -1, 0).sendToTarget();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        BaseVideoView c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onStart();
        EmotionAdapter emotionAdapter = this.J;
        if (emotionAdapter != null && (c16 = emotionAdapter.c()) != null && !c16.isPlaying()) {
            c16.play();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        super.onStop();
        EmotionAdapter emotionAdapter = this.J;
        if (emotionAdapter != null) {
            EmotionAdapter.a d16 = emotionAdapter.d();
            if (d16 instanceof EmotionAdapter.e) {
                ((EmotionAdapter.e) d16).f205153d.pause();
            }
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    protected void qh(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            com.tencent.mobileqq.emotionintegrate.report.b bVar = com.tencent.mobileqq.emotionintegrate.report.b.f205282a;
            bVar.b(bVar.a(WinkDaTongReportConstant.ElementId.EM_BAS_SHARE));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017c  */
    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void rh() {
        boolean z16;
        AIOContact aIOContact;
        ArrayList arrayList;
        ArrayList arrayList2;
        MessageRecord messageRecord;
        IPicEmoticonInfo iPicEmoticonInfo;
        PicMessageExtraData picMessageExtraData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        p pVar = (p) this.I.getSelectedItem();
        boolean z17 = pVar instanceof y;
        boolean z18 = false;
        if (z17) {
            MessageRecord messageRecord2 = ((y) pVar).f205303a;
            if ((messageRecord2 instanceof MessageForPic) && (picMessageExtraData = ((MessageForPic) messageRecord2).picExtraData) != null && picMessageExtraData.isZhitu() && !messageRecord2.isSend()) {
                z16 = true;
                aIOContact = this.f205051u0;
                if (aIOContact != null) {
                    com.tencent.mobileqq.emotionintegrate.report.a.f205279a.d(aIOContact.e());
                }
                if (pVar != null) {
                    com.tencent.mobileqq.emotionintegrate.report.a.f205279a.e(pVar);
                }
                if (this.f205054x0 == null) {
                    ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                    param.context = this.D;
                    param.isNotShowMyPc = false;
                    param.deReportParams = com.tencent.mobileqq.emotionintegrate.report.a.f205279a.b();
                    ShareActionSheet create = ShareActionSheetFactory.create(param);
                    this.f205054x0 = create;
                    create.setActionSheetTitle(this.D.getString(R.string.bgc));
                }
                arrayList = new ArrayList();
                arrayList2 = new ArrayList();
                dw.a(2, arrayList);
                dw.a(171, arrayList);
                if (pVar != null && !pVar.r() && ((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).isMimeTypeSupported("image/*")) {
                    dw.a(166, arrayList);
                }
                if (pVar != null && (pVar.x() || pVar.m())) {
                    dw.a(9, arrayList);
                }
                if (pVar != null && Fi(pVar)) {
                    dw.a(48, arrayList2);
                }
                if (!getBaseActivity().getIntent().getBooleanExtra("from_chat_history", false)) {
                    dw.a(65, arrayList2);
                }
                if (Gi(pVar)) {
                    dw.a(39, arrayList2);
                }
                if (getBaseActivity().getIntent().getBooleanExtra("hide_emo_position", true)) {
                    dw.a(54, arrayList2);
                }
                if (z16) {
                    dw.a(66, arrayList2);
                }
                this.f205054x0.setItemClickListenerV2(new f());
                this.f205054x0.setActionSheetItems(arrayList, arrayList2);
                if (getBaseActivity() != null) {
                    getBaseActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_gif");
                }
                QQAppInterface sh5 = sh();
                if (z17 && sh5 != null) {
                    messageRecord = ((y) pVar).f205303a;
                    if (!(messageRecord instanceof MessageForMarketFace)) {
                        if (this.f205052v0 != null && (iPicEmoticonInfo = this.f205053w0) != null) {
                            O0 = iPicEmoticonInfo;
                            ((IEmoticonManagerService) sh5.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(this.f205052v0.epId, new g(sh5));
                            return;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("error mEmoticon, ");
                        if (this.f205052v0 == null) {
                            z18 = true;
                        }
                        sb5.append(z18);
                        QLog.d("AIOEmotionFragment", 1, sb5.toString());
                    } else if (messageRecord instanceof MessageForPic) {
                        Intent g16 = com.tencent.mobileqq.activity.aio.item.i.g((MessageForPic) messageRecord, this.f205050t0, sh5, this.D);
                        g16.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
                        g16.putExtra(RichMediaBrowserConstants.KEY_TYPE_FROM_NEW_IMG_SHARE_ACTION_SHEET, 1);
                        g16.putExtra("k_dataline", true);
                        if (ti()) {
                            Th(g16, messageRecord);
                        }
                        g16.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE, false);
                        this.f205054x0.setIntentForStartForwardRecentActivity(g16);
                    }
                }
                this.f205054x0.show();
            }
        }
        z16 = false;
        aIOContact = this.f205051u0;
        if (aIOContact != null) {
        }
        if (pVar != null) {
        }
        if (this.f205054x0 == null) {
        }
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        dw.a(2, arrayList);
        dw.a(171, arrayList);
        if (pVar != null) {
            dw.a(166, arrayList);
        }
        if (pVar != null) {
            dw.a(9, arrayList);
        }
        if (pVar != null) {
            dw.a(48, arrayList2);
        }
        if (!getBaseActivity().getIntent().getBooleanExtra("from_chat_history", false)) {
        }
        if (Gi(pVar)) {
        }
        if (getBaseActivity().getIntent().getBooleanExtra("hide_emo_position", true)) {
        }
        if (z16) {
        }
        this.f205054x0.setItemClickListenerV2(new f());
        this.f205054x0.setActionSheetItems(arrayList, arrayList2);
        if (getBaseActivity() != null) {
        }
        QQAppInterface sh52 = sh();
        if (z17) {
            messageRecord = ((y) pVar).f205303a;
            if (!(messageRecord instanceof MessageForMarketFace)) {
            }
        }
        this.f205054x0.show();
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDataSource.a
    public void sg(List<p> list, p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) list, (Object) pVar);
        } else if (list != null && !list.isEmpty()) {
            this.H.post(new Runnable(list, pVar) { // from class: com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.19
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f205093d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ p f205094e;

                {
                    this.f205093d = list;
                    this.f205094e = pVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AIOEmotionFragment.this, list, pVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AIOEmotionFragment.this.J.setData(this.f205093d);
                    AIOEmotionFragment.this.J.notifyDataSetChanged();
                    p pVar2 = this.f205094e;
                    boolean z16 = false;
                    if (pVar2 != null) {
                        i3 = AIOEmotionFragment.this.J.f(pVar2);
                    } else {
                        i3 = 0;
                    }
                    AIOEmotionFragment.this.I.setSelection(i3);
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[4];
                        objArr[0] = "mGallery setSelection pos:";
                        objArr[1] = Integer.valueOf(i3);
                        objArr[2] = " dataIsNull:";
                        if (this.f205094e == null) {
                            z16 = true;
                        }
                        objArr[3] = Boolean.valueOf(z16);
                        QLog.d("AIOEmotionFragment", 2, objArr);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.g
    public void v5(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, j3);
            return;
        }
        EmotionDataSource emotionDataSource = this.F0;
        if (emotionDataSource instanceof aa) {
            ((aa) emotionDataSource).m(this.I, this.J, j3, this);
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    public boolean vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (vi() || !this.f205043m0 || !ui()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    protected void wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            getBaseActivity().finish();
            Li();
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionGallery.a
    public void x5(float f16) {
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Float.valueOf(f16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOEmotionFragment", 2, "onDoubleTap currScale:" + f16);
        }
        Message obtainMessage = this.H.obtainMessage(1002);
        Long h16 = this.J.h(this.I.getSelectedItemPosition());
        if (this.A0.containsKey(h16)) {
            f17 = this.A0.get(h16).floatValue();
        } else {
            float G = this.I.G();
            this.A0.put(h16, Float.valueOf(G));
            f17 = G;
        }
        if (f16 <= f17) {
            i3 = 4;
        }
        obtainMessage.arg1 = i3;
        this.H.sendMessage(obtainMessage);
    }

    protected void xj(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (z16 && !ah.n0()) {
            if (this.f205044n0 == null) {
                BaseActivity baseActivity = getBaseActivity();
                if (baseActivity == null) {
                    return;
                }
                ((LayoutInflater) baseActivity.getSystemService("layout_inflater")).inflate(R.layout.f167626c7, this.f205047q0);
                this.f205044n0 = this.f205047q0.findViewById(R.id.f164199mz);
                this.f205045o0 = (TextView) this.f205047q0.findViewById(R.id.f164200n0);
                this.f205046p0 = (ImageView) this.f205047q0.findViewById(R.id.f164198my);
                this.f205044n0.setOnClickListener(this);
                ((RelativeLayout.LayoutParams) this.f205044n0.getLayoutParams()).addRule(2, R.id.bvp);
            }
            this.f205044n0.bringToFront();
            this.f205044n0.setVisibility(0);
            if (ThemeUtil.isNowThemeIsNight(sh(), false, null)) {
                this.f205045o0.setTextColor(Color.parseColor("#FF737373"));
            }
            if (z17) {
                this.f205045o0.setText(R.string.f170295ln);
                this.f205046p0.setBackgroundResource(R.drawable.skin_aio_phone_speaker);
                return;
            } else {
                this.f205045o0.setText(R.string.f170294lm);
                this.f205046p0.setBackgroundResource(R.drawable.skin_aio_phone_ear);
                return;
            }
        }
        View view = this.f205044n0;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
