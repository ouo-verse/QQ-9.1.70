package com.tencent.mobileqq.relationx.icebreaking;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.ao;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.event.EmotionPanelMsgIntent;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.emotion.stickerrecommended.g;
import com.tencent.qqnt.emotion.stickerrecommended.o;
import com.tencent.widget.CustomImgView;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AIOIceBreakView extends LinearLayout {
    static IPatchRedirector $redirector_;
    private RelativeLayout C;
    private TextView D;
    private TextView E;
    private b F;
    private int G;
    private int H;
    private String I;
    private boolean J;
    private View.OnClickListener K;
    private View.OnClickListener L;

    /* renamed from: d, reason: collision with root package name */
    private Context f280745d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f280746e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f280747f;

    /* renamed from: h, reason: collision with root package name */
    private CustomImgView f280748h;

    /* renamed from: i, reason: collision with root package name */
    private CustomImgView f280749i;

    /* renamed from: m, reason: collision with root package name */
    private CustomImgView f280750m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOIceBreakView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QLog.i("IceBreak.HotPic", 2, "onClick.");
                g gVar = (g) view.getTag();
                if (AIOIceBreakView.this.F != null) {
                    AIOIceBreakView.this.F.a(view);
                    IceBreakingMng.f280761g0 = true;
                    if (gVar instanceof o) {
                        AIOIceBreakView.this.i(view, "clck", (o) gVar, ((Integer) view.getTag(R.id.sif)).intValue());
                    }
                }
                if (view instanceof CustomImgView) {
                    URLImageView uRLImageView = (URLImageView) ((CustomImgView) view).f384543d;
                    if (uRLImageView.getDrawable() instanceof URLDrawable) {
                        if (((URLDrawable) uRLImageView.getDrawable()).getStatus() == 1) {
                            AIOIceBreakView.this.m(gVar);
                        } else if (QLog.isColorLevel()) {
                            QLog.e("IceBreak.HotPic", 2, "onClick:URLDrawable status != successed");
                        }
                    }
                }
                if (AIOIceBreakView.this.G >= 3) {
                    str = "2";
                } else {
                    str = "1";
                }
                int q16 = IceBreakingUtil.q(AIOIceBreakView.this.I, Integer.valueOf(AIOIceBreakView.this.H));
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", "0X800B577", "0X800B577", q16, 0, str, "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void a(View view);
    }

    public AIOIceBreakView(com.tencent.aio.api.runtime.a aVar) {
        super(aVar.c().getContext());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.G = 0;
        this.J = false;
        this.K = new View.OnClickListener() { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOIceBreakView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                int i3 = 2;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else if (AIOIceBreakView.this.f280746e != null) {
                    QLog.i("AIOIceBreakView", 2, ":OnClickMore");
                    view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AIOIceBreakView.this.f280746e.e().h(new EmotionPanelMsgIntent.SetEmotionPanelDefaultType(12));
                                AIOIceBreakView.this.f280746e.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("AIOIceBreakView", 1001));
                            }
                        }
                    }, 500L);
                    if (ao.c(AIOIceBreakView.this.H) != 1044) {
                        if (AIOIceBreakView.this.H == 0) {
                            i3 = 1;
                        }
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        int i16 = i3;
                        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X800A4CC", "0X800A4CC", i16, 0, "", "", "", "");
                        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X800A4CD", "0X800A4CD", i16, 0, "", "", "", "");
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.L = new a();
        this.f280745d = aVar.c().getContext();
        this.f280746e = aVar;
        this.H = IceBreakingUtil.p(Integer.valueOf(com.tencent.guild.aio.util.a.e(aVar.g()))).intValue();
        this.I = this.f280746e.g().r().c().j();
        l();
    }

    private void g(CustomImgView customImgView, g gVar, int i3) {
        o oVar;
        customImgView.setBackgroundDrawable(getResources().getDrawable(R.drawable.abu));
        if (gVar == null) {
            customImgView.setImageDrawable(this.f280747f);
            return;
        }
        URL protocolURL = gVar.getProtocolURL();
        if (protocolURL == null) {
            customImgView.setImageDrawable(this.f280747f);
            return;
        }
        URLDrawable uRLDrawable = gVar.getURLDrawable(protocolURL, k(gVar));
        boolean z16 = gVar instanceof o;
        if (z16) {
            customImgView.setContentDescription(((o) gVar).o());
        }
        customImgView.setTag(gVar);
        customImgView.setTag(R.id.sif, Integer.valueOf(i3));
        customImgView.setImageDrawable(uRLDrawable);
        customImgView.setOnClickListener(this.L);
        if (z16) {
            oVar = (o) gVar;
        } else {
            oVar = new o();
        }
        i(this, "imp", oVar, i3);
    }

    private void j(View view, String str, o oVar) {
        View view2;
        Fragment c16 = this.f280746e.c();
        if (c16 == null || (view2 = c16.getView()) == null) {
            return;
        }
        VideoReport.setPageId(view2, "pg_kl_new_chat_page");
        n(view2);
        HashMap hashMap = new HashMap(2);
        hashMap.put("kl_new_meme_id", oVar.o());
        hashMap.put("kl_new_meme_type", Integer.valueOf(oVar.p()));
        VideoReport.setElementId(view, "em_kl_new_chat_page_meme_btn");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementParams(view, hashMap);
        view.post(new Runnable(str, view, hashMap) { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f280756d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f280757e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Map f280758f;

            {
                this.f280756d = str;
                this.f280757e = view;
                this.f280758f = hashMap;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AIOIceBreakView.this, str, view, hashMap);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    VideoReport.reportEvent(this.f280756d, this.f280757e, this.f280758f);
                }
            }
        });
    }

    @NotNull
    private URLDrawable.URLDrawableOptions k(g gVar) {
        URLDrawable.URLDrawableOptions uRLDrawableOptions = gVar.getURLDrawableOptions();
        if (uRLDrawableOptions == null) {
            uRLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        }
        Drawable drawable = this.f280747f;
        uRLDrawableOptions.mLoadingDrawable = drawable;
        uRLDrawableOptions.mFailedDrawable = drawable;
        uRLDrawableOptions.mPlayGifImage = true;
        return uRLDrawableOptions;
    }

    private void l() {
        View inflate = LayoutInflater.from(this.f280745d).inflate(R.layout.c6g, this);
        TextView textView = (TextView) inflate.findViewById(R.id.mej);
        this.E = textView;
        textView.setOnClickListener(this.K);
        this.C = (RelativeLayout) inflate.findViewById(R.id.f113416qk);
        TextView textView2 = (TextView) inflate.findViewById(R.id.kfr);
        this.D = textView2;
        if (this.H == 1) {
            textView2.setText("\u4e0e\u5927\u5bb6\u6253\u4e2a\u62db\u547c\u5427 ");
        }
        this.f280748h = (CustomImgView) inflate.findViewById(R.id.llq);
        this.f280749i = (CustomImgView) inflate.findViewById(R.id.llr);
        this.f280750m = (CustomImgView) inflate.findViewById(R.id.lls);
        this.f280748h.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f280749i.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f280750m.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f280747f = getResources().getDrawable(R.drawable.f160231dr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(g gVar) {
        if (QLog.isColorLevel()) {
            QLog.d("IceBreak.HotPic", 2, "sendPic");
        }
        if (gVar == null) {
            return;
        }
        o oVar = (o) gVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            ((IStickerRecManager) ((QQAppInterface) peekAppRuntime).getRuntimeService(IStickerRecManager.class)).setCurrentText(oVar.o());
        }
        this.f280746e.e().h(new AIOMsgSendEvent.PicEmotionSendEvent(oVar.j(), 2, null, null));
    }

    private void n(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_to_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getFriendOpenId());
        VideoReport.setPageParams(view, new PageParams(hashMap));
    }

    public void h(List<g> list, int i3) {
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list, i3);
            return;
        }
        if (list != null && list.size() >= 3) {
            this.G = i3;
            g(this.f280748h, list.get(0), 1);
            g(this.f280749i, list.get(1), 2);
            g(this.f280750m, list.get(2), 3);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            int i17 = this.H;
            if (i17 != 1044) {
                if (i17 == 0) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
                ReportController.o(peekAppRuntime, "CliOper", "", "", "0X800A4CA", "0X800A4CA", i16, 0, "", "", "", "");
            }
            if (i3 >= 3) {
                str = "2";
            } else {
                str = "1";
            }
            ReportController.o(peekAppRuntime, "CliOper", "", "", "0X800B576", "0X800B576", IceBreakingUtil.q(this.I, Integer.valueOf(this.H)), 0, str, "", "", "");
        }
    }

    public void i(View view, String str, o oVar, int i3) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, str, oVar, Integer.valueOf(i3));
            return;
        }
        Fragment c16 = this.f280746e.c();
        if (c16 == null || (view2 = c16.getView()) == null) {
            return;
        }
        VideoReport.setPageId(view2, "pg_aio");
        HashMap hashMap = new HashMap(1);
        if (oVar.r() != null) {
            hashMap.put("pic_md5", oVar.r());
        }
        hashMap.put("banner_position", Integer.valueOf(i3));
        hashMap.put("trace_id", Integer.valueOf(this.J ? 1 : 0));
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(view, hashMap);
        view.post(new Runnable(str, hashMap, oVar) { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f280753d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Map f280754e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ o f280755f;

            {
                this.f280753d = str;
                this.f280754e = hashMap;
                this.f280755f = oVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AIOIceBreakView.this, str, hashMap, oVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.f280753d.equals("clck")) {
                    this.f280754e.put("kl_new_meme_type", Integer.valueOf(this.f280755f.p()));
                    com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_say_hello", this.f280754e);
                } else if (this.f280753d.equals("imp")) {
                    com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_say_hello", this.f280754e);
                }
            }
        });
        if (IceBreakingUtil.q(this.I, Integer.valueOf(this.H)) == 8) {
            j(view, str, oVar);
        }
    }

    public void setFromPush(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.J = z16;
        }
    }

    public void setGrayText(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(str);
            this.E.setText("");
        }
    }

    public void setOnIceImageClickListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.F = bVar;
        }
    }

    public AIOIceBreakView(com.tencent.aio.api.runtime.a aVar, Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) context);
            return;
        }
        this.G = 0;
        this.J = false;
        this.K = new View.OnClickListener() { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOIceBreakView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                int i3 = 2;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else if (AIOIceBreakView.this.f280746e != null) {
                    QLog.i("AIOIceBreakView", 2, ":OnClickMore");
                    view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AIOIceBreakView.this.f280746e.e().h(new EmotionPanelMsgIntent.SetEmotionPanelDefaultType(12));
                                AIOIceBreakView.this.f280746e.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("AIOIceBreakView", 1001));
                            }
                        }
                    }, 500L);
                    if (ao.c(AIOIceBreakView.this.H) != 1044) {
                        if (AIOIceBreakView.this.H == 0) {
                            i3 = 1;
                        }
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        int i16 = i3;
                        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X800A4CC", "0X800A4CC", i16, 0, "", "", "", "");
                        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X800A4CD", "0X800A4CD", i16, 0, "", "", "", "");
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.L = new a();
        this.f280745d = context;
        this.f280746e = aVar;
        this.H = IceBreakingUtil.p(Integer.valueOf(com.tencent.guild.aio.util.a.e(aVar.g()))).intValue();
        this.I = this.f280746e.g().r().c().j();
        l();
    }
}
