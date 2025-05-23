package com.tencent.mobileqq.profile.musicbox;

import QQService.EVIPSPEC;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi;
import com.tencent.mobileqq.listentogether.k;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.pb.profilecard.VaProfileGate$CommTaskInfo;
import com.tencent.pb.profilecard.VipMusicBox$GetProfileMusicBoxInfoRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import com.tencent.widget.AlphaClickableImageView;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements View.OnClickListener, k {
    static IPatchRedirector $redirector_;
    private boolean C;
    private String D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private String f260259d;

    /* renamed from: e, reason: collision with root package name */
    private Context f260260e;

    /* renamed from: f, reason: collision with root package name */
    private AlphaClickableImageView f260261f;

    /* renamed from: h, reason: collision with root package name */
    private View f260262h;

    /* renamed from: i, reason: collision with root package name */
    private SongInfo f260263i;

    /* renamed from: m, reason: collision with root package name */
    private int f260264m;

    public a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.f260259d = "";
        this.f260263i = new SongInfo();
        this.D = "";
        this.E = false;
        this.G = false;
        this.H = true;
        this.F = z16;
    }

    public static boolean e(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo == null || (card = profileCardInfo.card) == null || card.switchMusicBox != 0) {
            return false;
        }
        if (ProfileCardFeatureSwitch.INSTANCE.isMusicBoxEmptyItemFoldEnable() && TextUtils.isEmpty(profileCardInfo.card.songId)) {
            return false;
        }
        return true;
    }

    public static boolean f() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!VasUtil.getSignedService(runtime).getVipStatus().isSVip() && !VasUtil.getSignedService(runtime).getVipStatus().isBigClub()) {
            return false;
        }
        return true;
    }

    public static boolean g(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            int i3 = 1;
            if (profileCardInfo.allInOne.f260789pa == 0) {
                if (card.switchMusicBox != 0) {
                    i3 = 2;
                }
                ReportController.o(null, "dc00898", "", "", "0X800A7DB", QQPermissionConstants.Business.SCENE.QQ_VIP, i3, 0, "", "", "", "");
                return e(profileCardInfo);
            }
            boolean isVipOpen = card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
            boolean isVipOpen2 = profileCardInfo.card.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
            Card card2 = profileCardInfo.card;
            if (card2.switchMusicBox == 0 && !TextUtils.isEmpty(card2.songId) && (isVipOpen || isVipOpen2)) {
                return true;
            }
        }
        return false;
    }

    public static void i(Context context, String str) {
        String addParameter = URLUtil.addParameter(QVipProfileMusicBoxProcessor.getConfig().playerUrl, "uin", str);
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(context, addParameter);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("url", addParameter);
        context.startActivity(intent);
    }

    public static void j(VaProfileGate$CommTaskInfo vaProfileGate$CommTaskInfo, Card card) {
        int i3;
        int i16;
        VipMusicBox$GetProfileMusicBoxInfoRsp vipMusicBox$GetProfileMusicBoxInfoRsp = new VipMusicBox$GetProfileMusicBoxInfoRsp();
        try {
            vipMusicBox$GetProfileMusicBoxInfoRsp.mergeFrom(vaProfileGate$CommTaskInfo.bytes_task_data.get().toByteArray());
            card.coverUrl = vipMusicBox$GetProfileMusicBoxInfoRsp.music.pic.get();
            StringBuilder sb5 = new StringBuilder();
            for (int i17 = 0; i17 < vipMusicBox$GetProfileMusicBoxInfoRsp.music.singer_list.size(); i17++) {
                if (i17 != 0) {
                    sb5.append("/");
                }
                sb5.append(vipMusicBox$GetProfileMusicBoxInfoRsp.music.singer_list.get(i17).singer_name.get());
            }
            card.singer = sb5.toString();
            card.songId = vipMusicBox$GetProfileMusicBoxInfoRsp.music.song_id.get();
            card.songName = vipMusicBox$GetProfileMusicBoxInfoRsp.music.song_name.get();
            card.songDuration = vipMusicBox$GetProfileMusicBoxInfoRsp.music.duration.get();
            int i18 = 2;
            if (QLog.isColorLevel()) {
                QLog.e("ProfileMusicBox", 2, "card songId :" + card.songId + " " + card.songName);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (qQAppInterface != null) {
                if (qQAppInterface.getAccount().equalsIgnoreCase(card.uin)) {
                    if (f()) {
                        if (!TextUtils.isEmpty(card.songId)) {
                            i16 = 1;
                            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A7D6", i16, 0, "", "", "", "");
                            return;
                        }
                    } else {
                        i18 = 3;
                    }
                    i16 = i18;
                    ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A7D6", i16, 0, "", "", "", "");
                    return;
                }
                String str = card.uin;
                if (f()) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                ReportController.o(null, "dc00898", "", str, QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A7DC", i3, 0, "", "", "", "");
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.listentogether.k
    public void a(SongInfo songInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, songInfo, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ProfileMusicBox", 2, "update :" + songInfo.f251871i);
        }
        if (songInfo.f251869f != Long.parseLong(this.f260259d)) {
            return;
        }
        this.f260263i = songInfo;
        this.C = z16;
        if (this.F) {
            ((TextView) this.f260262h.findViewById(R.id.m99)).setText(songInfo.f251871i);
            ((TextView) this.f260262h.findViewById(R.id.m98)).setText(songInfo.F);
            l(songInfo.C);
            return;
        }
        ((TextView) this.f260262h.findViewById(R.id.m9_)).setText(songInfo.f251871i + "-" + songInfo.F);
        if (!this.C) {
            i3 = 2;
        }
        b(i3);
    }

    @Override // com.tencent.mobileqq.listentogether.k
    @SuppressLint({"NewApi"})
    public void b(int i3) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (this.F) {
            if (i3 == 1) {
                this.f260261f.setImageResource(R.drawable.qq_aio_listentogether_pause);
                this.f260261f.setContentDescription("\u6682\u505c\u97f3\u4e50");
                return;
            } else {
                this.f260261f.setImageResource(R.drawable.qq_aio_listentogether_play);
                this.f260261f.setContentDescription("\u64ad\u653e\u97f3\u4e50");
                return;
            }
        }
        TextView textView = (TextView) this.f260262h.findViewById(R.id.m9_);
        textView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0f));
        Resources resources = this.f260260e.getResources();
        if (i3 == 1) {
            drawable = resources.getDrawable(R.drawable.hzw);
        } else {
            drawable = resources.getDrawable(R.drawable.hzx);
        }
        drawable.setTint(resources.getColor(R.color.qui_common_icon_secondary));
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (this.G && !this.F) {
            this.f260262h.findViewById(R.id.m9_).setVisibility(8);
        }
    }

    public View d(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
        }
        this.f260259d = str;
        this.f260260e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ccx, (ViewGroup) null);
        this.f260262h = inflate;
        inflate.setOnClickListener(this);
        if (this.F) {
            this.f260262h.findViewById(R.id.llw).setOnClickListener(this);
            this.f260262h.findViewById(R.id.f166908j24).setOnClickListener(this);
            this.f260261f = (AlphaClickableImageView) this.f260262h.findViewById(R.id.f166908j24);
            this.f260262h.findViewById(R.id.m9_).setVisibility(8);
        } else {
            this.f260262h.findViewById(R.id.m9_).setOnClickListener(this);
            this.f260262h.findViewById(R.id.llw).setVisibility(8);
        }
        b(2);
        this.f260264m = BaseAIOUtils.f(35.0f, context.getResources());
        ((IListenTogetherManagerApi) QRoute.api(IListenTogetherManagerApi.class)).setPlayChange(this);
        return this.f260262h;
    }

    public void h(Context context, String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) str);
            return;
        }
        String addParameter = URLUtil.addParameter(QVipProfileMusicBoxProcessor.getConfig().musicBoxUrl, "uin", str);
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(context, addParameter);
        } else {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", addParameter);
            context.startActivity(intent);
        }
        if (f()) {
            if (this.G) {
                i3 = 2;
            } else {
                i3 = 1;
            }
        } else {
            i3 = 3;
        }
        ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A7D7", i3, 0, "", "", "", "");
    }

    public void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        this.G = z16;
        if (!this.F) {
            TextView textView = (TextView) this.f260262h.findViewById(R.id.m9_);
            if (z16) {
                textView.setVisibility(8);
                return;
            } else {
                textView.setVisibility(0);
                return;
            }
        }
        if (z16) {
            this.f260262h.findViewById(R.id.bwr).setVisibility(0);
            this.f260262h.findViewById(R.id.f166908j24).setVisibility(8);
            this.f260262h.findViewById(R.id.lwj).setVisibility(8);
        } else {
            this.f260262h.findViewById(R.id.bwr).setVisibility(8);
            this.f260262h.findViewById(R.id.f166908j24).setVisibility(0);
            this.f260262h.findViewById(R.id.lwj).setVisibility(0);
        }
    }

    public void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (this.D.equals(str)) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = this.f260262h.getContext().getResources().getDrawable(R.drawable.qq_aio_listentogether_nosong);
        obtain.mFailedDrawable = this.f260262h.getContext().getResources().getDrawable(R.drawable.qq_aio_listentogether_nosong);
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        int i3 = 1;
        drawable.setTag(new int[]{this.f260264m / 2});
        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306346z);
        drawable.startDownload();
        this.f260262h.findViewById(R.id.f166908j24).setBackgroundDrawable(drawable);
        if (!this.C) {
            i3 = 2;
        }
        b(i3);
    }

    public void m(ProfileCardInfo profileCardInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) profileCardInfo);
            return;
        }
        Card card = profileCardInfo.card;
        boolean isVipOpen = card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
        boolean isVipOpen2 = card.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
        if (!isVipOpen && !isVipOpen2) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.E = z16;
        if (TextUtils.isEmpty(card.songId)) {
            k(true);
        } else {
            k(false);
            SongInfo b06 = QQPlayerService.b0();
            if (b06 != null && b06.f251869f == Long.parseLong(this.f260259d)) {
                this.f260263i = b06;
                b(QQPlayerService.m0());
            } else {
                SongInfo songInfo = this.f260263i;
                songInfo.f251871i = card.songName;
                songInfo.C = card.coverUrl;
                songInfo.F = card.singer;
                songInfo.E = card.songId;
                songInfo.I = 10;
                songInfo.f251869f = Long.parseLong(this.f260259d);
            }
            a(this.f260263i, ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).isPlaying(Long.parseLong(this.f260259d)));
        }
        TextView textView = (TextView) this.f260262h.findViewById(R.id.jj7);
        if (profileCardInfo.allInOne.f260789pa != 0) {
            this.H = false;
            textView.setText(ProfileNameUtils.getCurCardName(profileCardInfo) + textView.getContext().getResources().getString(R.string.ivt));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            ProfileCardDtReportUtil.dtReportClick(this.f260262h);
            c();
            if (this.G) {
                h(view.getContext(), this.f260259d);
            } else {
                int id5 = view.getId();
                if (id5 != R.id.m0l && id5 != R.id.f164866b64) {
                    if (id5 == R.id.llw) {
                        i(view.getContext(), this.f260259d);
                    } else if (id5 == R.id.f166908j24 || id5 == R.id.m9_) {
                        if (this.H) {
                            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A7D8", 0, 0, "", "", "", "");
                        } else {
                            String str = this.f260259d;
                            if (f()) {
                                i3 = 1;
                            } else {
                                i3 = 2;
                            }
                            ReportController.o(null, "dc00898", "", str, QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A7DD", i3, 0, "", "", "", "");
                        }
                        if (!this.E && this.H) {
                            h(view.getContext(), this.f260259d);
                        } else if (((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).isPlaying(Long.parseLong(this.f260259d))) {
                            ((IListenTogetherManagerApi) QRoute.api(IListenTogetherManagerApi.class)).pauseMusic();
                            b(2);
                        } else {
                            ((IListenTogetherManagerApi) QRoute.api(IListenTogetherManagerApi.class)).shouldPlayMusic(this.f260263i, Long.parseLong(this.f260259d));
                        }
                    }
                } else if (this.H) {
                    h(view.getContext(), this.f260259d);
                } else {
                    i(view.getContext(), this.f260259d);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
