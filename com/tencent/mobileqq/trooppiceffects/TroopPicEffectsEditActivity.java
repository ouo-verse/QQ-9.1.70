package com.tencent.mobileqq.trooppiceffects;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.utils.ak;
import com.tencent.mobileqq.troop.utils.al;
import com.tencent.mobileqq.troop.utils.am;
import com.tencent.mobileqq.trooppiceffects.view.NormalPicView;
import com.tencent.mobileqq.trooppiceffects.view.PhantomPicView;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;
import com.tencent.mobileqq.trooppiceffects.view.VideoPicView;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.HorizontalListView;
import cooperation.peak.PeakConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.manager.TicketManager;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991$Goods;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991$LoginSig;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991$ReqBody;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991$User;

/* loaded from: classes19.dex */
public class TroopPicEffectsEditActivity extends IphoneTitleBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener, Observer {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected FrameLayout f303272a0;

    /* renamed from: b0, reason: collision with root package name */
    protected HorizontalListView f303273b0;

    /* renamed from: c0, reason: collision with root package name */
    protected d f303274c0;

    /* renamed from: d0, reason: collision with root package name */
    protected com.tencent.mobileqq.trooppiceffects.view.a f303275d0;

    /* renamed from: e0, reason: collision with root package name */
    protected Button f303276e0;

    /* renamed from: f0, reason: collision with root package name */
    protected String f303277f0;

    /* renamed from: g0, reason: collision with root package name */
    protected String f303278g0;

    /* renamed from: h0, reason: collision with root package name */
    protected String f303279h0;

    /* renamed from: i0, reason: collision with root package name */
    protected ProgressDialog f303280i0;

    /* renamed from: j0, reason: collision with root package name */
    protected c[] f303281j0;

    /* renamed from: k0, reason: collision with root package name */
    protected c f303282k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f303283l0;

