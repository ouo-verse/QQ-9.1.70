package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.IPSiteModel$Book;
import com.tencent.mobileqq.data.IPSiteModel$Comic;
import com.tencent.mobileqq.data.IPSiteModel$Game;
import com.tencent.mobileqq.data.IPSiteModel$Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVas04586Report;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class BigEmotionDownloadedAdapter extends AbsBigEmotionUpdateAdapter implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final int COMIC_TYPE_ANIMATION = 100;
    private static final int COMIC_TYPE_COMIC = 1;
    public static final String TAG = "BigEmotionDownloadedAdapter";
    public static final int TYPE_BTN = 1;
    public static final int TYPE_DATA = 0;
    private int businessType;
    public Drawable defaultCommercialDrawable;
    public EmoticonPackage emotionPkg;
    private IPanelInteractionListener interactionListener;
    public ColorDrawable mDefaultDrawable;
    public URLDrawable.URLDrawableListener mURLDrawableListener;
    private int tabIdx;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class BigEmotionHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;
        RelativeLayout[] contentViews;
        LinearLayout linearLayout;

        public BigEmotionHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public BigEmotionDownloadedAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelInteractionListener iPanelInteractionListener, Context context, int i3, int i16, int i17, EmoticonPackage emoticonPackage, EmoticonCallback emoticonCallback, int i18) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iPanelInteractionListener, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonPackage, emoticonCallback, Integer.valueOf(i18));
            return;
        }
        this.defaultCommercialDrawable = null;
        this.tabIdx = -1;
        this.mDefaultDrawable = null;
        this.mURLDrawableListener = new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BigEmotionDownloadedAdapter.this);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) uRLDrawable);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                int intValue;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) uRLDrawable, (Object) th5);
                    return;
                }
                if (th5 instanceof RejectedExecutionException) {
                    if (QLog.isColorLevel()) {
                        QLog.i(BigEmotionDownloadedAdapter.TAG, 2, "arg0.getConstantState() = " + uRLDrawable.getConstantState());
                        return;
                    }
                    return;
                }
                if (uRLDrawable != null) {
                    File fileInLocal = uRLDrawable.getFileInLocal();
                    if (fileInLocal != null && fileInLocal.exists()) {
                        fileInLocal.delete();
                    }
                    Object tag = uRLDrawable.getTag();
                    if ((tag instanceof Integer) && (intValue = ((Integer) tag).intValue()) < 3) {
                        int i19 = intValue + 1;
                        uRLDrawable.setTag(Integer.valueOf(i19));
                        uRLDrawable.restartDownload();
                        if (QLog.isColorLevel()) {
                            QLog.i(BigEmotionDownloadedAdapter.TAG, 2, "download recomment comic pic , try count = " + i19);
                        }
                    }
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable, int i19) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) uRLDrawable, i19);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                }
            }
        };
        this.emotionPkg = emoticonPackage;
        this.interactionListener = iPanelInteractionListener;
        this.businessType = i18;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BigEmotionDownloadedAdapter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                BigEmotionDownloadedAdapter.this.defaultCommercialDrawable = new ColorDrawable(Color.parseColor("#fafafa"));
                Bitmap createBitmap = Bitmap.createBitmap(com.tencent.mobileqq.EmotionUtils.a(44.0f, BigEmotionDownloadedAdapter.this.mContext.getResources()), com.tencent.mobileqq.EmotionUtils.a(44.0f, BigEmotionDownloadedAdapter.this.mContext.getResources()), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
                RectF rectF = new RectF(new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight()));
                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-16777216);
                canvas.drawRoundRect(rectF, 4.0f, 4.0f, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(createBitmap, new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight()), rect, paint);
                BigEmotionDownloadedAdapter.this.defaultCommercialDrawable.draw(canvas);
            }
        }, 8, null, true);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:3|(1:5)|6|(2:7|8)|9|(2:11|(2:13|(2:15|(7:17|18|19|20|(3:22|(3:24|(4:27|(4:29|(2:31|(3:33|(1:35)(1:37)|36))(3:41|(1:43)(1:45)|44)|38|39)(2:46|47)|40|25)|48)|49)(3:53|(3:55|(3:57|(4:60|(2:62|63)(1:65)|64|58)|66)|67)(2:68|(3:70|(1:72)|73)(2:74|(3:76|(3:78|(4:81|(10:83|(1:85)(1:101)|86|(1:88)(1:100)|89|(1:91)(1:99)|92|(1:94)(1:98)|95|96)(2:102|103)|97|79)|104)|105)(2:106|(3:108|(3:110|(4:113|(2:115|116)(1:118)|117|111)|119)|120))))|(1:52))|50|(0))(1:124))(1:126))(1:127))(1:128)|125|18|19|20|(0)(0)|50|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0046, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0047, code lost:
    
        com.tencent.qphone.base.util.QLog.e(com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.TAG, 1, "fillIPSiteViewPagerMode ipId error = " + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0272  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View getRichIPSiteView(VipIPSiteInfo vipIPSiteInfo) {
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        View view;
        View view2;
        String str5;
        int i16;
        Resources resources;
        int i17;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        float f16;
        float f17;
        VipIPSiteInfo vipIPSiteInfo2 = vipIPSiteInfo;
        View view3 = null;
        if (vipIPSiteInfo2 != null) {
            if (this.mDefaultDrawable == null) {
                this.mDefaultDrawable = new ColorDrawable(-1513240);
            }
            try {
                i3 = NetworkUtil.getSystemNetwork(this.mContext);
            } catch (Exception unused) {
                i3 = 0;
            }
            String str6 = "";
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            str2 = "";
                            str6 = String.valueOf(vipIPSiteInfo2.ipID);
                            View.OnClickListener onClickListener = new View.OnClickListener(vipIPSiteInfo2, str2, str6) { // from class: com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.3
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ String val$ipId;
                                final /* synthetic */ String val$netStr;
                                final /* synthetic */ VipIPSiteInfo val$vipIPSiteInfo;

                                {
                                    this.val$vipIPSiteInfo = vipIPSiteInfo2;
                                    this.val$netStr = str2;
                                    this.val$ipId = str6;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, this, BigEmotionDownloadedAdapter.this, vipIPSiteInfo2, str2, str6);
                                    }
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view4) {
                                    EventCollector.getInstance().onViewClickedBefore(view4);
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view4);
                                    } else {
                                        ((IBigEmotionService) QRoute.api(IBigEmotionService.class)).openQQBrowserWithoutAD(BigEmotionDownloadedAdapter.this.mContext, this.val$vipIPSiteInfo.ipUrl, -1L, null, false, -1);
                                        VasWebviewUtil.reportCommercialDrainage(BigEmotionDownloadedAdapter.this.app.getCurrentAccountUin(), "IP", "aio_enterclk", "", 0, 0, 0, this.val$netStr, this.val$ipId, "", "", "", "", "", 0, 0, 0, 0);
                                    }
                                    EventCollector.getInstance().onViewClicked(view4);
                                }
                            };
                            str3 = vipIPSiteInfo2.strType;
                            if (!"comic".equals(str3)) {
                                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.h8i, (ViewGroup) null, false);
                                TextView textView = (TextView) inflate.findViewById(R.id.f164163la);
                                TextView textView2 = (TextView) inflate.findViewById(R.id.f164146ks);
                                ((RelativeLayout) inflate.findViewById(R.id.f164160l7)).setOnClickListener(onClickListener);
                                RelativeLayout relativeLayout3 = (RelativeLayout) inflate.findViewById(R.id.f164138kk);
                                ImageView imageView = (ImageView) inflate.findViewById(R.id.f164142ko);
                                TextView textView3 = (TextView) inflate.findViewById(R.id.f164144kq);
                                TextView textView4 = (TextView) inflate.findViewById(R.id.f164139kl);
                                Button button = (Button) inflate.findViewById(R.id.f164165lc);
                                TextView textView5 = (TextView) inflate.findViewById(R.id.f164145kr);
                                RelativeLayout relativeLayout4 = (RelativeLayout) inflate.findViewById(R.id.f164140km);
                                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f164141kn);
                                StringBuilder sb5 = new StringBuilder();
                                view = inflate;
                                sb5.append(vipIPSiteInfo2.ipName);
                                RelativeLayout relativeLayout5 = relativeLayout3;
                                sb5.append(BaseApplication.getContext().getString(R.string.f209405fb));
                                textView.setText(sb5.toString());
                                textView2.setText(IPSiteUtil.dealIPSiteString(vipIPSiteInfo2.ipContent));
                                if (vipIPSiteInfo2.ipList != null) {
                                    int i18 = 0;
                                    while (i18 < vipIPSiteInfo2.ipList.size()) {
                                        Object obj = vipIPSiteInfo2.ipList.get(i18);
                                        if (obj instanceof IPSiteModel$Comic) {
                                            IPSiteModel$Comic iPSiteModel$Comic = (IPSiteModel$Comic) obj;
                                            View.OnClickListener onClickListener2 = new View.OnClickListener(iPSiteModel$Comic, str2, str6) { // from class: com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.4
                                                static IPatchRedirector $redirector_;
                                                final /* synthetic */ IPSiteModel$Comic val$comic;
                                                final /* synthetic */ String val$ipId;
                                                final /* synthetic */ String val$netStr;

                                                {
                                                    this.val$comic = iPSiteModel$Comic;
                                                    this.val$netStr = str2;
                                                    this.val$ipId = str6;
                                                    IPatchRedirector iPatchRedirector = $redirector_;
                                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                        iPatchRedirector.redirect((short) 1, this, BigEmotionDownloadedAdapter.this, iPSiteModel$Comic, str2, str6);
                                                    }
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View view4) {
                                                    EventCollector.getInstance().onViewClickedBefore(view4);
                                                    IPatchRedirector iPatchRedirector = $redirector_;
                                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view4);
                                                    } else {
                                                        ((IBigEmotionService) QRoute.api(IBigEmotionService.class)).openQQBrowserWithoutAD(BigEmotionDownloadedAdapter.this.mContext, this.val$comic.jumpUrl, -1L, null, false, -1);
                                                        VasWebviewUtil.reportCommercialDrainage(BigEmotionDownloadedAdapter.this.app.getCurrentAccountUin(), "IP", "aio_comicclk", "", 0, 0, 0, this.val$netStr, this.val$ipId, "", "", "", "", "", 0, 0, 0, 0);
                                                    }
                                                    EventCollector.getInstance().onViewClicked(view4);
                                                }
                                            };
                                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout4.getLayoutParams();
                                            int i19 = iPSiteModel$Comic.comicType;
                                            relativeLayout = relativeLayout4;
                                            if (i19 != 1) {
                                                if (i19 == 100) {
                                                    textView5.setText(BaseApplication.getContext().getString(R.string.f208835ds));
                                                    imageView2.setVisibility(0);
                                                    if (layoutParams == null) {
                                                        f17 = 75.0f;
                                                        layoutParams = new RelativeLayout.LayoutParams(com.tencent.mobileqq.EmotionUtils.a(140.0f, this.mContext.getResources()), com.tencent.mobileqq.EmotionUtils.a(75.0f, this.mContext.getResources()));
                                                    } else {
                                                        f17 = 75.0f;
                                                    }
                                                    layoutParams.width = com.tencent.mobileqq.EmotionUtils.a(140.0f, this.mContext.getResources());
                                                    layoutParams.height = com.tencent.mobileqq.EmotionUtils.a(f17, this.mContext.getResources());
                                                    textView3.setMaxWidth(com.tencent.mobileqq.EmotionUtils.a(90.0f, this.mContext.getResources()));
                                                    textView4.setMaxWidth(com.tencent.mobileqq.EmotionUtils.a(90.0f, this.mContext.getResources()));
                                                }
                                            } else {
                                                textView5.setText(BaseApplication.getContext().getString(R.string.f208955e4));
                                                imageView2.setVisibility(8);
                                                if (layoutParams == null) {
                                                    f16 = 75.0f;
                                                    layoutParams = new RelativeLayout.LayoutParams(com.tencent.mobileqq.EmotionUtils.a(75.0f, this.mContext.getResources()), com.tencent.mobileqq.EmotionUtils.a(75.0f, this.mContext.getResources()));
                                                } else {
                                                    f16 = 75.0f;
                                                }
                                                layoutParams.width = com.tencent.mobileqq.EmotionUtils.a(f16, this.mContext.getResources());
                                                layoutParams.height = com.tencent.mobileqq.EmotionUtils.a(f16, this.mContext.getResources());
                                                textView3.setMaxWidth(com.tencent.mobileqq.EmotionUtils.a(126.0f, this.mContext.getResources()));
                                                textView4.setMaxWidth(com.tencent.mobileqq.EmotionUtils.a(126.0f, this.mContext.getResources()));
                                            }
                                            imageView.setImageDrawable(IPSiteUtil.getIPSiteDrawable(iPSiteModel$Comic.cover, this.mURLDrawableListener, this.mDefaultDrawable));
                                            textView3.setText(iPSiteModel$Comic.name);
                                            textView4.setText(iPSiteModel$Comic.desc);
                                            button.setOnClickListener(onClickListener2);
                                            relativeLayout2 = relativeLayout5;
                                            relativeLayout2.setOnClickListener(onClickListener2);
                                        } else {
                                            relativeLayout = relativeLayout4;
                                            relativeLayout2 = relativeLayout5;
                                        }
                                        i18++;
                                        relativeLayout5 = relativeLayout2;
                                        relativeLayout4 = relativeLayout;
                                        vipIPSiteInfo2 = vipIPSiteInfo;
                                    }
                                }
                                str4 = str2;
                                VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_comicshow", "", 0, 0, 0, str2, str6, "", "", "", "", "", 0, 0, 0, 0);
                            } else {
                                str4 = str2;
                                if ("game".equals(str3)) {
                                    view3 = LayoutInflater.from(this.mContext).inflate(R.layout.h8g, (ViewGroup) null, false);
                                    TextView textView6 = (TextView) view3.findViewById(R.id.f164163la);
                                    TextView textView7 = (TextView) view3.findViewById(R.id.f164146ks);
                                    ((RelativeLayout) view3.findViewById(R.id.f164158l5)).setOnClickListener(onClickListener);
                                    RelativeLayout relativeLayout6 = (RelativeLayout) view3.findViewById(R.id.f164148ku);
                                    ImageView imageView3 = (ImageView) view3.findViewById(R.id.f164150kw);
                                    TextView textView8 = (TextView) view3.findViewById(R.id.f164152ky);
                                    TextView textView9 = (TextView) view3.findViewById(R.id.f164149kv);
                                    Button button2 = (Button) view3.findViewById(R.id.f164166ld);
                                    textView6.setText(vipIPSiteInfo.ipName + this.mContext.getString(R.string.f209405fb));
                                    textView7.setText(IPSiteUtil.dealIPSiteString(vipIPSiteInfo.ipContent));
                                    if (vipIPSiteInfo.ipList != null) {
                                        for (int i26 = 0; i26 < vipIPSiteInfo.ipList.size(); i26++) {
                                            Object obj2 = vipIPSiteInfo.ipList.get(i26);
                                            if (obj2 instanceof IPSiteModel$Game) {
                                                IPSiteModel$Game iPSiteModel$Game = (IPSiteModel$Game) obj2;
                                                View.OnClickListener onClickListener3 = new View.OnClickListener(iPSiteModel$Game, str4, str6) { // from class: com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.5
                                                    static IPatchRedirector $redirector_;
                                                    final /* synthetic */ IPSiteModel$Game val$game;
                                                    final /* synthetic */ String val$ipId;
                                                    final /* synthetic */ String val$netStr;

                                                    {
                                                        this.val$game = iPSiteModel$Game;
                                                        this.val$netStr = str4;
                                                        this.val$ipId = str6;
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                            iPatchRedirector.redirect((short) 1, this, BigEmotionDownloadedAdapter.this, iPSiteModel$Game, str4, str6);
                                                        }
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public void onClick(View view4) {
                                                        EventCollector.getInstance().onViewClickedBefore(view4);
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view4);
                                                        } else {
                                                            ((IBigEmotionService) QRoute.api(IBigEmotionService.class)).openQQBrowserWithoutAD(BigEmotionDownloadedAdapter.this.mContext, this.val$game.jumpUrl, -1L, null, false, -1);
                                                            VasWebviewUtil.reportCommercialDrainage(BigEmotionDownloadedAdapter.this.app.getCurrentAccountUin(), "IP", "aio_gameclk", "", 0, 0, 0, this.val$netStr, this.val$ipId, "", "", "", "", "", 0, 0, 0, 0);
                                                        }
                                                        EventCollector.getInstance().onViewClicked(view4);
                                                    }
                                                };
                                                imageView3.setImageDrawable(IPSiteUtil.getIPSiteDrawable(iPSiteModel$Game.cover, this.mURLDrawableListener, this.mDefaultDrawable));
                                                textView8.setText(iPSiteModel$Game.name);
                                                textView9.setText(iPSiteModel$Game.recommDesc);
                                                button2.setOnClickListener(onClickListener3);
                                                relativeLayout6.setOnClickListener(onClickListener3);
                                            }
                                        }
                                    }
                                    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_gameshow", "", 0, 0, 0, str4, str6, "", "", "", "", "", 0, 0, 0, 0);
                                } else if ("goods".equals(str3)) {
                                    view3 = LayoutInflater.from(this.mContext).inflate(R.layout.h8f, (ViewGroup) null, false);
                                    TextView textView10 = (TextView) view3.findViewById(R.id.f164163la);
                                    TextView textView11 = (TextView) view3.findViewById(R.id.f164146ks);
                                    ((RelativeLayout) view3.findViewById(R.id.f164157l4)).setOnClickListener(onClickListener);
                                    textView10.setText(vipIPSiteInfo.ipName + this.mContext.getString(R.string.f209405fb));
                                    textView11.setText(IPSiteUtil.dealIPSiteString(vipIPSiteInfo.ipContent));
                                    HorizontalListView horizontalListView = (HorizontalListView) view3.findViewById(R.id.f164162l9);
                                    if (vipIPSiteInfo.ipList != null) {
                                        IPSiteListGoodsAdapter iPSiteListGoodsAdapter = new IPSiteListGoodsAdapter(this.mContext, vipIPSiteInfo.ipList, this.mURLDrawableListener, this.mDefaultDrawable, this.app.getCurrentUin(), str6, str4);
                                        horizontalListView.setDividerWidth(com.tencent.mobileqq.EmotionUtils.a(10.0f, this.mContext.getResources()));
                                        horizontalListView.setAdapter((ListAdapter) iPSiteListGoodsAdapter);
                                    }
                                    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_productshow", "", 0, 0, 0, str4, str6, "", "", "", "", "", 0, 0, 0, 0);
                                } else if ("video".equals(str3)) {
                                    View inflate2 = LayoutInflater.from(this.mContext).inflate(R.layout.h8h, (ViewGroup) null, false);
                                    TextView textView12 = (TextView) inflate2.findViewById(R.id.f164163la);
                                    TextView textView13 = (TextView) inflate2.findViewById(R.id.f164146ks);
                                    ((RelativeLayout) inflate2.findViewById(R.id.f164159l6)).setOnClickListener(onClickListener);
                                    RelativeLayout relativeLayout7 = (RelativeLayout) inflate2.findViewById(R.id.f164168lf);
                                    ImageView imageView4 = (ImageView) inflate2.findViewById(R.id.f164171li);
                                    TextView textView14 = (TextView) inflate2.findViewById(R.id.f164173lk);
                                    TextView textView15 = (TextView) inflate2.findViewById(R.id.f164169lg);
                                    Button button3 = (Button) inflate2.findViewById(R.id.f164167le);
                                    textView12.setText(vipIPSiteInfo.ipName + this.mContext.getString(R.string.f209405fb));
                                    textView13.setText(IPSiteUtil.dealIPSiteString(vipIPSiteInfo.ipContent));
                                    if (vipIPSiteInfo.ipList != null) {
                                        int i27 = 0;
                                        while (i27 < vipIPSiteInfo.ipList.size()) {
                                            Object obj3 = vipIPSiteInfo.ipList.get(i27);
                                            if (obj3 instanceof IPSiteModel$Video) {
                                                IPSiteModel$Video iPSiteModel$Video = (IPSiteModel$Video) obj3;
                                                View.OnClickListener onClickListener4 = new View.OnClickListener(iPSiteModel$Video, str4, str6) { // from class: com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.6
                                                    static IPatchRedirector $redirector_;
                                                    final /* synthetic */ String val$ipId;
                                                    final /* synthetic */ String val$netStr;
                                                    final /* synthetic */ IPSiteModel$Video val$video;

                                                    {
                                                        this.val$video = iPSiteModel$Video;
                                                        this.val$netStr = str4;
                                                        this.val$ipId = str6;
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                            iPatchRedirector.redirect((short) 1, this, BigEmotionDownloadedAdapter.this, iPSiteModel$Video, str4, str6);
                                                        }
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public void onClick(View view4) {
                                                        EventCollector.getInstance().onViewClickedBefore(view4);
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view4);
                                                        } else {
                                                            ((IBigEmotionService) QRoute.api(IBigEmotionService.class)).openQQBrowserWithoutAD(BigEmotionDownloadedAdapter.this.mContext, this.val$video.redirectUrl, -1L, null, false, -1);
                                                            VasWebviewUtil.reportCommercialDrainage(BigEmotionDownloadedAdapter.this.app.getCurrentAccountUin(), "IP", "aio_movieclk", "", 0, 0, 0, this.val$netStr, this.val$ipId, "", "", "", "", "", 0, 0, 0, 0);
                                                        }
                                                        EventCollector.getInstance().onViewClicked(view4);
                                                    }
                                                };
                                                if (TextUtils.isEmpty(iPSiteModel$Video.buttonDesc)) {
                                                    str5 = this.mContext.getString(R.string.f208865dv);
                                                } else {
                                                    str5 = iPSiteModel$Video.buttonDesc;
                                                }
                                                view2 = inflate2;
                                                imageView4.setImageDrawable(IPSiteUtil.getIPSiteDrawable(iPSiteModel$Video.cover, this.mURLDrawableListener, this.mDefaultDrawable));
                                                textView14.setText(iPSiteModel$Video.name);
                                                if (TextUtils.isEmpty(iPSiteModel$Video.showDate)) {
                                                    textView15.setText(iPSiteModel$Video.desc);
                                                } else {
                                                    textView15.setText(iPSiteModel$Video.showDate + this.mContext.getString(R.string.f209395fa));
                                                }
                                                button3.setText(str5);
                                                if (str5.equals(this.mContext.getString(R.string.f208865dv))) {
                                                    i16 = R.drawable.l0i;
                                                } else {
                                                    i16 = R.drawable.l0h;
                                                }
                                                button3.setBackgroundResource(i16);
                                                if (str5.equals(this.mContext.getString(R.string.f208865dv))) {
                                                    resources = this.mContext.getResources();
                                                    i17 = R.color.f156896el;
                                                } else {
                                                    resources = this.mContext.getResources();
                                                    i17 = R.color.f156931fl;
                                                }
                                                button3.setTextColor(resources.getColor(i17));
                                                button3.setOnClickListener(onClickListener4);
                                                relativeLayout7.setOnClickListener(onClickListener4);
                                            } else {
                                                view2 = inflate2;
                                            }
                                            i27++;
                                            inflate2 = view2;
                                        }
                                    }
                                    view = inflate2;
                                    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_movieshow", "", 0, 0, 0, str4, str6, "", "", "", "", "", 0, 0, 0, 0);
                                } else if ("book".equals(str3)) {
                                    view3 = LayoutInflater.from(this.mContext).inflate(R.layout.h8j, (ViewGroup) null, false);
                                    TextView textView16 = (TextView) view3.findViewById(R.id.f164163la);
                                    TextView textView17 = (TextView) view3.findViewById(R.id.f164146ks);
                                    ((RelativeLayout) view3.findViewById(R.id.f164161l8)).setOnClickListener(onClickListener);
                                    RelativeLayout relativeLayout8 = (RelativeLayout) view3.findViewById(R.id.f164132ke);
                                    ImageView imageView5 = (ImageView) view3.findViewById(R.id.f164134kg);
                                    TextView textView18 = (TextView) view3.findViewById(R.id.f164136ki);
                                    TextView textView19 = (TextView) view3.findViewById(R.id.f164133kf);
                                    Button button4 = (Button) view3.findViewById(R.id.f164164lb);
                                    textView16.setText(vipIPSiteInfo.ipName + this.mContext.getString(R.string.f209405fb));
                                    textView17.setText(IPSiteUtil.dealIPSiteString(vipIPSiteInfo.ipContent));
                                    if (vipIPSiteInfo.ipList != null) {
                                        for (int i28 = 0; i28 < vipIPSiteInfo.ipList.size(); i28++) {
                                            Object obj4 = vipIPSiteInfo.ipList.get(i28);
                                            if (obj4 instanceof IPSiteModel$Book) {
                                                IPSiteModel$Book iPSiteModel$Book = (IPSiteModel$Book) obj4;
                                                View.OnClickListener onClickListener5 = new View.OnClickListener(iPSiteModel$Book, str4, str6) { // from class: com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.7
                                                    static IPatchRedirector $redirector_;
                                                    final /* synthetic */ IPSiteModel$Book val$book;
                                                    final /* synthetic */ String val$ipId;
                                                    final /* synthetic */ String val$netStr;

                                                    {
                                                        this.val$book = iPSiteModel$Book;
                                                        this.val$netStr = str4;
                                                        this.val$ipId = str6;
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                            iPatchRedirector.redirect((short) 1, this, BigEmotionDownloadedAdapter.this, iPSiteModel$Book, str4, str6);
                                                        }
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public void onClick(View view4) {
                                                        EventCollector.getInstance().onViewClickedBefore(view4);
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view4);
                                                        } else {
                                                            ((IBigEmotionService) QRoute.api(IBigEmotionService.class)).openQQBrowserWithoutAD(BigEmotionDownloadedAdapter.this.mContext, this.val$book.jumpUrl, -1L, null, false, -1);
                                                            VasWebviewUtil.reportCommercialDrainage(BigEmotionDownloadedAdapter.this.app.getCurrentAccountUin(), "IP", "aio_bookclk", "", 0, 0, 0, this.val$netStr, this.val$ipId, "", "", "", "", "", 0, 0, 0, 0);
                                                        }
                                                        EventCollector.getInstance().onViewClicked(view4);
                                                    }
                                                };
                                                imageView5.setImageDrawable(IPSiteUtil.getIPSiteDrawable(iPSiteModel$Book.cover, this.mURLDrawableListener, this.mDefaultDrawable));
                                                textView18.setText(iPSiteModel$Book.name);
                                                textView19.setText(iPSiteModel$Book.recommDesc);
                                                button4.setOnClickListener(onClickListener5);
                                                relativeLayout8.setOnClickListener(onClickListener5);
                                            }
                                        }
                                    }
                                    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_bookshow", "", 0, 0, 0, str4, str6, "", "", "", "", "", 0, 0, 0, 0);
                                }
                                if (view3 != null) {
                                    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_entershow", "", 0, 0, 0, str4, str6, "", "", "", "", "", 0, 0, 0, 0);
                                }
                            }
                            view3 = view;
                            if (view3 != null) {
                            }
                        } else {
                            str = "4G";
                        }
                    } else {
                        str = "3G";
                    }
                } else {
                    str = "2G";
                }
            } else {
                str = "wifi";
            }
            str2 = str;
            str6 = String.valueOf(vipIPSiteInfo2.ipID);
            View.OnClickListener onClickListener6 = new View.OnClickListener(vipIPSiteInfo2, str2, str6) { // from class: com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$ipId;
                final /* synthetic */ String val$netStr;
                final /* synthetic */ VipIPSiteInfo val$vipIPSiteInfo;

                {
                    this.val$vipIPSiteInfo = vipIPSiteInfo2;
                    this.val$netStr = str2;
                    this.val$ipId = str6;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, BigEmotionDownloadedAdapter.this, vipIPSiteInfo2, str2, str6);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    EventCollector.getInstance().onViewClickedBefore(view4);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view4);
                    } else {
                        ((IBigEmotionService) QRoute.api(IBigEmotionService.class)).openQQBrowserWithoutAD(BigEmotionDownloadedAdapter.this.mContext, this.val$vipIPSiteInfo.ipUrl, -1L, null, false, -1);
                        VasWebviewUtil.reportCommercialDrainage(BigEmotionDownloadedAdapter.this.app.getCurrentAccountUin(), "IP", "aio_enterclk", "", 0, 0, 0, this.val$netStr, this.val$ipId, "", "", "", "", "", 0, 0, 0, 0);
                    }
                    EventCollector.getInstance().onViewClicked(view4);
                }
            };
            str3 = vipIPSiteInfo2.strType;
            if (!"comic".equals(str3)) {
            }
            view3 = view;
            if (view3 != null) {
            }
        }
        return view3;
    }

    private boolean isKandianType() {
        if (this.businessType == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int count = super.getCount();
        if (count > 0) {
            if (!isKandianType()) {
                return count + 1;
            }
            return count;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public EmoticonPackage getEmoticonPackage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.emotionPkg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.widget.LinearLayout, android.view.View, android.view.ViewGroup, com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout] */
    /* JADX WARN: Type inference failed for: r10v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r10v9, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.widget.RelativeLayout, android.view.View, android.view.ViewGroup] */
    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        boolean z16;
        boolean z17;
        int i16;
        String str;
        byte[] bArr;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        System.currentTimeMillis();
        BigEmotionHolder bigEmotionHolder = (BigEmotionHolder) viewHolder;
        if (getItemViewType(i3) == 0) {
            if (view == null) {
                EmoticonPanelLinearLayout view3 = EmotionPanelViewPool.getInstance().getView(this.panelType);
                if (view3 == 0) {
                    view3 = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.interactionListener), this.businessType);
                    view3.setPanelType(1);
                    view3.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                    view3.setOrientation(0);
                    if (i3 == 0) {
                        view3.setPadding(0, (int) (this.density * 16.0f), 0, 0);
                    } else {
                        view3.setPadding(0, (int) (this.density * 14.0f), 0, 0);
                    }
                    for (int i17 = 0; i17 < this.columnNum; i17++) {
                        RelativeLayout bigEmotionContentViewLayout = super.getBigEmotionContentViewLayout();
                        bigEmotionContentViewLayout.setVisibility(8);
                        bigEmotionContentViewLayout.setFocusable(true);
                        bigEmotionContentViewLayout.setFocusableInTouchMode(true);
                        view3.addView(bigEmotionContentViewLayout);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view from cache");
                }
                view3.setCallBack(this.callback);
                recycleView(this.panelType, view3);
                ViewGroup viewGroup2 = view3;
                bigEmotionHolder.contentViews = new RelativeLayout[this.columnNum];
                for (int i18 = 0; i18 < this.columnNum; i18++) {
                    bigEmotionHolder.contentViews[i18] = (RelativeLayout) viewGroup2.getChildAt(i18);
                }
                view3.setTag(bigEmotionHolder);
                view2 = view3;
            } else {
                view2 = view;
            }
            int i19 = 0;
            while (true) {
                int i26 = this.columnNum;
                if (i19 < i26) {
                    int i27 = (i26 * i3) + i19;
                    if (i27 > this.data.size() - 1) {
                        bigEmotionHolder.contentViews[i19].setTag(null);
                        bigEmotionHolder.contentViews[i19].setVisibility(8);
                    } else {
                        RelativeLayout relativeLayout = bigEmotionHolder.contentViews[i19];
                        EmotionPanelData emotionPanelData = this.data.get(i27);
                        if (relativeLayout != null) {
                            if ((emotionPanelData instanceof PicEmoticonInfo) && this.businessType == 0) {
                                relativeLayout.setOnClickListener(this);
                                relativeLayout.setClickable(false);
                                EmoticonReportDtHelper.bindAlbumEmotionView(relativeLayout, (PicEmoticonInfo) emotionPanelData, i27, this.tabIdx);
                            }
                            if (emotionPanelData == relativeLayout.getTag(R.id.kxb)) {
                                relativeLayout.setVisibility(0);
                            } else {
                                relativeLayout.setTag(R.id.kxb, emotionPanelData);
                            }
                        }
                        System.currentTimeMillis();
                        super.updateBigEmotionContentViewData(relativeLayout, emotionPanelData);
                    }
                    i19++;
                } else {
                    return view2;
                }
            }
        } else {
            if (view == null) {
                EmoticonPackage emoticonPackage = this.emotionPkg;
                VipIPSiteInfo vipIPSiteInfo = emoticonPackage.ipSiteInfo;
                if (vipIPSiteInfo == null && (bArr = emoticonPackage.ipSiteInfoBytes) != null && bArr.length > 0) {
                    vipIPSiteInfo = ((EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class)).getIPSiteInfoFromBytes(this.emotionPkg.ipSiteInfoBytes);
                }
                CommercialDrainageManagerServiceProxy commercialDrainageManagerServiceProxy = (CommercialDrainageManagerServiceProxy) this.app.getRuntimeService(ICommercialDrainageManagerService.class);
                if (commercialDrainageManagerServiceProxy != null) {
                    z16 = commercialDrainageManagerServiceProxy.isRichIPSite(vipIPSiteInfo);
                } else {
                    z16 = false;
                }
                if (z16) {
                    View richIPSiteView = getRichIPSiteView(vipIPSiteInfo);
                    if (richIPSiteView != null) {
                        richIPSiteView.setTag(bigEmotionHolder);
                        return richIPSiteView;
                    }
                } else {
                    EmoticonRecDressup emotionRecommend = EmoticonRecDressup.getEmotionRecommend(this.emotionPkg.epId, true);
                    if (emotionRecommend != null) {
                        z17 = emotionRecommend.hasRecommendDressup;
                    } else {
                        z17 = false;
                    }
                    ?? relativeLayout2 = new RelativeLayout(this.mContext);
                    relativeLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) (this.density * 46.0f)));
                    LinearLayout linearLayout = new LinearLayout(this.mContext);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13, -1);
                    linearLayout.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setOrientation(0);
                    layoutParams2.gravity = 16;
                    TextView textView = new TextView(this.mContext);
                    textView.setTextSize(14.0f);
                    BaseApplication context = BaseApplication.getContext();
                    if (z17) {
                        i16 = R.string.f209535fo;
                    } else {
                        i16 = R.string.f209545fp;
                    }
                    textView.setText(context.getString(i16));
                    textView.setTextColor(RichStatus.ACTION_COLOR_NORMAL);
                    linearLayout.addView(textView, layoutParams2);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("emoji_id", this.emotionPkg.epId);
                        ((IVas04586Report) QRoute.api(IVas04586Report.class)).reportAction("DressVip", "pg_aio", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "text", "", "4", 101, 0, 0, "", jSONObject.toString(), "");
                    } catch (Exception e16) {
                        QLog.i(TAG, 1, "report action failed", e16);
                    }
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.leftMargin = (int) (this.density * 5.0f);
                    layoutParams3.gravity = 16;
                    ImageView imageView = new ImageView(this.mContext);
                    imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.nji));
                    linearLayout.addView(imageView, layoutParams3);
                    relativeLayout2.addView(linearLayout);
                    bigEmotionHolder.linearLayout = linearLayout;
                    linearLayout.setOnClickListener(new View.OnClickListener(z17) { // from class: com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ boolean val$finalHasRecommendDressup;

                        {
                            this.val$finalHasRecommendDressup = z17;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, BigEmotionDownloadedAdapter.this, Boolean.valueOf(z17));
                            }
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view4) {
                            String currentAccountUin;
                            String str2;
                            int i28;
                            EventCollector.getInstance().onViewClickedBefore(view4);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view4);
                            } else {
                                IBigEmotionService iBigEmotionService = (IBigEmotionService) QRoute.api(IBigEmotionService.class);
                                BigEmotionDownloadedAdapter bigEmotionDownloadedAdapter = BigEmotionDownloadedAdapter.this;
                                Context context2 = bigEmotionDownloadedAdapter.mContext;
                                IEmoticonMainPanelApp iEmoticonMainPanelApp = bigEmotionDownloadedAdapter.app;
                                String account = iEmoticonMainPanelApp.getAccount();
                                String valueOf = String.valueOf(BigEmotionDownloadedAdapter.this.emotionPkg.epId);
                                boolean z18 = this.val$finalHasRecommendDressup;
                                EmoticonPackage emoticonPackage2 = BigEmotionDownloadedAdapter.this.emotionPkg;
                                iBigEmotionService.openEmojiDetailPage(context2, iEmoticonMainPanelApp, account, 0, valueOf, false, null, false, z18, emoticonPackage2.extraFlags, emoticonPackage2.epId);
                                if (BigEmotionDownloadedAdapter.this.app.getCurrentAccountUin() == null) {
                                    currentAccountUin = "";
                                } else {
                                    currentAccountUin = BigEmotionDownloadedAdapter.this.app.getCurrentAccountUin();
                                }
                                String str3 = BigEmotionDownloadedAdapter.this.emotionPkg.epId;
                                if (this.val$finalHasRecommendDressup) {
                                    str2 = "1";
                                } else {
                                    str2 = "2";
                                }
                                VasWebviewUtil.reportCommercialDrainage(currentAccountUin, "ep_mall", "0X8007192", null, 1, 0, 0, null, str3, str2);
                                EmoticonPackage emoticonPackage3 = BigEmotionDownloadedAdapter.this.emotionPkg;
                                if ((emoticonPackage3.extraFlags & 1) > 0) {
                                    i28 = 3;
                                } else {
                                    i28 = 4;
                                    if (emoticonPackage3.subType != 4) {
                                        i28 = 1;
                                    }
                                }
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("emoji_id", BigEmotionDownloadedAdapter.this.emotionPkg.epId);
                                    ((IVas04586Report) QRoute.api(IVas04586Report.class)).reportAction("DressVip", "pg_aio", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "text", "", "4", 102, 0, 0, "", jSONObject2.toString(), "");
                                } catch (Exception e17) {
                                    QLog.i(BigEmotionDownloadedAdapter.TAG, 1, "report action failed", e17);
                                }
                                ReportController.o(BigEmotionDownloadedAdapter.this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", BigEmotionDownloadedAdapter.this.emotionPkg.epId, i28 + "", "");
                            }
                            EventCollector.getInstance().onViewClicked(view4);
                        }
                    });
                    bigEmotionHolder.linearLayout.setVisibility(0);
                    relativeLayout2.setTag(bigEmotionHolder);
                    ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "exp_bq_detail", 0, 0, "", this.emotionPkg.epId, "", "");
                    String currentAccountUin = this.app.getCurrentAccountUin();
                    String str2 = this.emotionPkg.epId;
                    if (z17) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    VasWebviewUtil.reportCommercialDrainage(currentAccountUin, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, str2, str);
                    return relativeLayout2;
                }
            }
            return view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        if (isKandianType() || i3 != getCount() - 1) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (isKandianType()) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new BigEmotionHolder();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "BigEmotionDownloadedAdapter itemView onClicked");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setTabIdx(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.tabIdx = i3;
        }
    }
}
