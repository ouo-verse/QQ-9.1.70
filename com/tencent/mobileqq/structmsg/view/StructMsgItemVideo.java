package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.constants.Constants;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5BuilderFactory;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StructMsgItemVideo extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    public String R0;
    public String S0;
    public int T0;
    public f U0;
    public boolean V0;
    public String W0;
    public String X0;
    public String Y0;
    public int Z0;

    /* renamed from: a1, reason: collision with root package name */
    public int f290486a1;

    /* renamed from: b1, reason: collision with root package name */
    public int f290487b1;

    /* renamed from: c1, reason: collision with root package name */
    public int f290488c1;

    /* renamed from: d1, reason: collision with root package name */
    public int f290489d1;

    /* renamed from: e1, reason: collision with root package name */
    public String f290490e1;

    /* renamed from: f1, reason: collision with root package name */
    public String f290491f1;

    /* renamed from: g1, reason: collision with root package name */
    public String f290492g1;

    /* renamed from: h1, reason: collision with root package name */
    public int f290493h1;

    /* renamed from: i1, reason: collision with root package name */
    public long f290494i1;

    /* renamed from: j1, reason: collision with root package name */
    public int f290495j1;

    /* renamed from: k1, reason: collision with root package name */
    public String f290496k1;

    /* renamed from: l1, reason: collision with root package name */
    String f290497l1;

    /* renamed from: m1, reason: collision with root package name */
    String f290498m1;

    /* renamed from: n1, reason: collision with root package name */
    String f290499n1;

    /* renamed from: o1, reason: collision with root package name */
    String f290500o1;

    /* renamed from: p1, reason: collision with root package name */
    public boolean f290501p1;

    /* renamed from: q1, reason: collision with root package name */
    public boolean f290502q1;

    /* renamed from: r1, reason: collision with root package name */
    String f290503r1;

    /* renamed from: s1, reason: collision with root package name */
    boolean f290504s1;

    /* renamed from: t1, reason: collision with root package name */
    String f290505t1;

    /* renamed from: u1, reason: collision with root package name */
    String f290506u1;

    /* renamed from: v1, reason: collision with root package name */
    public String f290507v1;

    /* renamed from: w1, reason: collision with root package name */
    public String f290508w1;

    /* renamed from: x1, reason: collision with root package name */
    private View.OnClickListener f290509x1;

    /* renamed from: y1, reason: collision with root package name */
    private URLDrawableDownListener.Adapter f290510y1;

    /* renamed from: z1, reason: collision with root package name */
    protected View.OnClickListener f290511z1;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.structmsg.view.StructMsgItemVideo$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        class DialogInterfaceOnClickListenerC8624a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f290515d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f290516e;

            DialogInterfaceOnClickListenerC8624a(Context context, View view) {
                this.f290515d = context;
                this.f290516e = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, context, view);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    StructMsgItemVideo.this.x(this.f290515d, this.f290516e);
                    Context context = this.f290515d;
                    if (context instanceof BaseActivity) {
                        ReportController.o(((BaseActivity) context).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
                    }
                    dialogInterface.dismiss();
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgItemVideo.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Context context = view.getContext();
                if (NetworkUtil.getSystemNetwork(context) == 1) {
                    StructMsgItemVideo.this.x(context, view);
                    if (context instanceof BaseActivity) {
                        ReportController.o(((BaseActivity) context).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
                    }
                } else if (!NetworkUtil.isNetworkAvailable(context)) {
                    QQToast.makeText(context, R.string.b3j, 0).show();
                } else {
                    Resources resources = context.getResources();
                    DialogUtil.createCustomDialog(context, 232, "", HardCodeUtil.qqStr(R.string.tvt), resources.getString(R.string.cancel), resources.getString(R.string.f171151ok), new DialogInterfaceOnClickListenerC8624a(context, view), new b()).show();
                }
                ReportController.o(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends URLDrawableDownListener.Adapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgItemVideo.this);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            super.onLoadCancelled(view, uRLDrawable);
            if (QLog.isColorLevel()) {
                QLog.d("structmsg.StructMsgItemVideo", 2, "onLoadCancelled");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
                return;
            }
            super.onLoadFailed(view, uRLDrawable, th5);
            if (QLog.isColorLevel()) {
                QLog.d("structmsg.StructMsgItemVideo", 2, "onLoadFailed ,cause = " + th5);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, uRLDrawable, interruptedException);
                return;
            }
            super.onLoadInterrupted(view, uRLDrawable, interruptedException);
            if (QLog.isColorLevel()) {
                QLog.d("structmsg.StructMsgItemVideo", 2, "onLoadInterrupted");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            view.getLayoutParams().width = (view.getLayoutParams().height * uRLDrawable.getIntrinsicWidth()) / uRLDrawable.getIntrinsicHeight();
            view.setBackgroundDrawable(uRLDrawable);
            view.requestLayout();
            if (QLog.isColorLevel()) {
                QLog.d("structmsg.StructMsgItemVideo", 2, "onLoadSuccessed");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgItemVideo.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x0114  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            String str4;
            AbsStructMsg absStructMsg;
            JSONObject jSONObject;
            MessageRecord messageRecord;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Context context = view.getContext();
                Object tag = view.getTag(R.id.f166926j53);
                if (tag != null && (tag instanceof e)) {
                    AbsStructMsg absStructMsg2 = StructMsgItemVideo.this.P0;
                    if ((absStructMsg2 instanceof StructMsgForGeneralShare) && !TextUtils.isEmpty(((StructMsgForGeneralShare) absStructMsg2).mMsgActionData) && ((StructMsgForGeneralShare) StructMsgItemVideo.this.P0).mMsgActionData.startsWith("mqqapi://qsubscribe")) {
                        try {
                            Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                            intent.setData(Uri.parse(((StructMsgForGeneralShare) StructMsgItemVideo.this.P0).mMsgActionData));
                            intent.putExtra("from", "from_aio");
                            context.startActivity(intent);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    } else {
                        StructMsgItemVideo structMsgItemVideo = StructMsgItemVideo.this;
                        if (structMsgItemVideo.f290495j1 == 4) {
                            AbsStructMsg absStructMsg3 = structMsgItemVideo.P0;
                            if (absStructMsg3 == null || (messageRecord = absStructMsg3.message) == null) {
                                str = "";
                            } else {
                                str = messageRecord.getExtInfoFromExtStr(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID);
                            }
                            String str5 = (String) view.getTag(R.id.j59);
                            if (!TextUtils.isEmpty(str5)) {
                                String addParameter = URLUtil.addParameter(URLUtil.addParameter(str5, "progress", String.valueOf(0L)), "msgId", str);
                                Intent intent2 = new Intent(context, (Class<?>) QQBrowserActivity.class);
                                intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                                String str6 = null;
                                try {
                                    absStructMsg = StructMsgItemVideo.this.P0;
                                } catch (Exception unused) {
                                }
                                if (absStructMsg != null) {
                                    String extInfoFromExtStr = absStructMsg.message.getExtInfoFromExtStr("gdt_view_id");
                                    try {
                                        String extInfoFromExtStr2 = StructMsgItemVideo.this.P0.message.getExtInfoFromExtStr("gdt_msgImp");
                                        if (TextUtils.isEmpty(extInfoFromExtStr2)) {
                                            jSONObject = new JSONObject();
                                        } else {
                                            jSONObject = new JSONObject(extInfoFromExtStr2);
                                        }
                                        str3 = jSONObject.optString("ad_id");
                                        try {
                                            str6 = jSONObject.optString("key");
                                            Long.parseLong(str3);
                                        } catch (Exception unused2) {
                                        }
                                        str2 = str6;
                                        str6 = extInfoFromExtStr;
                                    } catch (Exception unused3) {
                                        str3 = null;
                                        str6 = extInfoFromExtStr;
                                        str2 = null;
                                    }
                                    if (str6 != null) {
                                        str6 = str6.replace("\"", "").replace("\n", "");
                                    }
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(addParameter);
                                    if (!addParameter.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                                        str4 = "&view_id=";
                                    } else {
                                        str4 = "?view_id=";
                                    }
                                    sb5.append(str4);
                                    sb5.append(String.valueOf(str6));
                                    sb5.append("&ad_id=");
                                    sb5.append(String.valueOf(str3));
                                    sb5.append("&trace_id=");
                                    sb5.append(String.valueOf(str2));
                                    intent2.putExtra("url", sb5.toString());
                                    intent2.putExtra("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(StructMsgItemVideo.this.M0));
                                    context.startActivity(intent2);
                                }
                                str2 = null;
                                str3 = null;
                                if (str6 != null) {
                                }
                                StringBuilder sb52 = new StringBuilder();
                                sb52.append(addParameter);
                                if (!addParameter.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                                }
                                sb52.append(str4);
                                sb52.append(String.valueOf(str6));
                                sb52.append("&ad_id=");
                                sb52.append(String.valueOf(str3));
                                sb52.append("&trace_id=");
                                sb52.append(String.valueOf(str2));
                                intent2.putExtra("url", sb52.toString());
                                intent2.putExtra("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(StructMsgItemVideo.this.M0));
                                context.startActivity(intent2);
                            }
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d extends com.tencent.mobileqq.urldrawable.a {
        static IPatchRedirector $redirector_;
        private int A;
        private int B;
        private int C;

        public d(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, StructMsgItemVideo.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.A = i3;
            this.B = i16;
            this.C = i17;
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            int width = this.C * bitmap.getWidth();
            if (bitmap.getHeight() != 0) {
                i3 = bitmap.getHeight();
            } else {
                i3 = this.C;
            }
            return BaseImageUtil.getRoundedCornerBitmap2(bitmap, this.A, width / i3, this.C);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public PAVideoView f290521a;

        /* renamed from: b, reason: collision with root package name */
        public View f290522b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f290523c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f290524d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f290525e;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class f extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<StructMsgItemVideo> f290526a;

        public f(StructMsgItemVideo structMsgItemVideo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) structMsgItemVideo);
            } else {
                this.f290526a = null;
                this.f290526a = new WeakReference<>(structMsgItemVideo);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (this.f290526a.get() != null) {
                ((AnyScaleTypeImageView) ((View) message.obj)).setImageResource(R.drawable.exv);
            }
        }
    }

    public StructMsgItemVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.R0 = null;
        this.S0 = null;
        this.T0 = 0;
        this.U0 = null;
        this.V0 = false;
        this.W0 = null;
        this.X0 = null;
        this.Y0 = null;
        this.Z0 = 0;
        this.f290486a1 = 0;
        this.f290487b1 = 0;
        this.f290488c1 = 0;
        this.f290489d1 = 0;
        this.f290495j1 = 0;
        this.f290497l1 = "";
        this.f290498m1 = "";
        this.f290499n1 = "";
        this.f290500o1 = "";
        this.f290501p1 = false;
        this.f290502q1 = true;
        this.f290504s1 = false;
        this.f290508w1 = "";
        this.f290509x1 = new a();
        this.f290510y1 = new b();
        this.f290511z1 = new c();
        this.f290322e = "video";
        this.f290320d = 18;
    }

    private static boolean q(Context context, int i3) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("file_send_path", str);
        bundle.putInt(ShortVideoConstants.VIDEO_PLAY_CALLER, 1);
        bundle.putLong(ShortVideoConstants.MESSAGE_CLICK_START, System.currentTimeMillis());
        Intent intent = new Intent(context, (Class<?>) ShortVideoPlayActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
        if (!TextUtils.isEmpty(u())) {
            String b16 = com.tencent.mobileqq.structmsg.d.b(u());
            if (!TextUtils.isEmpty(b16)) {
                ReportController.o(null, "CliOper", "", "", "0X8005F57", "0X8005F57", 0, 0, "", "", b16, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Context context) {
        if (!TextUtils.isEmpty(u())) {
            if (u().startsWith("http://") || u().startsWith("https://")) {
                Intent intent = new Intent();
                intent.putExtra("key_isReadModeEnabled", true);
                intent.putExtra("url", u());
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(intent, u());
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPublicAccountBrowser.ROUTE_NAME);
                activityURIRequest.extra().putAll(intent.getExtras());
                QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
                if (!TextUtils.isEmpty(u())) {
                    String b16 = com.tencent.mobileqq.structmsg.d.b(u());
                    if (!TextUtils.isEmpty(b16)) {
                        ReportController.o(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", b16, "");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u() {
        return this.P0.mMsgUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Context context, View view) {
        if (this.T0 == 1) {
            if (view instanceof AnyScaleTypeImageView) {
                ((AnyScaleTypeImageView) view).setImageResource(R.drawable.common_loading2);
            }
            if (this.U0 == null) {
                this.U0 = new f(this);
            }
            ThreadManagerV2.post(new Runnable(context, view) { // from class: com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f290512d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f290513e;

                {
                    this.f290512d = context;
                    this.f290513e = view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, StructMsgItemVideo.this, context, view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Context context2 = this.f290512d;
                    StructMsgItemVideo structMsgItemVideo = StructMsgItemVideo.this;
                    String c16 = com.tencent.mobileqq.structmsg.d.c(context2, structMsgItemVideo.M0, structMsgItemVideo.u());
                    StructMsgItemVideo.this.U0.obtainMessage().obj = this.f290513e;
                    if (!TextUtils.isEmpty(c16)) {
                        StructMsgItemVideo.this.s(this.f290512d, c16);
                    } else {
                        StructMsgItemVideo.this.t(this.f290512d);
                    }
                }
            }, 8, null, true);
            return;
        }
        s(context, this.S0);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        Bundle bundle2;
        int f16;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, context, view, bundle);
        }
        if (this.P0 == null) {
            return null;
        }
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (v()) {
            bundle2.putBoolean("is_public_account_video_msg", true);
            this.V0 = true;
            this.f290496k1 = bundle2.getString("public_account_video_title");
        }
        boolean z16 = !this.P0.hasFlag(4);
        if (!this.V0) {
            return r(context, view, bundle2);
        }
        if (this.P0 instanceof StructMsgForGeneralShare) {
            if (bundle2.getString("VIDEO_PUB_ACCOUNT_UIN") != null) {
                this.f290490e1 = bundle2.getString("VIDEO_PUB_ACCOUNT_UIN");
            } else {
                this.f290490e1 = String.valueOf(((StructMsgForGeneralShare) this.P0).source_puin);
            }
            if (bundle2.getString("VIDEO_PUB_ACCOUNT_NAME") != null) {
                this.f290491f1 = bundle2.getString("VIDEO_PUB_ACCOUNT_NAME");
            } else {
                this.f290491f1 = String.valueOf(((StructMsgForGeneralShare) this.P0).mSourceName);
            }
            AbsStructMsg absStructMsg = this.P0;
            this.f290497l1 = ((StructMsgForGeneralShare) absStructMsg).mSourceIcon;
            this.f290498m1 = ((StructMsgForGeneralShare) absStructMsg).mSourceName;
            this.f290499n1 = ((StructMsgForGeneralShare) absStructMsg).mSourceUrl;
            this.f290500o1 = ((StructMsgForGeneralShare) absStructMsg).mSourceThirdName;
        }
        Resources resources = context.getResources();
        if (view != null && (view instanceof RelativeLayout)) {
            if (view.getTag(R.id.f166926j53) != null) {
                Object tag = view.getTag(R.id.f166926j53);
                if (tag instanceof e) {
                    if (QLog.isColorLevel()) {
                        QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): \u590d\u7528Holder!!");
                    }
                }
            }
            return null;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        PAVideoView pAVideoView = new PAVideoView(context);
        pAVideoView.setId(R.id.f166926j53);
        pAVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        pAVideoView.setContentDescription(resources.getText(R.string.hqr));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (z16) {
            pAVideoView.setRadius(15.0f);
            pAVideoView.l(true);
            pAVideoView.m(true);
            MessageRecord messageRecord = this.P0.message;
            if (messageRecord != null) {
                pAVideoView.f315457g0 = messageRecord.isSend();
            }
            int i17 = this.f290487b1;
            int i18 = this.f290488c1;
            if (i17 >= i18) {
                pAVideoView.f315946x0 = PAVideoView.R0;
                pAVideoView.f315948z0 = true;
                pAVideoView.A0 = true;
            } else {
                pAVideoView.A0 = false;
                pAVideoView.f315948z0 = false;
                int[] adjustSize = ShortVideoUtils.adjustSize(i17, i18);
                layoutParams.width = adjustSize[0];
                layoutParams.height = adjustSize[1];
            }
        } else {
            if (!this.f290502q1) {
                pAVideoView.setRadiusTop(5.0f);
            } else {
                pAVideoView.setRadius(5.0f);
            }
            pAVideoView.A0 = true;
            pAVideoView.f315948z0 = false;
            pAVideoView.l(true);
            pAVideoView.m(false);
            int i19 = this.f290487b1;
            int i26 = this.f290488c1;
            if (i19 < i26) {
                pAVideoView.f315946x0 = PAVideoView.Q0;
            } else if (i19 > i26) {
                pAVideoView.f315946x0 = PAVideoView.P0;
            } else if (i19 == i26 && i19 != 0 && i26 != 0) {
                if (z16) {
                    pAVideoView.f315946x0 = PAVideoView.R0;
                } else {
                    pAVideoView.f315946x0 = PAVideoView.Q0;
                }
            } else {
                pAVideoView.f315946x0 = PAVideoView.P0;
            }
        }
        relativeLayout.addView(pAVideoView, layoutParams);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.duf);
        imageView.setVisibility(8);
        int f17 = BaseAIOUtils.f(62.0f, resources);
        if (z16) {
            f17 = BaseAIOUtils.f(50.0f, resources);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(f17, f17);
        layoutParams2.addRule(13);
        if (z16) {
            int f18 = BaseAIOUtils.f(10.0f, resources) / 2;
            if (pAVideoView.f315457g0) {
                layoutParams2.rightMargin = f18;
            } else {
                layoutParams2.leftMargin = f18;
            }
        }
        relativeLayout.addView(imageView, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setHorizontalGravity(0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, R.id.f166926j53);
        layoutParams3.addRule(7, R.id.f166926j53);
        layoutParams3.addRule(8, R.id.f166926j53);
        if (z16) {
            f16 = BaseAIOUtils.f(7.0f, resources);
        } else {
            f16 = BaseAIOUtils.f(12.0f, resources);
        }
        int i27 = f16;
        if (z16) {
            MessageRecord messageRecord2 = this.P0.message;
            if (messageRecord2 != null && messageRecord2.isSend()) {
                i3 = BaseAIOUtils.f(10.0f, resources) + i27;
                i16 = i27;
            } else {
                i16 = BaseAIOUtils.f(10.0f, resources) + i27;
                i3 = i27;
            }
        } else {
            i3 = i27;
            i16 = i3;
        }
        linearLayout.setPadding(i16, i27, i3, i27);
        relativeLayout.addView(linearLayout, layoutParams3);
        TextView textView = new TextView(context);
        textView.setId(R.id.f166925j52);
        textView.setTextColor(-1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        if (z16) {
            textView.setTextSize(1, 14.0f);
        } else {
            textView.setTextSize(1, 19.0f);
        }
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.rightMargin = BaseAIOUtils.f(7.0f, resources);
        linearLayout.addView(textView, layoutParams4);
        TextView textView2 = new TextView(context);
        textView2.setSingleLine(true);
        if (z16) {
            textView2.setTextSize(1, 12.0f);
        } else {
            textView2.setTextSize(1, 14.0f);
        }
        textView2.setTextColor(-1);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 85;
        layoutParams5.weight = 0.0f;
        linearLayout.addView(textView2, layoutParams5);
        e eVar = new e();
        eVar.f290521a = pAVideoView;
        eVar.f290523c = textView;
        eVar.f290524d = imageView;
        eVar.f290525e = textView2;
        eVar.f290522b = linearLayout;
        relativeLayout.setTag(R.id.f166926j53, eVar);
        relativeLayout.setTag(this);
        eVar.f290521a.p(this, eVar);
        boolean q16 = q(context, this.P0.uinType);
        if (QLog.isColorLevel()) {
            QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): convertView=" + relativeLayout + ", args = " + bundle2.toString() + "\n, hasHeadIcon = " + z16 + ", uniseq=" + this.P0.uniseq + "\n, autoPlay = " + q16 + ", vid = " + this.W0);
        }
        eVar.f290521a.r();
        if (this.f290486a1 > 0) {
            eVar.f290525e.setText(ShortVideoUtils.stringForTime(r0 * 1000));
        }
        if (!TextUtils.isEmpty(this.f290503r1)) {
            relativeLayout.setTag(R.id.j59, this.f290503r1);
        }
        relativeLayout.setOnClickListener(this.f290511z1);
        WeakReference<com.tencent.mobileqq.activity.aio.an> weakReference = this.O0;
        if (weakReference != null) {
            relativeLayout.setOnLongClickListener(weakReference.get());
            relativeLayout.setOnTouchListener(this.O0.get());
        }
        if (this.P0.message != null && !com.tencent.mobileqq.utils.b.a().b(this.P0.message, "0X800B375")) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800B375", "0X800B375", 0, 0, "", "", "", ((IVideoR5BuilderFactory) QRoute.api(IVideoR5BuilderFactory.class)).create(null, null, this.W0, this.f290492g1).c(this.f290492g1).b(q16).a(), false);
            com.tencent.mobileqq.utils.b.a().c(this.P0.message, "0X800B375");
        }
        return relativeLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        com.tencent.mobileqq.structmsg.j jVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        this.R0 = jVar.a("cover");
        this.S0 = jVar.a("src");
        String a16 = jVar.a("load");
        this.W0 = jVar.a("vInfo");
        this.X0 = jVar.a("tInfo");
        String a17 = jVar.a("preTime");
        if (a17 != null) {
            try {
                try {
                    this.f290486a1 = Integer.valueOf(a17).intValue();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                this.f290486a1 = (int) Float.valueOf(a17).floatValue();
                if (QLog.isColorLevel()) {
                    QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewVideoTimeStr: previewVideoTime = " + this.f290486a1);
                }
            }
        }
        String a18 = jVar.a("preWidth");
        if (a18 != null) {
            try {
                this.f290487b1 = Integer.valueOf(a18).intValue();
            } catch (Exception unused3) {
            }
        }
        String a19 = jVar.a("preHeight");
        if (a19 != null) {
            try {
                this.f290488c1 = Integer.valueOf(a19).intValue();
            } catch (Exception unused4) {
            }
        }
        String a26 = jVar.a("fullTime");
        if (a26 != null) {
            try {
                this.f290489d1 = Integer.valueOf(a26).intValue();
            } catch (Exception unused5) {
            }
        }
        this.Y0 = jVar.a("summary");
        if (!TextUtils.isEmpty(a16)) {
            try {
                this.T0 = Integer.parseInt(a16);
            } catch (RuntimeException unused6) {
                this.T0 = 0;
            }
        }
        String a27 = jVar.a(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY);
        if (!TextUtils.isEmpty(a27)) {
            try {
                this.f290495j1 = Integer.parseInt(a27);
            } catch (Exception unused7) {
            }
        }
        this.f290492g1 = jVar.a("aID");
        this.f290503r1 = jVar.a(WadlProxyConsts.KEY_JUMP_URL);
        this.f290504s1 = "1".equals(jVar.a("isJump2Web"));
        String a28 = jVar.a("preStartPosi");
        if (!TextUtils.isEmpty(a28)) {
            try {
                try {
                    this.Z0 = Integer.valueOf(a28).intValue();
                } catch (Exception unused8) {
                    this.Z0 = (int) Float.valueOf(a28).floatValue();
                    if (QLog.isColorLevel()) {
                        QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewStartPosiStr: previewStartPosi = " + this.Z0);
                    }
                }
            } catch (Exception unused9) {
            }
        }
        this.f290505t1 = jVar.a("apurl");
        this.f290506u1 = jVar.a("rl");
        this.f290507v1 = jVar.a("disType");
        String a29 = jVar.a("feedId");
        if (!TextUtils.isEmpty(a29)) {
            try {
                this.f290494i1 = Long.parseLong(a29);
            } catch (Exception unused10) {
                if (QLog.isColorLevel()) {
                    QLog.d("structmsg.StructMsgItemVideo", 2, "error while feedIdStr to feedId Long!");
                }
            }
        }
        String a36 = jVar.a("feedType");
        if (!TextUtils.isEmpty(a36)) {
            try {
                this.f290493h1 = Integer.parseInt(a36);
            } catch (Exception unused11) {
                if (QLog.isColorLevel()) {
                    QLog.d("structmsg.StructMsgItemVideo", 2, "error while parse feedTypeStr to feedType int!");
                }
            }
        }
        if (this.f290320d >= 13) {
            String a37 = jVar.a("action_type");
            if (!TextUtils.isEmpty(a37)) {
                try {
                    this.Q = Integer.parseInt(a37);
                } catch (NumberFormatException unused12) {
                    this.Q = 0;
                }
            }
            String a38 = jVar.a("dest_type");
            if (!TextUtils.isEmpty(a38)) {
                try {
                    this.W = Integer.parseInt(a38);
                } catch (NumberFormatException unused13) {
                    this.W = 0;
                }
            }
            String a39 = jVar.a("product_type");
            if (!TextUtils.isEmpty(a39)) {
                try {
                    this.f290319c0 = Integer.parseInt(a39);
                } catch (NumberFormatException unused14) {
                    this.f290319c0 = 0;
                }
            }
            this.R = jVar.a("advertiser_id");
            this.S = jVar.a("aid");
            this.T = jVar.a("app_download_schema");
            this.U = jVar.a("canvas_json");
            this.V = jVar.a("customized_invoke_url");
            this.X = jVar.a("effect_url");
            this.Y = jVar.a("landing_page");
            this.Z = jVar.a("landing_page_report_url");
            this.f290317a0 = jVar.a("noco_id");
            this.f290318b0 = jVar.a(ReportDataBuilder.KEY_PRODUCT_ID);
            this.f290323e0 = jVar.a("subordinate_product_id");
            this.f290325f0 = jVar.a("traceid");
            this.f290326g0 = jVar.a("via");
            this.f290328h0 = jVar.a("video_url");
            this.f290330i0 = jVar.a("appname");
            this.f290331j0 = jVar.a("customized_invoke_url");
            this.f290332k0 = jVar.a("pkg_name");
            this.f290333l0 = jVar.a("pkgurl");
            this.f290321d0 = jVar.a("rl");
            this.P = jVar.a("apurl");
            this.f290339q0 = jVar.a("corporate_image_name");
            this.f290340r0 = jVar.a("corporate_logo");
        }
        if (this.f290320d >= 14) {
            String a46 = jVar.a(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE);
            if (!TextUtils.isEmpty(a46)) {
                try {
                    this.f290335m0 = Integer.parseInt(a46);
                } catch (NumberFormatException unused15) {
                    this.f290335m0 = 0;
                }
            }
        }
        com.tencent.mobileqq.structmsg.j jVar3 = jVar.f290431e;
        if (jVar3 != null && (jVar2 = jVar3.f290431e) != null) {
            if (this.f290320d >= 15) {
                String a47 = jVar2.a(com.qzone.widget.u.COLUMN_TAB_ID);
                if (!StringUtil.isEmpty(a47)) {
                    try {
                        this.f290341s0 = Integer.parseInt(a47);
                    } catch (NumberFormatException unused16) {
                        this.f290341s0 = 0;
                    }
                }
                String a48 = jVar2.a("is_hidden");
                if (!StringUtil.isEmpty(a48)) {
                    try {
                        this.f290342t0 = Integer.parseInt(a48);
                    } catch (NumberFormatException unused17) {
                        this.f290342t0 = 0;
                    }
                }
            }
            if (this.f290320d >= 16) {
                this.f290343u0 = jVar2.a(Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO);
                this.f290344v0 = jVar2.a("sdk_exposure_monitor_url");
                this.f290345w0 = jVar2.a("sdk_click_monitor_url");
                String a49 = jVar2.a("media_duration");
                if (!StringUtil.isEmpty(a49)) {
                    try {
                        this.f290346x0 = Integer.parseInt(a49);
                    } catch (NumberFormatException unused18) {
                        this.f290346x0 = 0;
                    }
                }
                String a56 = jVar2.a("video_file_size");
                if (!StringUtil.isEmpty(a56)) {
                    try {
                        this.f290347y0 = Integer.parseInt(a56);
                    } catch (NumberFormatException unused19) {
                        this.f290347y0 = 0;
                    }
                }
                String a57 = jVar2.a("app_score_num");
                if (!StringUtil.isEmpty(a57)) {
                    try {
                        this.f290348z0 = Integer.parseInt(a57);
                    } catch (NumberFormatException unused20) {
                        this.f290348z0 = 0;
                    }
                }
                String a58 = jVar2.a("download_num");
                if (!StringUtil.isEmpty(a58)) {
                    try {
                        this.A0 = Integer.parseInt(a58);
                    } catch (NumberFormatException unused21) {
                        this.A0 = 0;
                    }
                }
                this.B0 = jVar2.a("universal_link");
                this.C0 = jVar2.a("sdk_data");
                this.D0 = jVar2.a("tencent_video_id");
                this.E0 = jVar2.a("view_id");
            }
            if (this.f290320d >= 17) {
                this.F0 = jVar2.a("qgg_ext");
            }
            if (this.f290320d >= 18) {
                this.G0 = jVar2.a("adInfo");
                this.H0 = jVar2.a("is_report_click");
            }
        }
        if (this.f290320d >= 18) {
            this.f290508w1 = jVar.a("noAutoPlay");
        }
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "video";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.R0 = objectInput.readUTF();
        this.S0 = objectInput.readUTF();
        String readUTF = objectInput.readUTF();
        if (!TextUtils.isEmpty(readUTF)) {
            try {
                this.T0 = Integer.parseInt(readUTF);
            } catch (RuntimeException unused) {
                this.T0 = 0;
            }
        }
        if (this.f290320d >= 7) {
            this.W0 = objectInput.readUTF();
            this.X0 = objectInput.readUTF();
            this.f290486a1 = objectInput.readInt();
            this.f290487b1 = objectInput.readInt();
            this.f290488c1 = objectInput.readInt();
            this.f290489d1 = objectInput.readInt();
            this.Y0 = objectInput.readUTF();
            this.f290495j1 = objectInput.readInt();
        }
        if (this.f290320d >= 8) {
            this.f290492g1 = objectInput.readUTF();
        }
        if (this.f290320d >= 9) {
            this.f290503r1 = objectInput.readUTF();
            this.f290504s1 = "1".equals(objectInput.readUTF());
        }
        if (this.f290320d >= 10) {
            this.Z0 = objectInput.readInt();
        }
        if (this.f290320d >= 11) {
            this.f290505t1 = objectInput.readUTF();
            this.f290506u1 = objectInput.readUTF();
            this.f290507v1 = objectInput.readUTF();
        }
        if (this.f290320d >= 12 && w()) {
            this.f290493h1 = objectInput.readInt();
            this.f290494i1 = objectInput.readLong();
        }
        if (this.f290320d >= 13) {
            this.P = objectInput.readUTF();
            this.f290321d0 = objectInput.readUTF();
            this.Q = objectInput.readInt();
            this.R = objectInput.readUTF();
            this.S = objectInput.readUTF();
            this.T = objectInput.readUTF();
            this.U = objectInput.readUTF();
            this.V = objectInput.readUTF();
            this.W = objectInput.readInt();
            this.X = objectInput.readUTF();
            this.Y = objectInput.readUTF();
            this.Z = objectInput.readUTF();
            this.f290317a0 = objectInput.readUTF();
            this.f290318b0 = objectInput.readUTF();
            this.f290319c0 = objectInput.readInt();
            this.f290323e0 = objectInput.readUTF();
            this.f290325f0 = objectInput.readUTF();
            this.f290326g0 = objectInput.readUTF();
            this.f290328h0 = objectInput.readUTF();
            this.f290330i0 = objectInput.readUTF();
            this.f290331j0 = objectInput.readUTF();
            this.f290332k0 = objectInput.readUTF();
            this.f290333l0 = objectInput.readUTF();
            this.f290339q0 = objectInput.readUTF();
            this.f290340r0 = objectInput.readUTF();
        }
        if (this.f290320d >= 14) {
            this.f290335m0 = objectInput.readInt();
        }
        if (this.f290320d >= 15) {
            this.f290341s0 = objectInput.readInt();
            this.f290342t0 = objectInput.readInt();
        }
        if (this.f290320d >= 16) {
            this.f290343u0 = objectInput.readUTF();
            this.f290344v0 = objectInput.readUTF();
            this.f290345w0 = objectInput.readUTF();
            this.f290346x0 = objectInput.readInt();
            this.f290347y0 = objectInput.readInt();
            this.f290348z0 = objectInput.readInt();
            this.A0 = objectInput.readInt();
            this.B0 = objectInput.readUTF();
            this.C0 = objectInput.readUTF();
            this.D0 = objectInput.readUTF();
            this.E0 = objectInput.readUTF();
        }
        if (this.f290320d >= 17) {
            this.F0 = objectInput.readUTF();
        }
        if (this.f290320d >= 18) {
            this.G0 = objectInput.readUTF();
            this.H0 = objectInput.readUTF();
            this.f290508w1 = objectInput.readUTF();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("readExternal[:");
            sb5.append("\n");
            sb5.append("mVersion:");
            sb5.append(this.f290320d);
            sb5.append("\n");
            sb5.append("imgUrl:");
            sb5.append(this.R0);
            sb5.append("\n");
            sb5.append("videoUrl:");
            sb5.append(this.S0);
            sb5.append("\n");
            sb5.append("vInfo:");
            sb5.append(this.W0);
            sb5.append("\n");
            sb5.append("tInfo:");
            sb5.append(this.X0);
            sb5.append("\n");
            sb5.append("previewVideoTime:");
            sb5.append(this.f290486a1);
            sb5.append("\n");
            sb5.append("previewVideoWidth:");
            sb5.append(this.f290487b1);
            sb5.append("\n");
            sb5.append("previewVideoHeight:");
            sb5.append(this.f290488c1);
            sb5.append("\n");
            sb5.append("type:");
            sb5.append(this.f290495j1);
            sb5.append("\n");
            sb5.append("articleID:");
            sb5.append(this.f290492g1);
            sb5.append("\n");
            sb5.append("jumpUrl:");
            sb5.append(this.f290503r1);
            sb5.append("\n");
            sb5.append("jump2Web:");
            sb5.append(this.f290504s1);
            sb5.append("\n");
            sb5.append("previewStartPosi:");
            sb5.append(this.Z0);
            sb5.append("\n");
            if (this.f290320d >= 12 && w()) {
                sb5.append("feedId:");
                sb5.append(this.f290494i1);
                sb5.append("\n");
                sb5.append("feedType:");
                sb5.append(this.f290493h1);
                sb5.append("\n");
            }
            sb5.append("]:");
            sb5.append("\n");
            QLog.d("structmsg.StructMsgItemVideo", 2, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "video");
        if (!TextUtils.isEmpty(this.R0)) {
            xmlSerializer.attribute(null, "cover", this.R0);
        }
        if (!TextUtils.isEmpty(this.S0)) {
            xmlSerializer.attribute(null, "src", this.S0);
        }
        if (!TextUtils.isEmpty(this.W0)) {
            xmlSerializer.attribute(null, "vInfo", this.W0);
        }
        if (!TextUtils.isEmpty(this.X0)) {
            xmlSerializer.attribute(null, "tInfo", this.X0);
        }
        xmlSerializer.attribute(null, "preStartPosi", String.valueOf(this.Z0));
        xmlSerializer.attribute(null, "preTime", String.valueOf(this.f290486a1));
        xmlSerializer.attribute(null, "preWidth", String.valueOf(this.f290487b1));
        xmlSerializer.attribute(null, "preHeight", String.valueOf(this.f290488c1));
        xmlSerializer.attribute(null, "fullTime", String.valueOf(this.f290489d1));
        if (!TextUtils.isEmpty(this.Y0)) {
            xmlSerializer.attribute(null, "summary", this.Y0);
        }
        xmlSerializer.attribute(null, IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, String.valueOf(this.f290495j1));
        if (!TextUtils.isEmpty(this.f290492g1)) {
            xmlSerializer.attribute(null, "aID", this.f290492g1);
        }
        if (this.T0 == 1) {
            xmlSerializer.attribute(null, "load", this.T0 + "");
        }
        if (!TextUtils.isEmpty(this.f290503r1)) {
            xmlSerializer.attribute(null, WadlProxyConsts.KEY_JUMP_URL, this.f290503r1);
        }
        if (this.f290504s1) {
            str = "1";
        } else {
            str = "0";
        }
        xmlSerializer.attribute(null, "isJump2Web", str);
        if (!TextUtils.isEmpty(this.f290505t1)) {
            xmlSerializer.attribute(null, "apurl", this.f290505t1);
        }
        if (!TextUtils.isEmpty(this.f290506u1)) {
            xmlSerializer.attribute(null, "rl", this.f290506u1);
        }
        if (!TextUtils.isEmpty(this.f290507v1)) {
            xmlSerializer.attribute(null, "disType", this.f290507v1);
        }
        long j3 = this.f290494i1;
        if (j3 != 0) {
            xmlSerializer.attribute(null, "feedId", String.valueOf(j3));
        }
        int i3 = this.f290493h1;
        if (i3 != 0) {
            xmlSerializer.attribute(null, "feedType", String.valueOf(i3));
        }
        int i16 = this.Q;
        if (i16 != 0) {
            xmlSerializer.attribute(null, "action_type", String.valueOf(i16));
        }
        if (!TextUtils.isEmpty(this.R)) {
            xmlSerializer.attribute(null, "advertiser_id", this.R);
        }
        if (!TextUtils.isEmpty(this.S)) {
            xmlSerializer.attribute(null, "aid", this.S);
        }
        if (!TextUtils.isEmpty(this.T)) {
            xmlSerializer.attribute(null, "app_download_schema", this.T);
        }
        if (!TextUtils.isEmpty(this.U)) {
            xmlSerializer.attribute(null, "canvas_json", this.U);
        }
        if (!TextUtils.isEmpty(this.V)) {
            xmlSerializer.attribute(null, "customized_invoke_url", this.V);
        }
        int i17 = this.W;
        if (i17 != 0) {
            xmlSerializer.attribute(null, "dest_type", String.valueOf(i17));
        }
        if (!TextUtils.isEmpty(this.X)) {
            xmlSerializer.attribute(null, "effect_url", this.X);
        }
        if (!TextUtils.isEmpty(this.Y)) {
            xmlSerializer.attribute(null, "landing_page", this.Y);
        }
        if (!TextUtils.isEmpty(this.Z)) {
            xmlSerializer.attribute(null, "landing_page_report_url", this.Z);
        }
        if (!TextUtils.isEmpty(this.f290317a0)) {
            xmlSerializer.attribute(null, "noco_id", this.f290317a0);
        }
        if (!TextUtils.isEmpty(this.f290318b0)) {
            xmlSerializer.attribute(null, ReportDataBuilder.KEY_PRODUCT_ID, this.f290318b0);
        }
        if (!TextUtils.isEmpty(this.P)) {
            xmlSerializer.attribute(null, "apurl", this.P);
        }
        int i18 = this.f290319c0;
        if (i18 != 0) {
            xmlSerializer.attribute(null, "product_type", String.valueOf(i18));
        }
        int i19 = this.f290335m0;
        if (i19 != 0) {
            xmlSerializer.attribute(null, MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE, String.valueOf(i19));
        }
        if (!TextUtils.isEmpty(this.f290321d0)) {
            xmlSerializer.attribute(null, "rl", this.f290321d0);
        }
        if (!TextUtils.isEmpty(this.f290323e0)) {
            xmlSerializer.attribute(null, "subordinate_product_id", this.f290323e0);
        }
        if (!TextUtils.isEmpty(this.f290325f0)) {
            xmlSerializer.attribute(null, "traceid", this.f290325f0);
        }
        if (!TextUtils.isEmpty(this.f290326g0)) {
            xmlSerializer.attribute(null, "via", this.f290326g0);
        }
        if (!TextUtils.isEmpty(this.f290328h0)) {
            xmlSerializer.attribute(null, "video_url", this.f290328h0);
        }
        if (!TextUtils.isEmpty(this.f290330i0)) {
            xmlSerializer.attribute(null, "appname", this.f290330i0);
        }
        if (!TextUtils.isEmpty(this.f290331j0)) {
            xmlSerializer.attribute(null, "customized_invoke_url", this.f290331j0);
        }
        if (!TextUtils.isEmpty(this.f290332k0)) {
            xmlSerializer.attribute(null, "pkg_name", this.f290332k0);
        }
        if (!TextUtils.isEmpty(this.f290333l0)) {
            xmlSerializer.attribute(null, "pkgurl", this.f290333l0);
        }
        if (!TextUtils.isEmpty(this.f290339q0)) {
            xmlSerializer.attribute(null, "corporate_image_name", this.f290339q0);
        }
        if (!TextUtils.isEmpty(this.f290340r0)) {
            xmlSerializer.attribute(null, "corporate_logo", this.f290340r0);
        }
        int i26 = this.f290341s0;
        if (i26 != 0) {
            xmlSerializer.attribute(null, com.qzone.widget.u.COLUMN_TAB_ID, String.valueOf(i26));
        }
        int i27 = this.f290342t0;
        if (i27 != 0) {
            xmlSerializer.attribute(null, com.qzone.widget.u.COLUMN_TAB_ID, String.valueOf(i27));
        }
        if (!TextUtils.isEmpty(this.f290343u0)) {
            xmlSerializer.attribute(null, Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO, this.f290343u0);
        }
        if (!TextUtils.isEmpty(this.f290344v0)) {
            xmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.f290344v0);
        }
        if (!TextUtils.isEmpty(this.f290345w0)) {
            xmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.f290345w0);
        }
        int i28 = this.f290346x0;
        if (i28 != 0) {
            xmlSerializer.attribute(null, "media_duration", String.valueOf(i28));
        }
        int i29 = this.f290347y0;
        if (i29 != 0) {
            xmlSerializer.attribute(null, "video_file_size", String.valueOf(i29));
        }
        int i36 = this.f290348z0;
        if (i36 != 0) {
            xmlSerializer.attribute(null, "app_score_num", String.valueOf(i36));
        }
        int i37 = this.A0;
        if (i37 != 0) {
            xmlSerializer.attribute(null, "download_num", String.valueOf(i37));
        }
        if (!TextUtils.isEmpty(this.B0)) {
            xmlSerializer.attribute(null, "universal_link", this.B0);
        }
        if (!TextUtils.isEmpty(this.C0)) {
            xmlSerializer.attribute(null, "sdk_data", this.C0);
        }
        if (!TextUtils.isEmpty(this.D0)) {
            xmlSerializer.attribute(null, "tencent_video_id", this.D0);
        }
        if (!TextUtils.isEmpty(this.E0)) {
            xmlSerializer.attribute(null, "view_id", this.E0);
        }
        if (!TextUtils.isEmpty(this.F0)) {
            xmlSerializer.attribute(null, "qgg_ext", this.F0);
        }
        if (!TextUtils.isEmpty(this.G0)) {
            xmlSerializer.attribute(null, "adInfo", this.G0);
        }
        if (!TextUtils.isEmpty(this.H0)) {
            xmlSerializer.attribute(null, "is_report_click", this.H0);
        }
        if (!TextUtils.isEmpty(this.f290508w1)) {
            xmlSerializer.attribute(null, "noAutoPlay", this.f290508w1);
        }
        xmlSerializer.endTag(null, "video");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        String str2 = this.R0;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        objectOutput.writeUTF(str2);
        String str4 = this.S0;
        if (str4 == null) {
            str4 = "";
        }
        objectOutput.writeUTF(str4);
        objectOutput.writeUTF(this.T0 + "");
        if (this.f290320d >= 7) {
            String str5 = this.W0;
            if (str5 == null) {
                str5 = "";
            }
            objectOutput.writeUTF(str5);
            String str6 = this.X0;
            if (str6 == null) {
                str6 = "";
            }
            objectOutput.writeUTF(str6);
            objectOutput.writeInt(this.f290486a1);
            objectOutput.writeInt(this.f290487b1);
            objectOutput.writeInt(this.f290488c1);
            objectOutput.writeInt(this.f290489d1);
            String str7 = this.Y0;
            if (str7 == null) {
                str7 = "";
            }
            objectOutput.writeUTF(str7);
            objectOutput.writeInt(this.f290495j1);
        }
        if (this.f290320d >= 8) {
            String str8 = this.f290492g1;
            if (str8 == null) {
                str8 = "";
            }
            objectOutput.writeUTF(str8);
        }
        String str9 = "0";
        if (this.f290320d >= 9) {
            String str10 = this.f290503r1;
            if (str10 == null) {
                str10 = "";
            }
            objectOutput.writeUTF(str10);
            if (!this.f290504s1) {
                str = "0";
            } else {
                str = "1";
            }
            objectOutput.writeUTF(str);
        }
        if (this.f290320d >= 10) {
            objectOutput.writeInt(this.Z0);
        }
        if (this.f290320d >= 11) {
            String str11 = this.f290505t1;
            if (str11 == null) {
                str11 = "";
            }
            objectOutput.writeUTF(str11);
            String str12 = this.f290506u1;
            if (str12 == null) {
                str12 = "";
            }
            objectOutput.writeUTF(str12);
            String str13 = this.f290507v1;
            if (str13 == null) {
                str13 = "";
            }
            objectOutput.writeUTF(str13);
        }
        if (this.f290320d >= 12 && w()) {
            objectOutput.writeInt(this.f290493h1);
            objectOutput.writeLong(this.f290494i1);
        }
        if (this.f290320d >= 13) {
            String str14 = this.P;
            if (str14 == null) {
                str14 = "";
            }
            objectOutput.writeUTF(str14);
            String str15 = this.f290321d0;
            if (str15 == null) {
                str15 = "";
            }
            objectOutput.writeUTF(str15);
            objectOutput.writeInt(this.Q);
            String str16 = this.R;
            if (str16 == null) {
                str16 = "0";
            }
            objectOutput.writeUTF(str16);
            String str17 = this.S;
            if (str17 != null) {
                str9 = str17;
            }
            objectOutput.writeUTF(str9);
            String str18 = this.T;
            if (str18 == null) {
                str18 = "";
            }
            objectOutput.writeUTF(str18);
            String str19 = this.U;
            if (str19 == null) {
                str19 = "";
            }
            objectOutput.writeUTF(str19);
            String str20 = this.V;
            if (str20 == null) {
                str20 = "";
            }
            objectOutput.writeUTF(str20);
            objectOutput.writeInt(this.W);
            String str21 = this.X;
            if (str21 == null) {
                str21 = "";
            }
            objectOutput.writeUTF(str21);
            String str22 = this.Y;
            if (str22 == null) {
                str22 = "";
            }
            objectOutput.writeUTF(str22);
            String str23 = this.Z;
            if (str23 == null) {
                str23 = "";
            }
            objectOutput.writeUTF(str23);
            String str24 = this.f290317a0;
            if (str24 == null) {
                str24 = "";
            }
            objectOutput.writeUTF(str24);
            String str25 = this.f290318b0;
            if (str25 == null) {
                str25 = "";
            }
            objectOutput.writeUTF(str25);
            objectOutput.writeInt(this.f290319c0);
            String str26 = this.f290323e0;
            if (str26 == null) {
                str26 = "";
            }
            objectOutput.writeUTF(str26);
            String str27 = this.f290325f0;
            if (str27 == null) {
                str27 = "";
            }
            objectOutput.writeUTF(str27);
            String str28 = this.f290326g0;
            if (str28 == null) {
                str28 = "";
            }
            objectOutput.writeUTF(str28);
            String str29 = this.f290328h0;
            if (str29 == null) {
                str29 = "";
            }
            objectOutput.writeUTF(str29);
            String str30 = this.f290330i0;
            if (str30 == null) {
                str30 = "";
            }
            objectOutput.writeUTF(str30);
            String str31 = this.f290331j0;
            if (str31 == null) {
                str31 = "";
            }
            objectOutput.writeUTF(str31);
            String str32 = this.f290332k0;
            if (str32 == null) {
                str32 = "";
            }
            objectOutput.writeUTF(str32);
            String str33 = this.f290333l0;
            if (str33 == null) {
                str33 = "";
            }
            objectOutput.writeUTF(str33);
            String str34 = this.f290339q0;
            if (str34 == null) {
                str34 = "";
            }
            objectOutput.writeUTF(str34);
            String str35 = this.f290340r0;
            if (str35 == null) {
                str35 = "";
            }
            objectOutput.writeUTF(str35);
        }
        if (this.f290320d >= 14) {
            objectOutput.writeInt(this.f290335m0);
        }
        if (this.f290320d >= 15) {
            objectOutput.writeInt(this.f290341s0);
            objectOutput.writeInt(this.f290342t0);
        }
        if (this.f290320d >= 16) {
            String str36 = this.f290343u0;
            if (str36 == null) {
                str36 = "";
            }
            objectOutput.writeUTF(str36);
            String str37 = this.f290344v0;
            if (str37 == null) {
                str37 = "";
            }
            objectOutput.writeUTF(str37);
            String str38 = this.f290345w0;
            if (str38 == null) {
                str38 = "";
            }
            objectOutput.writeUTF(str38);
            objectOutput.writeInt(this.f290346x0);
            objectOutput.writeInt(this.f290347y0);
            objectOutput.writeInt(this.f290348z0);
            objectOutput.writeInt(this.A0);
            String str39 = this.B0;
            if (str39 == null) {
                str39 = "";
            }
            objectOutput.writeUTF(str39);
            String str40 = this.C0;
            if (str40 == null) {
                str40 = "";
            }
            objectOutput.writeUTF(str40);
            String str41 = this.D0;
            if (str41 == null) {
                str41 = "";
            }
            objectOutput.writeUTF(str41);
            String str42 = this.E0;
            if (str42 == null) {
                str42 = "";
            }
            objectOutput.writeUTF(str42);
        }
        if (this.f290320d >= 17) {
            String str43 = this.F0;
            if (str43 == null) {
                str43 = "";
            }
            objectOutput.writeUTF(str43);
        }
        if (this.f290320d >= 18) {
            String str44 = this.G0;
            if (str44 == null) {
                str44 = "";
            }
            objectOutput.writeUTF(str44);
            String str45 = this.H0;
            if (str45 == null) {
                str45 = "";
            }
            objectOutput.writeUTF(str45);
            String str46 = this.f290508w1;
            if (str46 != null) {
                str3 = str46;
            }
            objectOutput.writeUTF(str3);
        }
    }

    protected View r(Context context, View view, Bundle bundle) {
        int i3;
        TitledImageView titledImageView;
        View view2;
        com.tencent.mobileqq.structmsg.f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        boolean z16 = false;
        if (bundle.getBoolean("has_cnr")) {
            i3 = BaseAIOUtils.f(URLDrawableHelper.getRoundCorner(), resources);
        } else {
            i3 = 0;
        }
        resources.getDisplayMetrics();
        int i16 = bundle.getInt(QCircleSchemeAttr.Detail.V_HEIGHT);
        if (view != null && (view instanceof TitledImageView)) {
            titledImageView = (TitledImageView) view;
            view2 = view;
        } else {
            TitledImageView titledImageView2 = new TitledImageView(context);
            titledImageView2.setId(R.id.dgb);
            titledImageView2.setContentDescription(resources.getString(R.string.cli));
            titledImageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            titledImageView2.setContentDescription(resources.getText(R.string.hqr));
            titledImageView = titledImageView2;
            view2 = titledImageView2;
        }
        titledImageView.setImageResource(R.drawable.exv);
        titledImageView.setTag(this);
        try {
            fVar = new com.tencent.mobileqq.structmsg.f(-16777216, i16, i16, i3);
        } catch (OutOfMemoryError unused) {
            fVar = null;
        }
        if (TextUtils.isEmpty(this.R0)) {
            titledImageView.setBackgroundDrawable(fVar);
        } else {
            try {
                URLDrawable drawable = URLDrawable.getDrawable(this.R0, i16, i16, fVar, fVar);
                if (drawable != null) {
                    if (bundle.getBoolean("has_cnr")) {
                        drawable.setDecodeHandler(new d(i3, i16, i16));
                    }
                    if (AbsDownloader.hasFile(this.R0) || !URLDrawableHelper.isMobileNetAndAutodownDisabled(context)) {
                        z16 = true;
                    }
                    drawable.setAutoDownload(z16);
                    if (drawable.getStatus() == 1) {
                        titledImageView.setBackgroundDrawable(drawable);
                    } else {
                        titledImageView.setURLDrawableDownListener(this.f290510y1);
                        titledImageView.setBackgroundDrawable(drawable);
                    }
                }
            } catch (Throwable unused2) {
                titledImageView.setBackgroundDrawable(fVar);
            }
        }
        WeakReference<com.tencent.mobileqq.activity.aio.an> weakReference = this.O0;
        if (weakReference != null) {
            titledImageView.setOnLongClickListener(weakReference.get());
            titledImageView.setOnTouchListener(this.O0.get());
        }
        titledImageView.setOnClickListener(this.f290509x1);
        titledImageView.setOnClickListener(this.f290509x1);
        WeakReference<com.tencent.mobileqq.activity.aio.an> weakReference2 = this.O0;
        if (weakReference2 != null) {
            titledImageView.setOnLongClickListener(weakReference2.get());
            titledImageView.setOnTouchListener(this.O0.get());
        }
        return view2;
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        int i3 = this.f290495j1;
        if (i3 >= 1 && i3 <= 100) {
            return true;
        }
        return false;
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.f290495j1 == 6) {
            return true;
        }
        return false;
    }

    public StructMsgItemVideo(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        this.R0 = null;
        this.S0 = null;
        this.T0 = 0;
        this.U0 = null;
        this.V0 = false;
        this.W0 = null;
        this.X0 = null;
        this.Y0 = null;
        this.Z0 = 0;
        this.f290486a1 = 0;
        this.f290487b1 = 0;
        this.f290488c1 = 0;
        this.f290489d1 = 0;
        this.f290495j1 = 0;
        this.f290497l1 = "";
        this.f290498m1 = "";
        this.f290499n1 = "";
        this.f290500o1 = "";
        this.f290501p1 = false;
        this.f290502q1 = true;
        this.f290504s1 = false;
        this.f290508w1 = "";
        this.f290509x1 = new a();
        this.f290510y1 = new b();
        this.f290511z1 = new c();
        this.f290322e = "video";
        this.R0 = str;
        this.S0 = str2;
        this.T0 = z16 ? 1 : 0;
        this.f290320d = 18;
    }

    public StructMsgItemVideo(String str, int i3, String str2, String str3, String str4, int i16, int i17, int i18, int i19, int i26, String str5, String str6, String str7, int i27, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2, str3, str4, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), str5, str6, str7, Integer.valueOf(i27), Long.valueOf(j3));
            return;
        }
        this.R0 = null;
        this.S0 = null;
        this.T0 = 0;
        this.U0 = null;
        this.V0 = false;
        this.W0 = null;
        this.X0 = null;
        this.Y0 = null;
        this.Z0 = 0;
        this.f290486a1 = 0;
        this.f290487b1 = 0;
        this.f290488c1 = 0;
        this.f290489d1 = 0;
        this.f290495j1 = 0;
        this.f290497l1 = "";
        this.f290498m1 = "";
        this.f290499n1 = "";
        this.f290500o1 = "";
        this.f290501p1 = false;
        this.f290502q1 = true;
        this.f290504s1 = false;
        this.f290508w1 = "";
        this.f290509x1 = new a();
        this.f290510y1 = new b();
        this.f290511z1 = new c();
        this.f290322e = "video";
        this.R0 = str;
        this.f290495j1 = i3;
        this.W0 = str2;
        this.X0 = str3;
        this.Y0 = str4;
        this.f290486a1 = i16;
        this.Z0 = i17;
        this.f290487b1 = i18;
        this.f290488c1 = i19;
        this.f290489d1 = i26;
        this.f290490e1 = str5;
        this.f290491f1 = str6;
        this.f290492g1 = str7;
        this.f290494i1 = j3;
        this.f290493h1 = i27;
        this.f290320d = 18;
    }
}
