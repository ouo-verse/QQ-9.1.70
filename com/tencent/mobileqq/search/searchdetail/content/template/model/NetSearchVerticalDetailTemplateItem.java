package com.tencent.mobileqq.search.searchdetail.content.template.model;

import android.graphics.Color;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.search.searchdetail.content.model.SearchBarLabel;
import com.tencent.mobileqq.search.searchdetail.content.model.SearchNetLabel;
import com.tencent.mobileqq.search.searchdetail.content.model.TagIcon;
import com.tencent.mobileqq.search.searchdetail.content.model.TagText;
import com.tencent.mobileqq.search.searchdetail.content.template.model.k;
import com.tencent.mobileqq.search.util.ah;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.abtest.ExpMgrListProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchGuildJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchLabel;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import com.tencent.qqnt.kernel.nativeinterface.SearchVerticalDetail;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0001pB\u0017\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010l\u001a\u00020*\u00a2\u0006\u0004\bm\u0010nJ&\u0010\n\u001a\u00020\t2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J&\u0010\f\u001a\u00020\t2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0000J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0013\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010#\u001a\u00020\u000fH\u0016R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\"\u00106\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00109\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00101\u001a\u0004\b0\u00103\"\u0004\b8\u00105R\"\u0010=\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u00100\u001a\u0004\b7\u0010:\"\u0004\b;\u0010<R\"\u0010A\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00100\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R(\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010B\u001a\u0004\b+\u0010C\"\u0004\bD\u0010ER(\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010B\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER(\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010B\u001a\u0004\bK\u0010C\"\u0004\bL\u0010ER$\u0010U\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR(\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00170\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010B\u001a\u0004\b%\u0010C\"\u0004\bW\u0010ER\"\u0010\\\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u00101\u001a\u0004\bZ\u00103\"\u0004\b[\u00105R\"\u0010d\u001a\u00020]8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010i\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\b>\u0010g\"\u0004\bJ\u0010h\u00a8\u0006q"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/t;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/g;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLabel;", "labelList", "", "Lcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel;", "targetList", "", "N", "Lcom/tencent/mobileqq/search/searchdetail/content/model/f;", "M", "O", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "", UserInfo.SEX_FEMALE, "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;)Ljava/lang/Integer;", HippyTKDListViewAdapter.X, "getItemType", "", "l", "()Ljava/lang/Long;", "", "troopUin", "status", "Lcom/tencent/mobileqq/search/searchdetail/a;", tl.h.F, "guildId", "d", "toString", "", "other", "", "equals", "hashCode", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchVerticalDetail;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchVerticalDetail;", "K", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchVerticalDetail;", "verticalDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "getTemplate", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "I", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/lang/String;", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR, "(Ljava/lang/String;)V", "avatar", "J", "setUin", "uin", "()I", "setUinType", "(I)V", "uinType", "L", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setAvatarType", "avatarType", "Ljava/util/List;", "()Ljava/util/List;", "setTopLabelList", "(Ljava/util/List;)V", "topLabelList", BdhLogUtil.LogTag.Tag_Conn, "setBottomLabelList", "bottomLabelList", "P", "B", "setBarLabelList", "barLabelList", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "D", "()Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "setButtonInfo", "(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;)V", "buttonInfo", BdhLogUtil.LogTag.Tag_Req, "setTitleIcons", "titleIcons", ExifInterface.LATITUDE_SOUTH, "y", "setAppId", "appId", "", "T", "Ljava/lang/CharSequence;", "E", "()Ljava/lang/CharSequence;", "setShowDesc", "(Ljava/lang/CharSequence;)V", "showDesc", "U", "Z", "()Z", "(Z)V", "isGroupCodeSearch", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "searchTemplate", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.t, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchVerticalDetailTemplateItem extends a implements g {

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SearchVerticalDetail verticalDetail;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final SearchTemplate template;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private String avatar;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private String uin;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    private int uinType;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    private int avatarType;

    /* renamed from: M, reason: from kotlin metadata and from toString */
    @NotNull
    private List<SearchNetLabel> topLabelList;

    /* renamed from: N, reason: from kotlin metadata and from toString */
    @NotNull
    private List<SearchNetLabel> bottomLabelList;

    /* renamed from: P, reason: from kotlin metadata and from toString */
    @NotNull
    private List<SearchBarLabel> barLabelList;

    /* renamed from: Q, reason: from kotlin metadata and from toString */
    @Nullable
    private k buttonInfo;

    /* renamed from: R, reason: from kotlin metadata and from toString */
    @NotNull
    private List<String> titleIcons;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String appId;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private CharSequence showDesc;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isGroupCodeSearch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/t$a;", "", "", "keyword", "", "a", "b", "", "AVATAR_TYPE_CIRCLE", "I", "AVATAR_TYPE_RECT", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.t$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull String keyword) {
            boolean z16;
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            if (!new Regex("\\d+").matches(keyword)) {
                return false;
            }
            int length = keyword.length();
            if (6 <= length && length < 10) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            return true;
        }

        public final boolean b(@NotNull String keyword) {
            boolean z16;
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            if (!new Regex("^(?=.*[A-Za-z])\\S{5,14}$").matches(keyword)) {
                return false;
            }
            int length = keyword.length();
            if (5 <= length && length < 14) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchVerticalDetailTemplateItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate searchTemplate) {
        super(commonInfo, searchTemplate);
        String str;
        String str2;
        int i3;
        int i16;
        ArrayList<SearchLabel> arrayList;
        ArrayList<SearchLabel> arrayList2;
        ArrayList<SearchLabel> arrayList3;
        ArrayList<SearchIcon> arrayList4;
        boolean z16;
        SearchIcon searchIcon;
        SearchIcon searchIcon2;
        SearchIcon searchIcon3;
        SearchIcon searchIcon4;
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(searchTemplate, "searchTemplate");
        SearchVerticalDetail searchVerticalDetail = searchTemplate.verticalDetail;
        searchVerticalDetail = searchVerticalDetail == null ? new SearchVerticalDetail() : searchVerticalDetail;
        this.verticalDetail = searchVerticalDetail;
        this.template = searchTemplate;
        SearchVerticalDetail searchVerticalDetail2 = searchTemplate.verticalDetail;
        if (searchVerticalDetail2 != null && (searchIcon4 = searchVerticalDetail2.icon) != null) {
            str = searchIcon4.iconLink;
        } else {
            str = null;
        }
        this.avatar = str == null ? "" : str;
        if (searchVerticalDetail2 != null && (searchIcon3 = searchVerticalDetail2.icon) != null) {
            str2 = searchIcon3.uin;
        } else {
            str2 = null;
        }
        this.uin = str2 == null ? "" : str2;
        if (searchVerticalDetail2 != null && (searchIcon2 = searchVerticalDetail2.icon) != null) {
            i3 = searchIcon2.uinType;
        } else {
            i3 = 0;
        }
        this.uinType = i3;
        if (searchVerticalDetail2 != null && (searchIcon = searchVerticalDetail2.icon) != null) {
            i16 = searchIcon.iconType;
        } else {
            i16 = 1;
        }
        this.avatarType = i16;
        this.topLabelList = new ArrayList();
        this.bottomLabelList = new ArrayList();
        this.barLabelList = new ArrayList();
        this.titleIcons = new ArrayList();
        this.appId = "";
        this.showDesc = "";
        SearchVerticalDetail searchVerticalDetail3 = searchTemplate.verticalDetail;
        if (searchVerticalDetail3 != null) {
            arrayList = searchVerticalDetail3.topLabelList;
        } else {
            arrayList = null;
        }
        N(arrayList, this.topLabelList);
        SearchVerticalDetail searchVerticalDetail4 = searchTemplate.verticalDetail;
        if (searchVerticalDetail4 != null) {
            arrayList2 = searchVerticalDetail4.bottomLabelList;
        } else {
            arrayList2 = null;
        }
        N(arrayList2, this.bottomLabelList);
        SearchVerticalDetail searchVerticalDetail5 = searchTemplate.verticalDetail;
        if (searchVerticalDetail5 != null) {
            arrayList3 = searchVerticalDetail5.labelBarList;
        } else {
            arrayList3 = null;
        }
        M(arrayList3, this.barLabelList);
        QLog.i("NetSearchVerticalDetailTemplateItem", 4, "parse:" + searchVerticalDetail);
        k.Companion companion = k.INSTANCE;
        SearchVerticalDetail searchVerticalDetail6 = searchTemplate.verticalDetail;
        this.buttonInfo = companion.a(searchVerticalDetail6 != null ? searchVerticalDetail6.button : null);
        SearchVerticalDetail searchVerticalDetail7 = searchTemplate.verticalDetail;
        if (searchVerticalDetail7 != null && (arrayList4 = searchVerticalDetail7.tags) != null) {
            for (SearchIcon searchIcon5 : arrayList4) {
                String str3 = searchIcon5.iconLink;
                Intrinsics.checkNotNullExpressionValue(str3, "it.iconLink");
                if (str3.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    List<String> list = this.titleIcons;
                    String str4 = searchIcon5.iconLink;
                    Intrinsics.checkNotNullExpressionValue(str4, "it.iconLink");
                    list.add(str4);
                }
            }
        }
        O();
        QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(this.verticalDetail.subTitle.text, 20);
        Intrinsics.checkNotNullExpressionValue(qQText, "api(IGuildEmotionCodecAp\u2026Detail.subTitle.text, 20)");
        this.showDesc = qQText;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r0 == true) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Integer F(SearchText searchText) {
        boolean z16;
        Object m476constructorimpl;
        boolean z17;
        boolean z18;
        String str = searchText.colorToken;
        boolean z19 = true;
        if (str != null) {
            if (str.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                z16 = true;
                if (!z16) {
                    return Integer.valueOf(BaseApplication.context.getResources().getColor(BaseApplication.context.getResources().getIdentifier("qui_common_" + searchText.colorToken, "color", BaseApplication.context.getPackageName())));
                }
                String str2 = searchText.color;
                if (str2 != null) {
                    if (str2.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                z19 = false;
                Object obj = null;
                if (!z19) {
                    return null;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(Integer.valueOf(Color.parseColor(searchText.color)));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (!Result.m482isFailureimpl(m476constructorimpl)) {
                    obj = m476constructorimpl;
                }
                return (Integer) obj;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void M(List<SearchLabel> labelList, List<SearchBarLabel> targetList) {
        boolean z16;
        boolean z17;
        boolean z18;
        SearchIcon searchIcon;
        boolean z19;
        boolean z26;
        String str;
        String iconBgColor;
        boolean z27;
        SearchText searchText;
        String text;
        boolean z28;
        String iconLink;
        boolean z29;
        String str2;
        boolean z36;
        String str3;
        boolean z37;
        SearchText searchText2;
        if (labelList != null) {
            ArrayList<SearchLabel> arrayList = new ArrayList();
            Iterator<T> it = labelList.iterator();
            while (true) {
                String str4 = null;
                boolean z38 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                SearchLabel searchLabel = (SearchLabel) next;
                SearchText searchText3 = searchLabel.text;
                if (searchText3 != null) {
                    str2 = searchText3.text;
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    z36 = false;
                } else {
                    z36 = true;
                }
                boolean z39 = !z36;
                SearchIcon searchIcon2 = searchLabel.icon;
                if (searchIcon2 != null) {
                    str3 = searchIcon2.iconLink;
                } else {
                    str3 = null;
                }
                if (str3 != null && str3.length() != 0) {
                    z37 = false;
                } else {
                    z37 = true;
                }
                boolean z46 = z39 | (!z37);
                SearchIcon searchIcon3 = searchLabel.icon;
                if (searchIcon3 != null && (searchText2 = searchIcon3.title) != null) {
                    str4 = searchText2.text;
                }
                if (str4 == null || str4.length() == 0) {
                    z38 = true;
                }
                if ((!z38) | z46) {
                    arrayList.add(next);
                }
            }
            for (SearchLabel searchLabel2 : arrayList) {
                SearchBarLabel searchBarLabel = new SearchBarLabel(null, null, null, null, null, 31, null);
                String str5 = searchLabel2.text.text;
                Intrinsics.checkNotNullExpressionValue(str5, "it.text.text");
                searchBarLabel.i(str5);
                searchBarLabel.e(searchLabel2.text.jumpLink);
                String str6 = searchLabel2.text.reportInfo.eid;
                Intrinsics.checkNotNullExpressionValue(str6, "it.text.reportInfo.eid");
                if (str6.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    searchBarLabel.f(searchLabel2.text.reportInfo);
                } else {
                    String str7 = searchLabel2.icon.reportInfo.eid;
                    Intrinsics.checkNotNullExpressionValue(str7, "it.icon.reportInfo.eid");
                    if (str7.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        searchBarLabel.f(searchLabel2.icon.reportInfo);
                    }
                }
                SearchIcon searchIcon4 = searchLabel2.icon;
                if (searchIcon4 != null && (iconLink = searchIcon4.iconLink) != null) {
                    Intrinsics.checkNotNullExpressionValue(iconLink, "iconLink");
                    if (iconLink.length() > 0) {
                        z29 = true;
                    } else {
                        z29 = false;
                    }
                    if (z29) {
                        z18 = true;
                        if (z18) {
                            String str8 = searchLabel2.icon.iconLink;
                            Intrinsics.checkNotNullExpressionValue(str8, "it.icon.iconLink");
                            searchBarLabel.g(new TagIcon(str8));
                        }
                        searchIcon = searchLabel2.icon;
                        if (searchIcon != null && (searchText = searchIcon.title) != null && (text = searchText.text) != null) {
                            Intrinsics.checkNotNullExpressionValue(text, "text");
                            if (text.length() <= 0) {
                                z28 = true;
                            } else {
                                z28 = false;
                            }
                            if (z28) {
                                z19 = true;
                                if (z19) {
                                    String str9 = searchLabel2.icon.title.text;
                                    Intrinsics.checkNotNullExpressionValue(str9, "it.icon.title.text");
                                    searchBarLabel.h(new TagText(str9, 0, 2, null));
                                    SearchIcon searchIcon5 = searchLabel2.icon;
                                    if (searchIcon5 != null && (iconBgColor = searchIcon5.iconBgColor) != null) {
                                        Intrinsics.checkNotNullExpressionValue(iconBgColor, "iconBgColor");
                                        if (iconBgColor.length() > 0) {
                                            z27 = true;
                                        } else {
                                            z27 = false;
                                        }
                                        if (z27) {
                                            z26 = true;
                                            if (!z26) {
                                                try {
                                                    TagText tagText = searchBarLabel.getTagText();
                                                    if (tagText != null) {
                                                        SearchIcon searchIcon6 = searchLabel2.icon;
                                                        if (searchIcon6 != null) {
                                                            str = searchIcon6.iconBgColor;
                                                        } else {
                                                            str = null;
                                                        }
                                                        if (str == null) {
                                                            str = "#FFFFFF";
                                                        } else {
                                                            Intrinsics.checkNotNullExpressionValue(str, "it.icon?.iconBgColor ?: \"#FFFFFF\"");
                                                        }
                                                        tagText.c(Color.parseColor(str));
                                                    }
                                                } catch (Exception e16) {
                                                    QLog.i("NetSearchVerticalDetailTemplateItem", 1, "parseBarLabels:    exception:" + e16);
                                                    TagText tagText2 = searchBarLabel.getTagText();
                                                    if (tagText2 != null) {
                                                        tagText2.c(BaseApplication.context.getColor(R.color.qui_common_fill_standard_primary));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    z26 = false;
                                    if (!z26) {
                                    }
                                }
                                targetList.add(searchBarLabel);
                            }
                        }
                        z19 = false;
                        if (z19) {
                        }
                        targetList.add(searchBarLabel);
                    }
                }
                z18 = false;
                if (z18) {
                }
                searchIcon = searchLabel2.icon;
                if (searchIcon != null) {
                    Intrinsics.checkNotNullExpressionValue(text, "text");
                    if (text.length() <= 0) {
                    }
                    if (z28) {
                    }
                }
                z19 = false;
                if (z19) {
                }
                targetList.add(searchBarLabel);
            }
        }
    }

    private final void N(List<SearchLabel> labelList, List<SearchNetLabel> targetList) {
        String str;
        String str2;
        int color;
        String str3;
        boolean z16;
        String str4;
        boolean z17;
        if (labelList != null) {
            ArrayList<SearchLabel> arrayList = new ArrayList();
            Iterator<T> it = labelList.iterator();
            while (true) {
                boolean z18 = false;
                String str5 = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                SearchLabel searchLabel = (SearchLabel) next;
                SearchText searchText = searchLabel.text;
                if (searchText != null) {
                    str3 = searchText.text;
                } else {
                    str3 = null;
                }
                if (str3 != null && str3.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                boolean z19 = !z16;
                SearchIcon searchIcon = searchLabel.icon;
                if (searchIcon != null) {
                    str4 = searchIcon.iconLink;
                } else {
                    str4 = null;
                }
                if (str4 != null && str4.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                boolean z26 = z19 | (!z17);
                SearchIcon searchIcon2 = searchLabel.icon;
                if (searchIcon2 != null) {
                    str5 = searchIcon2.iconToken;
                }
                if (str5 == null || str5.length() == 0) {
                    z18 = true;
                }
                if ((!z18) | z26) {
                    arrayList.add(next);
                }
            }
            for (SearchLabel searchLabel2 : arrayList) {
                SearchText searchText2 = searchLabel2.text;
                if (searchText2 != null) {
                    str = searchText2.text;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "it.text?.text ?: \"\"");
                }
                SearchNetLabel searchNetLabel = new SearchNetLabel(str, 0, 0, SearchNetLabel.LabelType.TYPE_TEMPLATE, searchLabel2.icon, 0, 0, 0, searchLabel2.layout, null, searchLabel2.reportInfo, ExpMgrListProcessor.CONFIG_ID, null);
                int i3 = searchLabel2.layout;
                if (i3 != 2) {
                    if (i3 != 4) {
                        searchNetLabel.o(BaseApplication.getContext().getColor(R.color.qui_common_text_secondary));
                        searchNetLabel.k(BaseApplication.getContext().getColor(R.color.qui_common_fill_standard_primary));
                    } else {
                        SearchText text = searchLabel2.text;
                        if (text != null) {
                            Intrinsics.checkNotNullExpressionValue(text, "text");
                            Integer F = F(text);
                            if (F != null) {
                                color = F.intValue();
                                searchNetLabel.o(color);
                                searchNetLabel.k(0);
                                searchNetLabel.l(searchLabel2.margin.marginLeft);
                                searchNetLabel.m(searchLabel2.margin.marginRight);
                                searchNetLabel.n(searchLabel2.text);
                            }
                        }
                        color = BaseApplication.getContext().getColor(R.color.qui_common_text_primary);
                        searchNetLabel.o(color);
                        searchNetLabel.k(0);
                        searchNetLabel.l(searchLabel2.margin.marginLeft);
                        searchNetLabel.m(searchLabel2.margin.marginRight);
                        searchNetLabel.n(searchLabel2.text);
                    }
                } else {
                    searchNetLabel.o(Color.parseColor("#FF0099FF"));
                    if (ThemeUtil.isVasDarkTheme()) {
                        str2 = "#400099FF";
                    } else {
                        str2 = "#190099FF";
                    }
                    searchNetLabel.k(Color.parseColor(str2));
                }
                targetList.add(searchNetLabel);
            }
        }
    }

    private final void O() {
        String str;
        SearchJump jumpLink = getJumpLink();
        if (jumpLink != null && jumpLink.type == QSearchEnumJumpType.JUMP_TYPE_MINI_APP.getType()) {
            boolean z16 = true;
            try {
                String optString = new JSONObject(jumpLink.getStringExtension()).optString("appid");
                Intrinsics.checkNotNullExpressionValue(optString, "paramJson.optString(\"appid\")");
                this.appId = optString;
            } catch (Exception e16) {
                QLog.e("NetSearchVerticalDetailTemplateItem", 1, "parseMiniAppContent parse extension error:" + e16);
            }
            if (this.appId.length() <= 0) {
                z16 = false;
            }
            if (z16 && ah.f284994a.i(this.appId)) {
                List<SearchNetLabel> list = this.topLabelList;
                int parseColor = Color.parseColor("#FF0099FF");
                if (com.tencent.biz.qui.quicommon.c.a()) {
                    str = "#400099FF";
                } else {
                    str = "#190099FF";
                }
                list.add(0, new SearchNetLabel("\u4f7f\u7528\u8fc7", parseColor, Color.parseColor(str), null, null, 0, 0, 0, 0, null, null, 2040, null));
            }
        }
    }

    /* renamed from: A, reason: from getter */
    public final int getAvatarType() {
        return this.avatarType;
    }

    @NotNull
    public final List<SearchBarLabel> B() {
        return this.barLabelList;
    }

    @NotNull
    public final List<SearchNetLabel> C() {
        return this.bottomLabelList;
    }

    @Nullable
    /* renamed from: D, reason: from getter */
    public final k getButtonInfo() {
        return this.buttonInfo;
    }

    @NotNull
    /* renamed from: E, reason: from getter */
    public final CharSequence getShowDesc() {
        return this.showDesc;
    }

    @NotNull
    public final List<String> G() {
        return this.titleIcons;
    }

    @NotNull
    public final List<SearchNetLabel> H() {
        return this.topLabelList;
    }

    @NotNull
    /* renamed from: I, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: J, reason: from getter */
    public final int getUinType() {
        return this.uinType;
    }

    @NotNull
    /* renamed from: K, reason: from getter */
    public final SearchVerticalDetail getVerticalDetail() {
        return this.verticalDetail;
    }

    /* renamed from: L, reason: from getter */
    public final boolean getIsGroupCodeSearch() {
        return this.isGroupCodeSearch;
    }

    public final void P(boolean z16) {
        this.isGroupCodeSearch = z16;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.g
    @NotNull
    public com.tencent.mobileqq.search.searchdetail.a d(@NotNull String guildId, int status) {
        String str;
        SearchJump jumpInfo;
        SearchGuildJump searchGuildJump;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        k kVar = this.buttonInfo;
        boolean z16 = false;
        if (kVar != null && kVar.getButtonType() == 3) {
            z16 = true;
        }
        if (z16) {
            k kVar2 = this.buttonInfo;
            k kVar3 = null;
            if (kVar2 != null && (jumpInfo = kVar2.getJumpInfo()) != null && (searchGuildJump = jumpInfo.guildJump) != null) {
                str = Long.valueOf(searchGuildJump.guildId).toString();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, guildId)) {
                NetSearchVerticalDetailTemplateItem x16 = x();
                k kVar4 = this.buttonInfo;
                if (kVar4 != null) {
                    kVar3 = kVar4.clone();
                }
                if (kVar3 != null) {
                    kVar3.c(status);
                }
                x16.buttonInfo = kVar3;
                QLog.i("NetSearchVerticalDetailTemplateItem", 1, "updateJoinGuildBtnStatus id:" + x16.getItemId() + " guildId:" + guildId + ", status:" + status);
                return x16;
            }
        }
        return this;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetSearchVerticalDetailTemplateItem) || !super.equals(other)) {
            return false;
        }
        NetSearchVerticalDetailTemplateItem netSearchVerticalDetailTemplateItem = (NetSearchVerticalDetailTemplateItem) other;
        if (Intrinsics.areEqual(this.verticalDetail, netSearchVerticalDetailTemplateItem.verticalDetail) && Intrinsics.areEqual(this.template, netSearchVerticalDetailTemplateItem.template) && Intrinsics.areEqual(this.avatar, netSearchVerticalDetailTemplateItem.avatar) && Intrinsics.areEqual(this.uin, netSearchVerticalDetailTemplateItem.uin) && this.uinType == netSearchVerticalDetailTemplateItem.uinType && this.avatarType == netSearchVerticalDetailTemplateItem.avatarType && Intrinsics.areEqual(this.topLabelList, netSearchVerticalDetailTemplateItem.topLabelList) && Intrinsics.areEqual(this.bottomLabelList, netSearchVerticalDetailTemplateItem.bottomLabelList) && Intrinsics.areEqual(this.barLabelList, netSearchVerticalDetailTemplateItem.barLabelList) && Intrinsics.areEqual(this.buttonInfo, netSearchVerticalDetailTemplateItem.buttonInfo) && Intrinsics.areEqual(this.titleIcons, netSearchVerticalDetailTemplateItem.titleIcons) && Intrinsics.areEqual(this.appId, netSearchVerticalDetailTemplateItem.appId) && Intrinsics.areEqual(this.showDesc, netSearchVerticalDetailTemplateItem.showDesc) && this.isGroupCodeSearch == netSearchVerticalDetailTemplateItem.isGroupCodeSearch) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 10;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.g
    @NotNull
    public com.tencent.mobileqq.search.searchdetail.a h(@NotNull String troopUin, int status) {
        String str;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        k kVar = this.buttonInfo;
        boolean z16 = false;
        if (kVar != null && kVar.getButtonType() == 2) {
            z16 = true;
        }
        if (z16) {
            k kVar2 = this.buttonInfo;
            k kVar3 = null;
            if (kVar2 != null) {
                str = kVar2.getTroopUin();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, troopUin)) {
                NetSearchVerticalDetailTemplateItem x16 = x();
                k kVar4 = this.buttonInfo;
                if (kVar4 != null) {
                    kVar3 = kVar4.clone();
                }
                if (kVar3 != null) {
                    kVar3.b(status);
                }
                x16.buttonInfo = kVar3;
                return x16;
            }
        }
        return this;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public int hashCode() {
        int i3;
        int hashCode = ((((((((((((((((((super.hashCode() * 31) + this.verticalDetail.hashCode()) * 31) + this.template.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.uin.hashCode()) * 31) + this.uinType) * 31) + this.avatarType) * 31) + this.topLabelList.hashCode()) * 31) + this.bottomLabelList.hashCode()) * 31) + this.barLabelList.hashCode()) * 31;
        k kVar = this.buttonInfo;
        if (kVar != null) {
            i3 = kVar.hashCode();
        } else {
            i3 = 0;
        }
        return ((((((((hashCode + i3) * 31) + this.titleIcons.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.showDesc.hashCode()) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isGroupCodeSearch);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a, com.tencent.mobileqq.search.searchdetail.a
    @NotNull
    public Long l() {
        return Long.valueOf(this.verticalDetail.title.jumpLink.guildJump.guildId);
    }

    @NotNull
    public String toString() {
        CommonInfo commonInfo = getCommonInfo();
        SearchVerticalDetail searchVerticalDetail = this.verticalDetail;
        return "NetSearchVerticalDetailTemplateItem(commonInfo=" + commonInfo + ", title=" + searchVerticalDetail.title + " subTitle=" + searchVerticalDetail.subTitle + ", avatar='" + this.avatar + "', uin='" + this.uin + "', uinType=" + this.uinType + ", avatarType=" + this.avatarType + ", topLabelList=" + this.topLabelList + ", bottomLabelList=" + this.bottomLabelList + ", barLabelList=" + this.barLabelList + ", buttonInfo=" + this.buttonInfo + ", titleIcons=" + this.titleIcons + ")";
    }

    @NotNull
    public final NetSearchVerticalDetailTemplateItem x() {
        return new NetSearchVerticalDetailTemplateItem(getCommonInfo(), this.template);
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }
}
