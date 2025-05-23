package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.config.AppSetting;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.font.FontSizeChangeBannerHelper;
import com.tencent.mobileqq.guild.picload.GuildFeedPicLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.CommonImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.avatar.AvatarSizeType;
import com.tencent.qqnt.avatar.IAvatarOutboundApi;
import com.tencent.qqnt.avatar.b;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.ListView;
import com.tencent.widget.RangeButtonView;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.GlobalScope;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes9.dex */
public class FontSettingActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RangeButtonView.OnChangeListener, FontSettingManager.FontLevel {
    static IPatchRedirector $redirector_;
    ThemeBackground A0;
    private Dialog B0;
    boolean C0;
    private MqqHandler D0;

    /* renamed from: a0, reason: collision with root package name */
    ViewPager f175714a0;

    /* renamed from: b0, reason: collision with root package name */
    CirclePageIndicator f175715b0;

    /* renamed from: c0, reason: collision with root package name */
    h f175716c0;

    /* renamed from: d0, reason: collision with root package name */
    ArrayList<View> f175717d0;

    /* renamed from: e0, reason: collision with root package name */
    ListView f175718e0;

    /* renamed from: f0, reason: collision with root package name */
    ListView f175719f0;

    /* renamed from: g0, reason: collision with root package name */
    RecyclerView f175720g0;

    /* renamed from: h0, reason: collision with root package name */
    ViewGroup f175721h0;

    /* renamed from: i0, reason: collision with root package name */
    RangeButtonView f175722i0;

    /* renamed from: j0, reason: collision with root package name */
    ViewGroup f175723j0;

    /* renamed from: k0, reason: collision with root package name */
    IFaceDecoder f175724k0;

    /* renamed from: l0, reason: collision with root package name */
    List<g> f175725l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f175726m0;

    /* renamed from: n0, reason: collision with root package name */
    AioListAdapter f175727n0;

    /* renamed from: o0, reason: collision with root package name */
    k f175728o0;

    /* renamed from: p0, reason: collision with root package name */
    f f175729p0;

    /* renamed from: q0, reason: collision with root package name */
    StaggeredGridLayoutManager f175730q0;

    /* renamed from: r0, reason: collision with root package name */
    List<ChatMessage> f175731r0;

    /* renamed from: s0, reason: collision with root package name */
    SessionInfo f175732s0;

    /* renamed from: t0, reason: collision with root package name */
    ArrayList<j> f175733t0;

    /* renamed from: u0, reason: collision with root package name */
    boolean f175734u0;

    /* renamed from: v0, reason: collision with root package name */
    boolean f175735v0;

    /* renamed from: w0, reason: collision with root package name */
    boolean f175736w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f175737x0;

    /* renamed from: y0, reason: collision with root package name */
    private float f175738y0;

