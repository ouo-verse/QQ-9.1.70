package com.tencent.sqshow.zootopia.utils;

import android.net.Uri;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.report.SquareReportConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ag;", "", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "curSource", "", "f", "source", "c", "", "d", "url", "a", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "setCurrentPageZootopiaSource", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "currentPageZootopiaSource", "e", "setSourceInfo", "sourceInfo", "<init>", "()V", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    public static final ag f373258a = new ag();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ZootopiaSource currentPageZootopiaSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static ZootopiaSource sourceInfo;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f373261a;

        static {
            int[] iArr = new int[Source.values().length];
            try {
                iArr[Source.Conversation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Source.FetchSilver.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Source.BuyButton.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Source.Emoticon.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Source.DynamicEntry.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Source.Ark.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Source.H5.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Source.ProfileEntry.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Source.AvatarSetting.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Source.RedPacket.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[Source.RedPacketEx.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[Source.Group.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[Source.Beancurd.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[Source.SetCover.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[Source.LebaEntry.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[Source.QavEntrance.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[Source.AIOEntry.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[Source.AvatarRoleRight.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[Source.AvatarRoleFirstDialog.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[Source.AvatarParadiseBanner.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[Source.AvatarParadisePicCard.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[Source.AvatarParadiseVideoCard.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[Source.AvatarParadiseDownloadManager.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[Source.XiaoWoDress.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[Source.DRAWER_PORTAL.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            f373261a = iArr;
        }
    }

    ag() {
    }

    public final String a(String url) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            return url;
        }
        Uri.Builder buildUpon = Uri.parse(url).buildUpon();
        ZootopiaSource zootopiaSource = currentPageZootopiaSource;
        if (zootopiaSource == null || (str = ah.b(zootopiaSource)) == null) {
            str = "";
        }
        buildUpon.appendQueryParameter(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        String builder = buildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(builder, "uri.toString()");
        return builder;
    }

    public final ZootopiaSource b() {
        return currentPageZootopiaSource;
    }

    public final String d(ZootopiaSource source) {
        String subSource;
        ZootopiaSource c16 = c(source);
        Source mainSource = c16 != null ? c16.getMainSource() : null;
        switch (mainSource == null ? -1 : a.f373261a[mainSource.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return "em_zplan_entrance_qq_main";
            case 4:
                if (Intrinsics.areEqual(c16.getSubSource(), ZootopiaSource.SUB_SOURCE_MAKE_GIF)) {
                    return "em_zplan_entrance_qq_makegif";
                }
                return ZootopiaSource.SUB_SOURCE_ENTRANCE_EMOTICON;
            case 5:
                return "em_zplan_entrance_qq_active";
            case 6:
            case 7:
            case 8:
                return c16.getSubSource();
            case 9:
                return "em_zplan_entrance_qq_qqprofile";
            case 10:
                return "em_zplan_entrance_hongbao_cover";
            case 11:
                return c16.getSubSource();
            case 12:
                return "em_zplan_entrance_group";
            case 13:
                return ZootopiaSource.SUB_SOURCE_BEANCURD;
            case 14:
                return ZootopiaSource.SUB_SOURCE_SET_COVER;
            case 15:
                return ZootopiaSource.SUB_SOURCE_LEBA;
            case 16:
                return c16.getSubSource();
            case 17:
                return "em_zplan_entrance_qq_aiotop";
            case 18:
                return "em_zplan_avatar_role_right_pet";
            case 19:
                return "em_zplan_avatar_role_first_dialog";
            case 20:
                return "em_zplan_avatar_paradise_banner";
            case 21:
                return "em_zplan_avatar_paradise_pic_card";
            case 22:
                return "em_zplan_avatar_paradise_video_card";
            case 23:
                return "em_zplan_avatar_paradise_download_manager";
            case 24:
                return "em_zplan_entrance_xiaowo";
            case 25:
                return ZootopiaSource.SUB_SOURCE_DRAWER_ZPLAN_MANAGE_PORTAL;
            default:
                boolean z16 = false;
                if (c16 != null && (subSource = c16.getSubSource()) != null) {
                    if (subSource.length() > 0) {
                        z16 = true;
                    }
                }
                if (z16) {
                    return c16.getSubSource();
                }
                return "em_zplan_entrance_undefined";
        }
    }

    public final ZootopiaSource e() {
        return sourceInfo;
    }

    public final void f(ZootopiaSource curSource) {
        currentPageZootopiaSource = curSource;
        if (curSource != null) {
            sourceInfo = curSource;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateCurrentZootopiaSource - subSource =");
        sb5.append(curSource != null ? curSource.getSubSource() : null);
        QLog.i("ZootopiaSourceHelper", 1, sb5.toString());
    }

    public final ZootopiaSource c(ZootopiaSource source) {
        while (source != null && ((!source.getMainSource().getIsRootEntry() || source.getMainSource() == Source.UnSet) && source.getLast() != null)) {
            source = source.getLast();
        }
        return source;
    }
}