    /* renamed from: m0, reason: collision with root package name */
    protected SparseArray<al.g> f303284m0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends ak {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPicEffectsEditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.ak
        public void j(SparseArray<al.g> sparseArray) {
            String str;
            String str2;
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) sparseArray);
                return;
            }
            TroopPicEffectsEditActivity troopPicEffectsEditActivity = TroopPicEffectsEditActivity.this;
            troopPicEffectsEditActivity.f303284m0 = sparseArray;
            al.g gVar = sparseArray.get(troopPicEffectsEditActivity.f303283l0);
            if (gVar != null) {
                str = gVar.f302035b;
            } else {
                str = "30\u91d1\u8c46\u79c0\u4e00\u4e0b";
            }
            if (gVar != null) {
                str2 = gVar.f302036c;
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                i3 = str.indexOf(str2);
                i16 = str2.length() + i3;
            } else {
                i3 = 0;
                i16 = 0;
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new StrikethroughSpan(), i3, i16, 18);
            TroopPicEffectsEditActivity.this.f303276e0.setText(spannableString);
        }
    }

    /* loaded from: classes19.dex */
    class b extends ak {
        static IPatchRedirector $redirector_;

        /* loaded from: classes19.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                String format = String.format("https://qun.qq.com/qunpay/gifts/buy.html?_bid=2204&_wvSb=1&from=7&troopUin=%s", TroopPicEffectsEditActivity.this.f303278g0);
                Intent intent = new Intent(TroopPicEffectsEditActivity.this, (Class<?>) QQBrowserActivity.class);
                intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.f171898lr0));
                intent.putExtra("hide_more_button", true);
                intent.putExtra("hide_operation_bar", true);
                intent.putExtra("url", TroopPicEffectsEditActivity.this.M2(format));
                TroopPicEffectsEditActivity.this.startActivity(intent);
            }
        }

        /* renamed from: com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity$b$b, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        class DialogInterfaceOnClickListenerC8848b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnClickListenerC8848b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                }
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPicEffectsEditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.ak
        public void h(int i3, int i16, String str, List<al.f> list) {
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, list);
                return;
            }
            if (TroopPicEffectsEditActivity.this.isFinishing()) {
                return;
            }
            TroopPicEffectsEditActivity troopPicEffectsEditActivity = TroopPicEffectsEditActivity.this;
            al.g gVar = troopPicEffectsEditActivity.f303284m0.get(troopPicEffectsEditActivity.f303283l0);
            if (gVar == null || (i17 = gVar.f302034a) == 0) {
                i17 = 30;
            }
            if (i3 >= i17) {
                TroopPicEffectsEditActivity troopPicEffectsEditActivity2 = TroopPicEffectsEditActivity.this;
                troopPicEffectsEditActivity2.N2(troopPicEffectsEditActivity2.f303277f0);
            } else {
                TroopPicEffectsEditActivity.this.H2();
                TroopPicEffectsEditActivity troopPicEffectsEditActivity3 = TroopPicEffectsEditActivity.this;
                DialogUtil.createCustomDialog(troopPicEffectsEditActivity3, 230, troopPicEffectsEditActivity3.getResources().getString(R.string.ev_), TroopPicEffectsEditActivity.this.getResources().getString(R.string.ev9), TroopPicEffectsEditActivity.this.getResources().getString(R.string.cancel), TroopPicEffectsEditActivity.this.getResources().getString(R.string.evb), new a(), new DialogInterfaceOnClickListenerC8848b()).show();
                com.tencent.mobileqq.trooppiceffects.a.a("gold_bean", "gap");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes19.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f303290a;

        /* renamed from: b, reason: collision with root package name */
        public String f303291b;

        /* renamed from: c, reason: collision with root package name */
        public String f303292c;

        /* renamed from: d, reason: collision with root package name */
        public int f303293d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f303294e;

        public c(int i3, String str, int i16, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Boolean.valueOf(z16));
                return;
            }
            this.f303290a = i3;
            this.f303291b = str;
            this.f303292c = "https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_item_" + i3 + ".png";
            this.f303293d = i16;
            this.f303294e = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes19.dex */
    public class d extends BaseAdapter {
        static IPatchRedirector $redirector_;

        protected d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPicEffectsEditActivity.this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return TroopPicEffectsEditActivity.this.f303281j0.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return TroopPicEffectsEditActivity.this.f303281j0[i3];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return TroopPicEffectsEditActivity.this.f303281j0[i3].f303290a;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            f fVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view3 = view;
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (view == null) {
                    fVar = new f();
                    view2 = LayoutInflater.from(TroopPicEffectsEditActivity.this).inflate(R.layout.f169155c24, viewGroup, false);
                    fVar.f303299a = (ImageView) view2.findViewById(R.id.k0s);
                    fVar.f303300b = (TextView) view2.findViewById(R.id.k0u);
                    fVar.f303301c = view2.findViewById(R.id.k0t);
                    view2.setTag(fVar);
                } else {
                    fVar = (f) view.getTag();
                    view2 = view;
                }
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable = new ColorDrawable(0);
                obtain.mFailedDrawable = colorDrawable;
                obtain.mLoadingDrawable = colorDrawable;
                URLDrawable drawable = URLDrawable.getDrawable(TroopPicEffectsEditActivity.this.f303281j0[i3].f303292c, obtain);
                drawable.setTag(com.tencent.mobileqq.urldrawable.a.c(190, 270, x.c(TroopPicEffectsEditActivity.this, 3.0f)));
                drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                fVar.f303299a.setImageDrawable(drawable);
                fVar.f303300b.setText(TroopPicEffectsEditActivity.this.f303281j0[i3].f303291b);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, x.c(TroopPicEffectsEditActivity.this, 5.0f), x.c(TroopPicEffectsEditActivity.this, 5.0f), x.c(TroopPicEffectsEditActivity.this, 5.0f), x.c(TroopPicEffectsEditActivity.this, 5.0f)});
                gradientDrawable.setColor(TroopPicEffectsEditActivity.this.f303281j0[i3].f303293d);
                fVar.f303300b.setBackgroundDrawable(gradientDrawable);
                View view4 = fVar.f303301c;
                if (!TroopPicEffectsEditActivity.this.f303281j0[i3].f303294e) {
                    i16 = 8;
                }
                view4.setVisibility(i16);
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* loaded from: classes19.dex */
    protected static class e implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        protected WeakReference<TroopPicEffectsEditActivity> f303296d;

        /* loaded from: classes19.dex */
        class a extends ProtoUtils.TroopProtocolObserver {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TroopPicEffectsEditActivity f303297d;

            a(TroopPicEffectsEditActivity troopPicEffectsEditActivity) {
                this.f303297d = troopPicEffectsEditActivity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) troopPicEffectsEditActivity);
                }
            }

            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public void onResult(int i3, byte[] bArr, Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopPicEffectsEditActivity", 2, "payForPhoto. onResult. errorCode=" + i3);
                }
                if (i3 == 0) {
                    QQToast.makeText(this.f303297d, 2, HardCodeUtil.qqStr(R.string.uor), 0).show();
                } else {
                    QQToast.makeText(this.f303297d, 1, HardCodeUtil.qqStr(R.string.uoy), 0).show();
                }
            }
        }

        public e(TroopPicEffectsEditActivity troopPicEffectsEditActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopPicEffectsEditActivity);
            } else {
                this.f303296d = new WeakReference<>(troopPicEffectsEditActivity);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_richtext);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
                return;
            }
            TroopPicEffectsEditActivity troopPicEffectsEditActivity = this.f303296d.get();
            if (troopPicEffectsEditActivity == null) {
                return;
            }
            troopPicEffectsEditActivity.H2();
            Intent aliasIntent = SplashActivity.getAliasIntent(troopPicEffectsEditActivity);
            aliasIntent.putExtra("uin", troopPicEffectsEditActivity.getIntent().getStringExtra("friendUin"));
            aliasIntent.putExtra("uintype", 1);
            aliasIntent.putExtra("troop_uin", troopPicEffectsEditActivity.getIntent().getStringExtra("troopUin"));
            aliasIntent.putExtra("isFromTroopEffectPic", true);
            troopPicEffectsEditActivity.startActivity(BaseAIOUtils.m(aliasIntent, new int[]{1}));
            troopPicEffectsEditActivity.finish();
            troopPicEffectsEditActivity.L2(troopPicEffectsEditActivity.f303282k0, (im_msg_body$CustomFace) aVar.f258608l, new a(troopPicEffectsEditActivity));
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            }
        }
    }

    /* loaded from: classes19.dex */
    protected static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ImageView f303299a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f303300b;

        /* renamed from: c, reason: collision with root package name */
        public View f303301c;

        protected f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TroopPicEffectsEditActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f303281j0 = null;
        this.f303283l0 = 40000;
        this.f303284m0 = new SparseArray<>(10);
    }

    public static void K2(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.setClass(activity, NewPhotoListActivity.class);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TroopPicEffectsEditActivity.class.getName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
        intent.putExtra(PeakConstants.IS_WAIT_DEST_RESULT, true);
        intent.putExtra("friendUin", str);
        intent.putExtra("troopUin", str2);
        activity.startActivity(intent);
        QAlbumUtil.anim(activity, false, true);
        com.tencent.mobileqq.trooppiceffects.a.a("pic_select", "page_exp");
    }

    protected void G2(ak akVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) akVar);
        } else {
            ((al) this.app.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).b("OidbSvc.0x6c3", 1731, 1, this.f303278g0, 1, 7, true, true, akVar);
        }
    }

    protected void H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        ProgressDialog progressDialog = this.f303280i0;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f303280i0.dismiss();
        }
    }

    protected void I2(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) pVar);
        } else {
            ThreadManagerV2.post(new Runnable(pVar.C) { // from class: com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ v f303285d;

                {
                    this.f303285d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopPicEffectsEditActivity.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    TroopPicEffectsEditActivity.this.app.getHwEngine().preConnect();
                    CompressInfo compressInfo = new CompressInfo(this.f303285d.K, 0);
                    compressInfo.K = 0;
                    ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
                    TransferRequest transferRequest = new TransferRequest();
                    transferRequest.mSelfUin = TroopPicEffectsEditActivity.this.app.getAccount();
                    TroopPicEffectsEditActivity troopPicEffectsEditActivity = TroopPicEffectsEditActivity.this;
                    transferRequest.mPeerUin = troopPicEffectsEditActivity.f303278g0;
                    transferRequest.mSecondId = troopPicEffectsEditActivity.app.getCurrentAccountUin();
                    transferRequest.mUinType = 1;
                    transferRequest.mFileType = 1;
                    transferRequest.mIsUp = true;
                    v vVar = this.f303285d;
                    transferRequest.mBusiType = vVar.f258712f;
                    transferRequest.mLocalPath = compressInfo.H;
                    transferRequest.mMd5 = vVar.J;
                    TransferRequest.PicUpExtraInfo picUpExtraInfo = new TransferRequest.PicUpExtraInfo();
                    transferRequest.mExtraObj = picUpExtraInfo;
                    picUpExtraInfo.mIsRaw = false;
                    transferRequest.mUpCallBack = new e(TroopPicEffectsEditActivity.this);
                    v vVar2 = this.f303285d;
                    transferRequest.mIsPresend = vVar2.U;
                    transferRequest.myPresendInvalid = vVar2.W;
                    transferRequest.mFileType = 55;
                    transferRequest.mUniseq = System.currentTimeMillis();
                    ((ITransFileController) TroopPicEffectsEditActivity.this.app.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
                }
            }, 8, null, true);
        }
    }

    protected void J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        c[] cVarArr = {new c(40000, HardCodeUtil.qqStr(R.string.uon), Color.parseColor("#F2575757"), true), new c(40002, HardCodeUtil.qqStr(R.string.uoq), Color.parseColor("#F23FCCDF"), false), new c(40001, HardCodeUtil.qqStr(R.string.f172853up3), Color.parseColor("#F2EF7AEE"), false), new c(40003, HardCodeUtil.qqStr(R.string.uox), Color.parseColor("#F2FFA02D"), false), new c(40004, HardCodeUtil.qqStr(R.string.uop), Color.parseColor("#F21CD28C"), false), new c(BaseConstants.ERR_SVR_PROFILE_SENSITIVE_TEXT, HardCodeUtil.qqStr(R.string.uow), Color.parseColor("#F2FF6EA2"), false)};
        this.f303281j0 = cVarArr;
        this.f303282k0 = cVarArr[0];
        this.f303273b0.setAdapter((ListAdapter) this.f303274c0);
        this.f303273b0.setOnItemClickListener(this);
        G2(new a());
    }

    protected void L2(c cVar, im_msg_body$CustomFace im_msg_body_customface, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, cVar, im_msg_body_customface, troopProtocolObserver);
            return;
        }
        oidb_cmd0x991$ReqBody oidb_cmd0x991_reqbody = new oidb_cmd0x991$ReqBody();
        oidb_cmd0x991$User oidb_cmd0x991_user = new oidb_cmd0x991$User();
        oidb_cmd0x991$Goods oidb_cmd0x991_goods = new oidb_cmd0x991$Goods();
        oidb_cmd0x991_user.uint64_group.set(Long.parseLong(this.f303278g0));
        oidb_cmd0x991_user.uint32_client.set(1);
        oidb_cmd0x991_user.bytes_version.set(ByteStringMicro.copyFrom(AppSetting.d().getBytes()), true);
        oidb_cmd0x991_user.uint32_portal.set(600);
        oidb_cmd0x991$LoginSig oidb_cmd0x991_loginsig = new oidb_cmd0x991$LoginSig();
        oidb_cmd0x991_loginsig.uint32_type.set(1);
        oidb_cmd0x991_loginsig.uint32_appid.set(0);
        TicketManager ticketManager = (TicketManager) this.app.getManager(2);
        if (ticketManager != null) {
            str = VasSkey.getSkey(ticketManager, this.app.getCurrentAccountUin());
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            oidb_cmd0x991_loginsig.bytes_sig.set(ByteStringMicro.copyFromUtf8(str));
        }
        oidb_cmd0x991_user.msg_login_sig.set(oidb_cmd0x991_loginsig);
        oidb_cmd0x991_user.uint32_instance_id.set(AppSetting.f());
        oidb_cmd0x991_goods.int32_product_id.set(cVar.f303290a);
        oidb_cmd0x991_goods.bytes_goods_name.set(ByteStringMicro.copyFrom(cVar.f303291b.getBytes()));
        oidb_cmd0x991_goods.int32_goods_price.set(9);
        oidb_cmd0x991_goods.bytes_animation_param.set(ByteStringMicro.copyFrom("{}".getBytes()));
        oidb_cmd0x991_goods.msg_img.set(im_msg_body_customface);
        oidb_cmd0x991_reqbody.msg_user.set(oidb_cmd0x991_user);
        oidb_cmd0x991_reqbody.msg_goods.set(oidb_cmd0x991_goods);
        ProtoUtils.c(this.app, troopProtocolObserver, oidb_cmd0x991_reqbody.toByteArray(), "OidbSvc.0x991_0", 2449, 0, new Bundle(), 5000L);
    }

    protected String M2(String str) {
        QQAppInterface qQAppInterface;
        TroopInfo B;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (str != null && (qQAppInterface = this.app) != null) {
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            String str3 = "2";
            if (troopManager != null && (B = troopManager.B(this.f303278g0)) != null) {
                if (B.isTroopOwner(this.app.getCurrentAccountUin())) {
                    str2 = "0";
                } else if (B.isOwnerOrAdmin()) {
                    str2 = "1";
                }
                str3 = str2;
            }
            return str.replace("$GCODE$", this.f303278g0).replace("$CLIENTVER$", "android" + AppSetting.f99551k).replace("$UIN$", this.app.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", str3);
        }
        return str;
    }

    protected void N2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. path invalid,path:" + str);
            return;
        }
        p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, 1007);
        v.a aVar = new v.a();
        aVar.x(this.f303278g0);
        aVar.v(this.f303277f0);
        aVar.I(1);
        aVar.A(this.f303279h0);
        aVar.m(1007);
        aVar.C(0);
        aVar.n(0);
        v l3 = aVar.l();
        if (!createPicReq.f(l3)) {
            QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
        } else {
            l3.K = str;
            I2(createPicReq);
        }
    }

    public void P2(int i3, String str) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
            return;
        }
        com.tencent.mobileqq.trooppiceffects.view.a aVar = this.f303275d0;
        if (aVar != null) {
            this.f303272a0.removeView(aVar.getView());
            this.f303275d0.onDestroy();
        }
        boolean q16 = am.q(i3);
        switch (i3) {
            case 40001:
                this.f303275d0 = new PhantomPicView(this);
                break;
            case 40002:
                this.f303275d0 = new ShakePicView(this);
                break;
            case 40003:
            case 40004:
            case BaseConstants.ERR_SVR_PROFILE_SENSITIVE_TEXT /* 40005 */:
                int width = this.f303272a0.getWidth();
                this.f303275d0 = new VideoPicView(this, i3, width, (width * 1024) / 750);
                if (!q16) {
                    AIOAnimationControlManager aIOAnimationControlManager = (AIOAnimationControlManager) this.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
                    aIOAnimationControlManager.h(this);
                    aIOAnimationControlManager.p(i3, this.f303278g0, null);
                    break;
                }
                break;
            default:
                this.f303275d0 = new NormalPicView(this);
                break;
        }
        this.f303272a0.addView(this.f303275d0.getView(), -1, -1);
        int readOrientation = JpegExifReader.readOrientation(str);
        if (readOrientation != 3) {
            if (readOrientation != 6) {
                if (readOrientation != 8) {
                    i16 = 0;
                } else {
                    i16 = 270;
                }
            } else {
                i16 = 90;
            }
        } else {
            i16 = 180;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)), 2048);
            options.inSampleSize = (int) BaseImageUtil.getOptRatio(bufferedInputStream, 720, 1080);
            bufferedInputStream.close();
            Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(str, options);
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate(i16);
            this.f303275d0.setBitmap(Bitmap.createBitmap(decodeFileWithBufferedStream, 0, 0, decodeFileWithBufferedStream.getWidth(), decodeFileWithBufferedStream.getHeight(), matrix, true));
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        } catch (IOException e17) {
            e17.printStackTrace();
        } catch (OutOfMemoryError e18) {
            e18.printStackTrace();
        }
        if (q16) {
            this.f303275d0.play();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        VasCommonReporter.getHistoryFeature("xiutu").setValue2("doOnCreate");
        setContentView(R.layout.f169156c25);
        setTitle(HardCodeUtil.qqStr(R.string.uou));
        this.leftView.setText(HardCodeUtil.qqStr(R.string.uoz));
        this.f303272a0 = (FrameLayout) findViewById(R.id.k0w);
        this.f303276e0 = (Button) findViewById(R.id.k0x);
        this.f303273b0 = (HorizontalListView) findViewById(R.id.k0v);
        this.f303274c0 = new d();
        this.f303276e0.setOnClickListener(this);
        this.f303273b0.setDividerWidth(x.c(this, 5.0f));
        Intent intent = getIntent();
        this.f303278g0 = intent.getStringExtra("friendUin");
        this.f303279h0 = intent.getStringExtra("troopUin");
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        this.f303277f0 = stringExtra;
        P2(40000, stringExtra);
        J2();
        com.tencent.mobileqq.trooppiceffects.a.a("action_select", "page_exp");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        H2();
        com.tencent.mobileqq.trooppiceffects.view.a aVar = this.f303275d0;
        if (aVar != null) {
            aVar.onDestroy();
        }
        this.f303281j0 = new c[0];
        ((AIOAnimationControlManager) this.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER)).m(this);
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.trooppiceffects.a.a("action_select", "clk_back");
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else if (view == this.f303276e0) {
            G2(new b());
            showProgressDialog();
            com.tencent.mobileqq.trooppiceffects.a.a("send_pic", "clk_send");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        String str;
        String str2;
        int i16;
        boolean z16;
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            P2(this.f303281j0[i3].f303290a, this.f303277f0);
            c cVar = this.f303281j0[i3];
            this.f303282k0 = cVar;
            this.f303283l0 = cVar.f303290a;
            int i18 = 0;
            while (true) {
                c[] cVarArr = this.f303281j0;
                if (i18 >= cVarArr.length) {
                    break;
                }
                c cVar2 = cVarArr[i18];
                if (i18 == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                cVar2.f303294e = z16;
                i18++;
            }
            this.f303274c0.notifyDataSetChanged();
            al.g gVar = this.f303284m0.get(this.f303283l0);
            if (gVar != null) {
                str = gVar.f302035b;
            } else {
                str = "30\u91d1\u8c46\u79c0\u4e00\u4e0b";
            }
            if (gVar != null) {
                str2 = gVar.f302036c;
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                i17 = str.indexOf(str2);
                i16 = str2.length() + i17;
            } else {
                i16 = 0;
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new StrikethroughSpan(), i17, i16, 18);
            this.f303276e0.setText(spannableString);
            com.tencent.mobileqq.trooppiceffects.a.a("action_select", "clk_switch");
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    protected void showProgressDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        ProgressDialog progressDialog = this.f303280i0;
        if (progressDialog == null) {
            ReportProgressDialog reportProgressDialog = new ReportProgressDialog(this, R.style.qZoneInputDialog);
            this.f303280i0 = reportProgressDialog;
            reportProgressDialog.setCancelable(true);
            this.f303280i0.show();
            this.f303280i0.setContentView(R.layout.f168383uh);
            ((TextView) this.f303280i0.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(HardCodeUtil.qqStr(R.string.uov));
            return;
        }
        progressDialog.show();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) observable, obj);
            return;
        }
        AIOAnimationControlManager.f fVar = (AIOAnimationControlManager.f) obj;
        if (fVar.f306839b) {
            if (fVar.f306838a.equals("" + this.f303283l0)) {
                com.tencent.mobileqq.trooppiceffects.view.a aVar = this.f303275d0;
                if (aVar instanceof VideoPicView) {
                    ((VideoPicView) aVar).play();
                }
            }
        }
    }
}