    /* renamed from: z0, reason: collision with root package name */
    private TopGestureLayout f175739z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class AioListAdapter extends BaseAdapter {
        static IPatchRedirector $redirector_;

        AioListAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontSettingActivity.this);
            }
        }

        private void a(View view) {
            ImageView imageView = (ImageView) view.findViewById(R.id.chat_item_head_icon);
            if (imageView == null) {
                QLog.d("qqBaseActivity", 1, "adjustHeadSize err, head is null");
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            if (layoutParams == null) {
                QLog.d("qqBaseActivity", 1, "adjustHeadSize err, layoutParams is null");
                return;
            }
            layoutParams.width = FontSettingActivity.this.getResources().getDimensionPixelSize(R.dimen.f158229ay);
            layoutParams.height = FontSettingActivity.this.getResources().getDimensionPixelSize(R.dimen.f158229ay);
            imageView.setLayoutParams(layoutParams);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return FontSettingActivity.this.f175731r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return FontSettingActivity.this.f175731r0.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                ChatMessage chatMessage = FontSettingActivity.this.f175731r0.get(i3);
                i iVar = new i(FontSettingActivity.this, chatMessage.isSelf());
                a(iVar);
                iVar.c(chatMessage);
                if (FontSettingActivity.this.f175737x0 && i3 == FontSettingActivity.this.f175731r0.size() - 1) {
                    FontSettingActivity fontSettingActivity = FontSettingActivity.this;
                    fontSettingActivity.f175734u0 = true;
                    fontSettingActivity.W2();
                }
                FontSettingActivity fontSettingActivity2 = FontSettingActivity.this;
                if (fontSettingActivity2.C0 && i3 == fontSettingActivity2.f175731r0.size() - 1) {
                    FontSettingActivity fontSettingActivity3 = FontSettingActivity.this;
                    fontSettingActivity3.C0 = false;
                    fontSettingActivity3.D0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.FontSettingActivity.AioListAdapter.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AioListAdapter.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            FontSettingActivity.this.f175718e0.setAdapter((ListAdapter) null);
                            FontSettingActivity fontSettingActivity4 = FontSettingActivity.this;
                            fontSettingActivity4.f175718e0.setAdapter((ListAdapter) fontSettingActivity4.f175727n0);
                            FontSettingManager.revertToLastDendisy(FontSettingActivity.this);
                        }
                    }, 100L);
                }
                view2 = iVar;
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontSettingActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FontSettingActivity.this.R2();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontSettingActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(FontSettingActivity.this.app, "dc00898", "", "", "0X800C020", "0X800C020", 0, 0, "", "", "", "");
                FontSettingActivity.this.showDialog();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontSettingActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            FontSettingActivity fontSettingActivity = FontSettingActivity.this;
            if (FontSettingManager.setCustomDensity(fontSettingActivity, fontSettingActivity.f175738y0, true)) {
                FontSizeChangeBannerHelper.f210540a.b(FontSettingActivity.this);
                FontSettingManager.killProcess();
            }
            FontSettingActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontSettingActivity.this);
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

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e extends MqqHandler {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontSettingActivity.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (16711697 == message.what) {
                FontSettingActivity fontSettingActivity = FontSettingActivity.this;
                FontSettingManager.setCustomDensity(fontSettingActivity, fontSettingActivity.f175738y0, false);
                FontSettingActivity fontSettingActivity2 = FontSettingActivity.this;
                fontSettingActivity2.C0 = true;
                fontSettingActivity2.f175727n0.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f extends RecyclerView.Adapter<a> {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name */
        private List<g> f175747m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;
            ImageView E;
            TextView F;
            View G;

            public a(View view) {
                super(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) view);
                    return;
                }
                this.E = (ImageView) view.findViewById(R.id.image);
                this.F = (TextView) view.findViewById(R.id.jgg);
                this.G = view.findViewById(R.id.t9d);
            }
        }

        public f(List<g> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontSettingActivity.this, (Object) list);
            } else {
                this.f175747m = list;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.f175747m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return this.f175747m.get(i3).f175748a.hashCode();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, i3);
                return;
            }
            FontSettingManager.resetViewSize2Normal(FontSettingActivity.this, aVar.E);
            g gVar = this.f175747m.get(i3);
            int density = (int) (FontSettingActivity.this.getDensity() * 9.0f);
            int density2 = (int) (FontSettingActivity.this.getDensity() * 10.0f);
            if (gVar.f175749b.isEmpty()) {
                aVar.E.setVisibility(8);
                aVar.G.setVisibility(0);
                density = (int) (FontSettingActivity.this.getDensity() * 20.0f);
                density2 = (int) (FontSettingActivity.this.getDensity() * 20.0f);
            } else {
                aVar.E.setVisibility(0);
                GuildFeedPicLoader.f231079a.d(Option.obtain().setUrl("https://downv6.qq.com/innovate/guild/sfeed/guild_font_discovery_background.png").setTargetView(aVar.E), null);
                aVar.G.setVisibility(8);
            }
            aVar.F.setPadding(0, density, 0, density2);
            aVar.F.setText(gVar.c());
            if (FontSettingActivity.this.f175737x0 && i3 == FontSettingActivity.this.f175725l0.size() - 1) {
                FontSettingActivity fontSettingActivity = FontSettingActivity.this;
                fontSettingActivity.f175736w0 = true;
                fontSettingActivity.W2();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.e6b, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f175748a;

        /* renamed from: b, reason: collision with root package name */
        private String f175749b;

        public g(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FontSettingActivity.this, str, str2);
            } else {
                this.f175748a = str;
                this.f175749b = str2;
            }
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f175748a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h extends PagerAdapter {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontSettingActivity.this);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(i3), obj);
            } else {
                ((ViewPager) view).removeView(FontSettingActivity.this.f175717d0.get(i3));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return FontSettingActivity.this.f175717d0.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, i3);
            }
            ((ViewPager) view).addView(FontSettingActivity.this.f175717d0.get(i3), 0);
            return FontSettingActivity.this.f175717d0.get(i3);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, obj)).booleanValue();
            }
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class i extends RelativeLayout {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final int f175752d;

        /* renamed from: e, reason: collision with root package name */
        private final CommonImageView f175753e;

        /* renamed from: f, reason: collision with root package name */
        private final AnimationTextView f175754f;

        /* renamed from: h, reason: collision with root package name */
        private final a f175755h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f175756i;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            int f175757a;

            /* renamed from: b, reason: collision with root package name */
            Drawable f175758b;

            /* renamed from: c, reason: collision with root package name */
            int f175759c;

            /* renamed from: d, reason: collision with root package name */
            int f175760d;

            /* renamed from: e, reason: collision with root package name */
            int f175761e;

            /* renamed from: f, reason: collision with root package name */
            int f175762f;

            /* renamed from: g, reason: collision with root package name */
            int f175763g;

            /* renamed from: h, reason: collision with root package name */
            int f175764h;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public static void a(TextView textView, a aVar) {
                textView.setTextColor(aVar.f175757a);
                textView.setBackground(aVar.f175758b);
                textView.setMinWidth(aVar.f175759c);
                textView.setMinHeight(aVar.f175760d);
                textView.setPadding(aVar.f175761e, aVar.f175763g, aVar.f175762f, aVar.f175764h);
            }

            public static a b(Context context, boolean z16) {
                int color;
                Drawable drawable;
                a aVar = new a();
                if (z16) {
                    color = context.getColor(R.color.qui_common_bubble_host_text_primary);
                } else {
                    color = context.getColor(R.color.qui_common_bubble_guest_text_primary);
                }
                aVar.f175757a = color;
                if (z16) {
                    drawable = context.getDrawable(R.drawable.j8t);
                } else {
                    drawable = context.getDrawable(R.drawable.j6v);
                }
                aVar.f175758b = drawable;
                aVar.f175759c = 0;
                aVar.f175760d = 0;
                a.c cVar = a.c.f192425a;
                int b16 = cVar.b() + cVar.e();
                int a16 = cVar.a() + cVar.e();
                int d16 = cVar.d() + cVar.e();
                int c16 = cVar.c() + cVar.e();
                if (z16) {
                    aVar.f175761e = a16;
                    aVar.f175762f = b16;
                } else {
                    aVar.f175761e = b16;
                    aVar.f175762f = a16;
                }
                aVar.f175763g = d16;
                aVar.f175764h = c16;
                return aVar;
            }
        }

        public i(Context context, boolean z16) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
                return;
            }
            this.f175752d = g(40);
            this.f175756i = z16;
            this.f175755h = a.b(context, z16);
            this.f175753e = a();
            this.f175754f = b();
            setPadding(g(9), g(2), g(9), g(2));
        }

        private CommonImageView a() {
            CommonImageView commonImageView = new CommonImageView(getContext());
            commonImageView.setId(R.id.chat_item_head_icon);
            int i3 = this.f175752d;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
            if (this.f175756i) {
                layoutParams.addRule(11);
            } else {
                layoutParams.addRule(9);
            }
            layoutParams.addRule(10);
            layoutParams.setMargins(0, a.c.f192425a.d(), 0, 0);
            addView(commonImageView, layoutParams);
            return commonImageView;
        }

        private AnimationTextView b() {
            AnimationTextView animationTextView = new AnimationTextView(getContext());
            animationTextView.setId(R.id.av_);
            animationTextView.setTextSize(0, getContext().getResources().getDimension(R.dimen.ayp));
            animationTextView.setMaxWidth(a.C7329a.f192417a.b());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f175756i) {
                layoutParams.addRule(0, R.id.chat_item_head_icon);
            } else {
                layoutParams.addRule(1, R.id.chat_item_head_icon);
            }
            layoutParams.addRule(6, R.id.chat_item_head_icon);
            layoutParams.setMargins(0, -a.c.f192425a.d(), 0, 0);
            addView(animationTextView, layoutParams);
            return animationTextView;
        }

        private Drawable d() {
            Bitmap decodeResource = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.mh9);
            AvatarSizeType avatarSizeType = AvatarSizeType.SMALL;
            return new BitmapDrawable(getContext().getResources(), BaseImageUtil.getCircleFaceBitmap(decodeResource, avatarSizeType.getWidth(), avatarSizeType.getHeight()));
        }

        private void e(String str) {
            if (!TextUtils.isEmpty(str) && !AppConstants.VALUE.UIN_QQ_TEAM.equals(str)) {
                b.a aVar = new b.a();
                aVar.g(AvatarSizeType.SMALL);
                aVar.b(Integer.valueOf(R.drawable.f160830com));
                aVar.d(((IAvatarOutboundApi) QRoute.api(IAvatarOutboundApi.class)).getOutboundInfo(str, ""));
                com.tencent.qqnt.avatar.a.a(getContext()).b(this.f175753e).e(aVar.a()).d("", Long.parseLong(str), GlobalScope.INSTANCE);
                return;
            }
            f();
        }

        private void f() {
            this.f175753e.setImageDrawable(d());
        }

        private int g(int i3) {
            return (int) (i3 * getContext().getResources().getDisplayMetrics().density);
        }

        public void c(ChatMessage chatMessage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) chatMessage);
                return;
            }
            e(chatMessage.senderuin);
            a.a(this.f175754f, this.f175755h);
            this.f175754f.setText(chatMessage.f203106msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f175765a;

        /* renamed from: b, reason: collision with root package name */
        public String f175766b;

        /* renamed from: c, reason: collision with root package name */
        public String f175767c;

        /* renamed from: d, reason: collision with root package name */
        public String f175768d;

        /* renamed from: e, reason: collision with root package name */
        public String f175769e;

        /* renamed from: f, reason: collision with root package name */
        public int f175770f;

        public j(int i3, String str, String str2, String str3, String str4, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FontSettingActivity.this, Integer.valueOf(i3), str, str2, str3, str4, Integer.valueOf(i16));
                return;
            }
            this.f175765a = i3;
            this.f175766b = str;
            this.f175767c = str2;
            this.f175768d = str3;
            this.f175769e = str4;
            this.f175770f = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k extends BaseAdapter implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private LayoutInflater f175772d;

        /* renamed from: e, reason: collision with root package name */
        private com.tencent.mobileqq.activity.recent.i f175773e;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            String f175775a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f175776b;

            /* renamed from: c, reason: collision with root package name */
            j f175777c;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
                }
            }
        }

        public k(Context context, QQAppInterface qQAppInterface, ListView listView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FontSettingActivity.this, context, qQAppInterface, listView);
            } else {
                this.f175772d = FontSettingActivity.this.getLayoutInflater();
                this.f175773e = new com.tencent.mobileqq.activity.recent.i(qQAppInterface, this);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                this.f175773e.r();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return FontSettingActivity.this.f175733t0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return FontSettingActivity.this.f175733t0.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                View inflate = this.f175772d.inflate(R.layout.f169058bw0, viewGroup, false);
                j jVar = FontSettingActivity.this.f175733t0.get(i3);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
                imageView.setImageDrawable(this.f175773e.e(jVar.f175770f, jVar.f175769e));
                ((TextView) inflate.findViewById(android.R.id.text1)).setText(jVar.f175766b);
                ((TextView) inflate.findViewById(android.R.id.text2)).setText(jVar.f175767c);
                ((TextView) inflate.findViewById(R.id.lastMsgTime)).setText(jVar.f175768d);
                a aVar = new a();
                aVar.f175775a = jVar.f175769e;
                aVar.f175776b = imageView;
                aVar.f175777c = jVar;
                inflate.setTag(aVar);
                if (FontSettingActivity.this.f175737x0 && i3 == FontSettingActivity.this.f175733t0.size() - 1) {
                    FontSettingActivity fontSettingActivity = FontSettingActivity.this;
                    fontSettingActivity.f175735v0 = true;
                    fontSettingActivity.W2();
                }
                view2 = inflate;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            int childCount = FontSettingActivity.this.f175719f0.getChildCount();
            if (bitmap != null) {
                a aVar = null;
                for (int i17 = 0; i17 < childCount; i17++) {
                    Object tag = FontSettingActivity.this.f175719f0.getChildAt(i17).getTag();
                    if (tag != null && (tag instanceof a)) {
                        aVar = (a) tag;
                        if (aVar.f175775a.equals(str)) {
                            break;
                        }
                    }
                }
                if (aVar != null) {
                    aVar.f175776b.setImageBitmap(bitmap);
                    notifyDataSetChanged();
                }
            }
        }
    }

    public FontSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175717d0 = new ArrayList<>();
        this.f175725l0 = new ArrayList();
        this.f175726m0 = 0;
        this.f175733t0 = new ArrayList<>();
        this.f175734u0 = false;
        this.f175735v0 = false;
        this.f175736w0 = false;
        this.f175737x0 = false;
        this.f175738y0 = 16.0f;
        this.A0 = null;
        this.B0 = null;
        this.C0 = false;
        this.D0 = new e();
    }

    private ListView N2() {
        ListView listView = new ListView(this);
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        ((ViewGroup.LayoutParams) layoutParams).height = -1;
        ((ViewGroup.LayoutParams) layoutParams).width = -1;
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setContentBackground(R.drawable.qui_common_bg_bottom_standard_bg);
        return listView;
    }

    private RecyclerView P2() {
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        ((ViewGroup.LayoutParams) layoutParams).height = -1;
        ((ViewGroup.LayoutParams) layoutParams).width = -1;
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setPadding((int) (getDensity() * 7.0f), (int) (getDensity() * 9.0f), (int) (getDensity() * 7.0f), (int) (getDensity() * 9.0f));
        return recyclerView;
    }

    private void Q2() {
        ViewGroup viewGroup;
        this.f175721h0 = (ViewGroup) findViewById(R.id.title_container);
        QUISecNavBar qUISecNavBar = new QUISecNavBar(this);
        qUISecNavBar.setLeftType(2);
        qUISecNavBar.setRightType(1);
        qUISecNavBar.setCenterType(1);
        qUISecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_navigation_02);
        qUISecNavBar.setCenterText(HardCodeUtil.qqStr(R.string.f171994mn3));
        qUISecNavBar.setRightText(HardCodeUtil.qqStr(R.string.h3s));
        qUISecNavBar.R(this);
        boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
        boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
        if (isSettingPageNavNeedBlur) {
            viewGroup = this.f175721h0;
        } else {
            viewGroup = null;
        }
        qUISecNavBar.setBlur(isSettingPageNavNeedBlur, viewGroup);
        if (isSettingPageNavNeedAlpha) {
            if (isSettingPageNavNeedBlur) {
                qUISecNavBar.setTitleBlurAlpha(0.0f);
            } else {
                qUISecNavBar.setTitleAlpha(0.0f);
            }
        }
        qUISecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new a());
        qUISecNavBar.setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new b());
        this.f175721h0.addView(qUISecNavBar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2() {
        FontSettingManager.setCustomDensity(this, FontSettingManager.getFontLevel(), false);
        finish();
    }

    private int S2() {
        float fontLevel = FontSettingManager.getFontLevel();
        this.f175738y0 = fontLevel;
        if (fontLevel == 13.92f) {
            return 0;
        }
        if (fontLevel == 15.0f) {
            return 1;
        }
        if (fontLevel == 16.0f) {
            return 2;
        }
        if (fontLevel == 17.0f) {
            return 3;
        }
        if (fontLevel == 18.0f) {
            return 4;
        }
        if (fontLevel != 21.24f) {
            return 2;
        }
        return 5;
    }

    private void T2() {
        this.f175725l0.clear();
        g gVar = new g("\u8bbe\u7f6e\u5b57\u4f53\u5927\u5c0f", "11");
        g gVar2 = new g("\u8c03\u8282\u559c\u6b22\u7684\u5b57\u4f53\u5927\u5c0f\uff0c\u83b7\u53d6\u8212\u9002\u7684\u9605\u8bfb\u4f53\u9a8c", "11");
        g gVar3 = new g("\u62d6\u52a8\u4e0b\u65b9\u7684\u6ed1\u5757\uff0c\u53ef\u4ee5\u8bbe\u7f6e\u754c\u9762\u4e2d\u7684\u5b57\u4f53\u5927\u5c0f\u3002\n\u8bbe\u7f6e\u540e\uff0c\u4f1a\u6539\u53d8\u9891\u9053\u4e2d\u7684\u5b57\u4f53\u5927\u5c0f\u663e\u793a\u3002", "");
        this.f175725l0.add(gVar);
        this.f175725l0.add(gVar2);
        this.f175725l0.add(gVar3);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        this.f175730q0 = staggeredGridLayoutManager;
        staggeredGridLayoutManager.setGapStrategy(0);
        this.f175720g0.setLayoutManager(this.f175730q0);
        f fVar = new f(this.f175725l0);
        this.f175729p0 = fVar;
        this.f175720g0.setAdapter(fVar);
    }

    private void U2() {
        if (this.f175731r0 == null) {
            this.f175731r0 = new ArrayList();
            MessageForText messageForText = new MessageForText();
            messageForText.frienduin = AppConstants.VALUE.UIN_QQ_TEAM;
            messageForText.senderuin = AppConstants.VALUE.UIN_QQ_TEAM;
            messageForText.issend = 1000;
            String qqStr = HardCodeUtil.qqStr(R.string.mnb);
            messageForText.f203106msg = qqStr;
            messageForText.charStr = qqStr;
            MessageForText messageForText2 = new MessageForText();
            String currentAccountUin = this.app.getCurrentAccountUin();
            messageForText2.frienduin = currentAccountUin;
            messageForText2.selfuin = currentAccountUin;
            messageForText2.senderuin = currentAccountUin;
            messageForText2.issend = 1;
            String qqStr2 = HardCodeUtil.qqStr(R.string.f171993mn2);
            messageForText2.f203106msg = qqStr2;
            messageForText2.charStr = qqStr2;
            messageForText2.vipBubbleID = ((ISVIPHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getSelfBubbleId();
            MessageForText messageForText3 = new MessageForText();
            messageForText3.frienduin = AppConstants.VALUE.UIN_QQ_TEAM;
            messageForText3.senderuin = AppConstants.VALUE.UIN_QQ_TEAM;
            messageForText3.issend = 1000;
            String qqStr3 = HardCodeUtil.qqStr(R.string.mn5);
            messageForText3.f203106msg = qqStr3;
            messageForText3.charStr = qqStr3;
            this.f175731r0.add(messageForText);
            this.f175731r0.add(messageForText2);
            this.f175731r0.add(messageForText3);
            SessionInfo sessionInfo = new SessionInfo();
            this.f175732s0 = sessionInfo;
            sessionInfo.f179555d = 0;
            sessionInfo.N = ChatTextSizeSettingActivity.H2(this);
            this.f175732s0.f178171h0 = new com.tencent.mobileqq.activity.aio.t();
            String currentAccountUin2 = this.app.getCurrentAccountUin();
            SessionInfo sessionInfo2 = this.f175732s0;
            if (com.tencent.mobileqq.activity.aio.t.c(this, currentAccountUin2, "0", sessionInfo2.f179555d, true, 7, sessionInfo2.f178171h0)) {
                this.f175718e0.setBackgroundDrawable(this.f175732s0.f178171h0.f179996c);
            }
        }
    }

    private void V2() {
        j jVar = new j(0, HardCodeUtil.qqStr(R.string.izb), HardCodeUtil.qqStr(R.string.mn6), "3:28PM", AppConstants.VALUE.UIN_QQ_TEAM, 0);
        j jVar2 = new j(R.drawable.icon_recent_subaccount, HardCodeUtil.qqStr(R.string.ilx), HardCodeUtil.qqStr(R.string.f171992mn1), "3:28PM", AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
        j jVar3 = new j(R.drawable.icon_recent_troop_assistant, HardCodeUtil.qqStr(R.string.ihp), HardCodeUtil.qqStr(R.string.mn7), "3:28PM", AppConstants.TROOP_ASSISTANT_UIN, 5000);
        j jVar4 = new j(R.drawable.qfile_dataline_pc_recent, HardCodeUtil.qqStr(R.string.cf5), HardCodeUtil.qqStr(R.string.mn8), "3:28PM", AppConstants.DATALINE_PC_UIN, 6000);
        j jVar5 = new j(0, HardCodeUtil.qqStr(R.string.mnc), HardCodeUtil.qqStr(R.string.f171995mn4), "3:28PM", IPublicAccountBrowser.PUB_COUPON_UIN, 0);
        this.f175733t0.add(jVar);
        this.f175733t0.add(jVar2);
        this.f175733t0.add(jVar3);
        this.f175733t0.add(jVar4);
        this.f175733t0.add(jVar5);
    }

    private void Y2() {
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.app.getApp().getSystemService("accessibility");
            boolean isEnabled = accessibilityManager.isEnabled();
            boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (isEnabled && isTouchExplorationEnabled) {
                this.f175722i0.startEnableTalkback();
            }
        } catch (Throwable th5) {
            QLog.i("qqBaseActivity", 1, "[setEnableTalkback]", th5);
        }
    }

    private void b3() {
        if (this.f175739z0 == null) {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null && (childAt instanceof ViewGroup)) {
                viewGroup = (ViewGroup) childAt;
            }
            if (viewGroup instanceof TopGestureLayout) {
                this.f175739z0 = (TopGestureLayout) viewGroup;
            }
            TopGestureLayout topGestureLayout = this.f175739z0;
            if (topGestureLayout != null) {
                topGestureLayout.setInterceptTouchFlag(false);
            }
        }
    }

    private void initViews() {
        Q2();
        this.f175714a0 = (ViewPager) findViewById(R.id.ci6);
        h hVar = new h();
        this.f175716c0 = hVar;
        this.f175714a0.setAdapter(hVar);
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) findViewById(R.id.chx);
        this.f175715b0 = circlePageIndicator;
        circlePageIndicator.setViewPager(this.f175714a0);
        this.f175715b0.setCirclePadding((int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics()));
        this.f175718e0 = N2();
        U2();
        this.f175717d0.add(this.f175718e0);
        AioListAdapter aioListAdapter = new AioListAdapter();
        this.f175727n0 = aioListAdapter;
        this.f175718e0.setAdapter((ListAdapter) aioListAdapter);
        this.f175724k0 = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
        V2();
        this.f175719f0 = N2();
        Z2();
        this.f175728o0 = new k(this, this.app, this.f175719f0);
        this.f175717d0.add(this.f175719f0);
        this.f175719f0.setAdapter((ListAdapter) this.f175728o0);
        this.f175720g0 = P2();
        T2();
        this.f175717d0.add(this.f175720g0);
        this.f175716c0.notifyDataSetChanged();
        this.f175722i0 = (RangeButtonView) findViewById(R.id.f165257ci0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RangeButtonView.Title(HardCodeUtil.qqStr(R.string.mna), TypedValue.applyDimension(1, 13.92f, FontSettingManager.systemMetrics)));
        arrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 15.0f, FontSettingManager.systemMetrics)));
        arrayList.add(new RangeButtonView.Title(HardCodeUtil.qqStr(R.string.mn_), TypedValue.applyDimension(1, 16.0f, FontSettingManager.systemMetrics)));
        arrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0f, FontSettingManager.systemMetrics)));
        arrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 18.0f, FontSettingManager.systemMetrics)));
        arrayList.add(new RangeButtonView.Title(HardCodeUtil.qqStr(R.string.mn9), TypedValue.applyDimension(1, 21.24f, FontSettingManager.systemMetrics)));
        this.f175722i0.setTitleData(arrayList);
        this.f175722i0.setOnChangerListener(this);
        this.f175722i0.setThumbPosition(S2());
        Y2();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(getString(R.string.a_r));
        arrayList2.add(getString(R.string.a_s));
        arrayList2.add(getString(R.string.a_t));
        arrayList2.add(getString(R.string.a_u));
        arrayList2.add(getString(R.string.a_v));
        arrayList2.add(getString(R.string.f170785zo4));
        this.f175722i0.setContentDescList(arrayList2);
        this.f175726m0 = getResources().getConfiguration().screenWidthDp;
        if (getIntent() == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("source");
        if (!TextUtils.isEmpty(stringExtra) && "guild".equals(stringExtra)) {
            this.f175714a0.setCurrentItem(2);
        }
    }

    public void W2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.f175737x0 && this.f175734u0 && this.f175735v0 && this.f175736w0) {
            this.f175736w0 = false;
            this.f175735v0 = false;
            this.f175734u0 = false;
            this.f175737x0 = false;
            FontSettingManager.revertToLastDendisy(this);
        }
    }

    void Z2() {
        Drawable drawable;
        if (this.f175719f0 == null) {
            return;
        }
        if (!ThemeBackground.getThemeBackgroundEnable()) {
            this.f175719f0.setContentBackground(R.drawable.bg_texture_theme_version2);
            this.A0 = null;
            return;
        }
        if (this.A0 == null) {
            this.A0 = new ThemeBackground();
        }
        if (ThemeBackground.getThemeBackground(this.f175719f0.getContext(), AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH_PNG, this.app.getCurrentAccountUin(), this.A0)) {
            if (!"null".equals(this.A0.path) && (drawable = this.A0.img) != null) {
                if (drawable != null) {
                    this.f175719f0.setContentBackground(drawable);
                }
            } else {
                this.f175719f0.setContentBackground(R.drawable.bg_texture_theme_version2);
                this.A0 = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            R2();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) configuration);
            return;
        }
        super.doOnConfigurationChanged(configuration);
        int i3 = configuration.screenWidthDp;
        if (this.f175726m0 != i3) {
            this.f175726m0 = i3;
            RangeButtonView rangeButtonView = this.f175722i0;
            if (rangeButtonView != null) {
                rangeButtonView.clearTitleDrawer();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(14)
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = false;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.setContentView(R.layout.f168808av1);
        this.f175723j0 = (ViewGroup) findViewById(R.id.root);
        this.app.setHandler(FontSettingActivity.class, this.D0);
        initViews();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.f175728o0.a();
        this.app.removeHandler(FontSettingActivity.class);
        IFaceDecoder iFaceDecoder = this.f175724k0;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnResume();
            b3();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean enableCheckDensity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Resources) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Resources resources = super.getResources();
        if (System.identityHashCode(resources.getDisplayMetrics()) != System.identityHashCode(resources.getDisplayMetrics())) {
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            float f16 = this.f175738y0 / 16.0f;
            DisplayMetrics displayMetrics2 = FontSettingManager.systemMetrics;
            displayMetrics.density = displayMetrics2.density * f16;
            displayMetrics.scaledDensity = displayMetrics2.density * f16;
            int i3 = (int) (displayMetrics2.densityDpi * f16);
            displayMetrics.densityDpi = i3;
            configuration.densityDpi = i3;
            resources.updateConfiguration(configuration, displayMetrics);
        }
        return resources;
    }

    @Override // com.tencent.widget.RangeButtonView.OnChangeListener
    public void onChange(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 == i16) {
            return;
        }
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 == 5) {
                                this.f175738y0 = 21.24f;
                            }
                        } else {
                            this.f175738y0 = 18.0f;
                        }
                    } else {
                        this.f175738y0 = 17.0f;
                    }
                } else {
                    this.f175738y0 = 16.0f;
                }
            } else {
                this.f175738y0 = 15.0f;
            }
        } else {
            this.f175738y0 = 13.92f;
        }
        ReportController.o(this.app, "CliOper", "", "", "0X8004FA2", "0X8004FA2", 0, 0, "" + ((int) this.f175738y0), "", "", "");
        ReportController.o(this.app, "CliOper", "", "", "0X800BE7E", "0X800BE7E", i16 + 1, 0, "", "", "", "");
        this.f175737x0 = FontSettingManager.setCustomDensity(this, this.f175738y0, false) ^ true;
        this.f175732s0.N = ChatTextSizeSettingActivity.H2(this);
        this.f175719f0.removeAllViewsInLayout();
        this.f175718e0.removeAllViewsInLayout();
        T2();
        this.f175727n0.notifyDataSetChanged();
        this.f175728o0.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    void showDialog() {
        if (this.f175738y0 == FontSettingManager.getFontLevel()) {
            finish();
            return;
        }
        this.B0 = DialogUtil.createCustomDialog(this, 0, getResources().getString(R.string.bbh), getResources().getString(R.string.bbf), R.string.bbe, R.string.bbg, new c(), new d());
        if (!isFinishing()) {
            this.B0.show();
        }
    }
}
