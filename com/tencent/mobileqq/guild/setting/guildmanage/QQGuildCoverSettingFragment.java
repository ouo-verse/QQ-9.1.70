package com.tencent.mobileqq.guild.setting.guildmanage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.common.upload.GuildCgiUploader;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.setting.guildmanage.QQGuildCoverSettingFragment;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildCoverSettingFragment extends QPublicBaseFragment implements View.OnClickListener {
    private IGProGuildInfo C;
    private Button D;
    private LinearLayout E;
    private GuildCgiUploader F;
    private ImageView G;
    private URLImageView H;
    private RelativeLayout I;
    private TextView J;
    private ImageView K;
    private AppInterface L;
    private String M;
    private String N = "";
    public final String P = "PhotoConst.SINGLE_PHOTO_PATH";
    private GPServiceObserver Q = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements Function1<Integer, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f233622d;

        a(FragmentActivity fragmentActivity) {
            this.f233622d = fragmentActivity;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Integer num) {
            FragmentActivity fragmentActivity = this.f233622d;
            if (fragmentActivity != null) {
                fragmentActivity.finish();
                return null;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(QQGuildCoverSettingFragment.this.M) && TextUtils.equals(QQGuildCoverSettingFragment.this.M, str)) {
                super.onGuildInfoUpdated(str);
                if (QQGuildCoverSettingFragment.this.getAppInterface() != null) {
                    QQGuildCoverSettingFragment qQGuildCoverSettingFragment = QQGuildCoverSettingFragment.this;
                    qQGuildCoverSettingFragment.C = ((IGPSService) qQGuildCoverSettingFragment.getAppInterface().getRuntimeService(IGPSService.class, "")).getGuildInfo(str);
                    QQGuildCoverSettingFragment qQGuildCoverSettingFragment2 = QQGuildCoverSettingFragment.this;
                    qQGuildCoverSettingFragment2.xh(qQGuildCoverSettingFragment2.C);
                    return;
                }
                return;
            }
            QLog.e("Guild.mnr.QQGuildCoverSettingFragment", 1, "GuildInfo or GuildId is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements IUploadApi.b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(IUploadApi.c cVar, IUploadApi.d dVar) {
            QQGuildCoverSettingFragment.this.yh(cVar, dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(IUploadApi.c cVar, IUploadApi.d dVar) {
            QQGuildCoverSettingFragment.this.Ah(cVar, dVar);
        }

        @Override // com.tencent.mobileqq.guild.nt.misc.api.IUploadApi.b
        public void a(final IUploadApi.c cVar, final IUploadApi.d dVar) {
            QLog.i("Guild.mnr.QQGuildCoverSettingFragment", 2, "task: " + cVar + " " + dVar);
            int i3 = dVar.f230931a;
            if (i3 == 0) {
                QQGuildCoverSettingFragment.this.zh(cVar, dVar);
            } else if (i3 == 1) {
                QQGuildCoverSettingFragment.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQGuildCoverSettingFragment.c.this.e(cVar, dVar);
                    }
                });
            } else if (i3 == 2) {
                QQGuildCoverSettingFragment.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQGuildCoverSettingFragment.c.this.d(cVar, dVar);
                    }
                });
            }
        }
    }

    private void Bh(String str) {
        com.tencent.mobileqq.guild.performance.report.n.b(str, "1");
    }

    public static void Ch(Context context, IGProGuildInfo iGProGuildInfo, int i3) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_guild_guild_info", iGProGuildInfo);
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, QQGuildCoverSettingFragment.class, i3);
    }

    private void initData() {
        IGProGuildInfo iGProGuildInfo = (IGProGuildInfo) getActivity().getIntent().getExtras().getSerializable("extra_guild_guild_info");
        this.C = iGProGuildInfo;
        if (iGProGuildInfo == null) {
            QLog.e("Guild.mnr.QQGuildCoverSettingFragment", 1, "GuildInfo is null");
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f157721no, 1).show();
            getActivity().finish();
            return;
        }
        String guildID = iGProGuildInfo.getGuildID();
        this.M = guildID;
        if (TextUtils.isEmpty(guildID)) {
            QLog.e("Guild.mnr.QQGuildCoverSettingFragment", 1, "GuildId is null");
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f157721no, 1).show();
            getActivity().finish();
        } else {
            this.F = new GuildCgiUploader(vh(), this.C.getGuildID());
            xh(this.C);
            ((IGPSService) getQBaseActivity().getAppRuntime().getRuntimeService(IGPSService.class, "")).addObserver(this.Q);
        }
    }

    private void initDtReport() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.I, "pg_sgrp_channel_cover_set");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", this.M);
        hashMap.put("sgrp_duration_flag", 1);
        VideoReport.setPageParams(this.I, new PageParams(hashMap));
    }

    private void initView() {
        Button button = (Button) this.I.findViewById(R.id.f164655td4);
        this.D = button;
        button.setOnClickListener(this);
        this.D.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) this.I.findViewById(R.id.td6);
        this.E = linearLayout;
        linearLayout.setVisibility(8);
        ImageView imageView = (ImageView) this.I.findViewById(R.id.f165457w34);
        this.G = imageView;
        imageView.setImageDrawable(com.tencent.mobileqq.guild.util.qqui.d.d(getContext(), 1));
        this.H = (URLImageView) this.I.findViewById(R.id.f165455w32);
        this.K = (ImageView) this.I.findViewById(R.id.u_p);
        this.J = (TextView) this.I.findViewById(R.id.f165456w33);
        this.K.setOnClickListener(this);
        ((RelativeLayout.LayoutParams) this.H.getLayoutParams()).height = bi.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnUiThread(Runnable runnable) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(runnable);
    }

    private static void showToast(String str, int i3) {
        QQToast.makeText(BaseApplication.getContext(), i3, str, 1).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    private String vh() {
        return getQBaseActivity().getAppRuntime().getCurrentUin();
    }

    private void wh(Intent intent) {
        this.D.setVisibility(8);
        this.E.setVisibility(0);
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.mnr.QQGuildCoverSettingFragment", 2, String.format("doOnNewIntent path=%s", stringExtra));
            }
            this.N = stringExtra;
            Bh(stringExtra);
            this.F.f(stringExtra, com.tencent.mobileqq.guild.common.upload.c.guildCover, com.tencent.mobileqq.guild.common.upload.b.a(), new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo != null) {
            this.D.setVisibility(0);
            this.E.setVisibility(8);
            this.H.getLayoutParams().height = (int) (bi.d() * 0.46629214f);
            if (TextUtils.isEmpty(iGProGuildInfo.getCanBeEmptyCoverUrl(0, 0))) {
                this.H.setBackgroundColor(getResources().getColor(R.color.ajr));
                this.J.setVisibility(0);
                TextView textView = this.J;
                textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_secondary));
                this.D.setText(R.string.f158501ps);
                return;
            }
            this.D.setText(R.string.f155981iz);
            this.H.setBackgroundColor(getResources().getColor(R.color.black));
            this.J.setVisibility(4);
            String canBeEmptyCoverUrl = iGProGuildInfo.getCanBeEmptyCoverUrl(0, 0);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            int d16 = bi.d();
            obtain.mRequestWidth = d16;
            obtain.mRequestHeight = d16;
            try {
                URLDrawable drawable = URLDrawable.getDrawable(canBeEmptyCoverUrl, obtain);
                this.H.setImageDrawable(drawable);
                drawable.setTag(new int[]{d16, d16});
                drawable.setDecodeHandler(ch.f235513f);
            } catch (Exception e16) {
                QLog.e("Guild.mnr.QQGuildCoverSettingFragment", 1, e16, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zh(IUploadApi.c cVar, IUploadApi.d dVar) {
        QLog.i("Guild.mnr.QQGuildCoverSettingFragment", 2, "onUploadProgress: " + dVar.f230933c);
    }

    public void Ah(IUploadApi.c cVar, IUploadApi.d dVar) {
        String str;
        int i3 = 0;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.mnr.QQGuildCoverSettingFragment", 2, "onUploadSuccess state:", cVar.getTaskState(), "state:", dVar);
        }
        FragmentActivity activity = getActivity();
        GuildCgiUploader.b c16 = GuildCgiUploader.b.c(dVar.f230934d);
        if (c16.e()) {
            SecurityTipHelperKt.L(c16.f215492c, activity, dVar.f230932b, "", false, new a(activity));
        } else {
            int i16 = c16.f215490a;
            if (i16 == 0) {
                str = "\u5df2\u63d0\u4ea4\u5ba1\u6838\uff0c\u901a\u8fc7\u540e\u751f\u6548";
            } else {
                str = c16.f215491b;
            }
            if (i16 == 0) {
                i3 = 2;
            }
            showToast(str, i3);
            if (activity != null) {
                activity.setResult(-1);
                activity.finish();
            }
        }
        com.tencent.mobileqq.guild.performance.report.n.a("1", this.N, c16);
    }

    public AppInterface getAppInterface() {
        if (getQBaseActivity().getAppRuntime() instanceof AppInterface) {
            return (AppInterface) getQBaseActivity().getAppRuntime();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            cz1.a.c(getActivity(), 102);
        } else if (view == this.K) {
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    @SuppressLint({"InflateParams"})
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.I = (RelativeLayout) layoutInflater.inflate(R.layout.ev5, (ViewGroup) null);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.I.setFitsSystemWindows(true);
        }
        this.L = getAppInterface();
        initView();
        initData();
        initDtReport();
        RelativeLayout relativeLayout = this.I;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, relativeLayout);
        return relativeLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((IGPSService) getQBaseActivity().getAppRuntime().getRuntimeService(IGPSService.class, "")).deleteObserver(this.Q);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        wh(intent);
    }

    public void yh(IUploadApi.c cVar, IUploadApi.d dVar) {
        int i3 = 0;
        this.D.setVisibility(0);
        this.E.setVisibility(8);
        GuildCgiUploader.b b16 = GuildCgiUploader.b.b(dVar);
        String str = b16.f215491b;
        if (b16.f215490a == 0) {
            i3 = 2;
        }
        showToast(str, i3);
        com.tencent.mobileqq.guild.performance.report.n.a("1", this.N, b16);
    }
}
