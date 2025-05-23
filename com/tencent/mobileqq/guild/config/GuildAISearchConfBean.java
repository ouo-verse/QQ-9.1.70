package com.tencent.mobileqq.guild.config;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 B2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0017\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0017\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b!\u0010\u0019\"\u0004\b2\u0010\u001bR\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0017\u001a\u0004\b\u0016\u0010\u0019\"\u0004\b5\u0010\u001bR\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b4\u0010\u0019\"\u0004\b7\u0010\u001bR\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0017\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u0010\u001bR\"\u0010A\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010=\u001a\u0004\b.\u0010>\"\u0004\b?\u0010@R\"\u0010D\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010=\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "", "", "r", "", "text", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/config/d;", "Lkotlin/collections/ArrayList;", "i", "a", "Ljava/lang/Boolean;", "globalSwitch", "b", "Ljava/util/ArrayList;", "modelList", "Lkotlin/Lazy;", "Lkotlin/text/Regex;", "c", "Lkotlin/Lazy;", "lazyRegex", "d", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "y", "(Ljava/lang/String;)V", VasWebviewConstants.KEY_PAGE_TITLE, "e", tl.h.F, "w", "iconUrl", "f", "g", "v", "entranceDesc", DomainData.DOMAIN_NAME, BdhLogUtil.LogTag.Tag_Conn, "searchInputTips", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "B", "searchInputModelTips", "o", "D", "searchResultLine1", "j", "p", "E", "searchResultLine2", "u", "defaultModelType", "l", "t", "androidShareImageMaxHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "regex_pattern", "getRegex_replacement", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "regex_replacement", "", "I", "()I", HippyTKDListViewAdapter.X, "(I)V", "need_parse_delay", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, UserInfo.SEX_FEMALE, "show_new_share", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAISearchConfBean {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Boolean globalSwitch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<GuildAISearchModel> modelList = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Lazy<Regex> lazyRegex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pageTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String iconUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String entranceDesc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String searchInputTips;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String searchInputModelTips;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String searchResultLine1;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String searchResultLine2;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String defaultModelType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String androidShareImageMaxHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String regex_pattern;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String regex_replacement;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int need_parse_delay;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int show_new_share;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0002H\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0017\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0014\u0010\u001b\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0014\u0010\u001c\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\r\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean$a;", "", "Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "bean", "Lorg/json/JSONObject;", "jsonObj", "", "c", "", "b", "a", "", "AI_ICON", "Ljava/lang/String;", "ANDROID_SHARE_IMAGE_MAX_HEIGHT", "DEFAULT_ICON_URL", "DEFAULT_MODEL_TYPE", "", "DEFAULT_SHOW_SPEED", "I", "ENTRANCE_DESC", "MODEL_LIST", "PAGE_TITLE", "SEARCH_INPUT_MODEL_TIPS", "SEARCH_INPUT_TIPS", "SEARCH_RESULT_TIPS_LINE1", "SEARCH_RESULT_TIPS_LINE2", "SHOW_ENTRANCE", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.GuildAISearchConfBean$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildAISearchConfBean a() {
            return bs.f235483a.h("106048").getGuildAISearchBean();
        }

        @JvmStatic
        public final boolean b(@NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            if (jsonObj.has("show_entrance") && jsonObj.has("model_list")) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x0150, code lost:
        
            if (r7 != false) goto L59;
         */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c(@NotNull GuildAISearchConfBean bean, @NotNull JSONObject jsonObj) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            boolean z29;
            String str;
            String str2;
            String str3;
            String str4;
            boolean z36;
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            if (bean.globalSwitch != null) {
                QLog.i("GuildAISearchConfBean", 1, "already parseFromJson. not use shareContent = " + jsonObj);
                return;
            }
            bean.globalSwitch = Boolean.valueOf(jsonObj.optBoolean("show_entrance", false));
            String optString = jsonObj.optString("page_title");
            if (optString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                optString = bean.getPageTitle();
            }
            bean.y(optString);
            String optString2 = jsonObj.optString("ai_icon");
            if (optString2.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                optString2 = bean.getIconUrl();
            }
            bean.w(optString2);
            String optString3 = jsonObj.optString("entrance_desc");
            if (optString3.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                optString3 = bean.getEntranceDesc();
            }
            bean.v(optString3);
            String optString4 = jsonObj.optString("search_input_tips");
            if (optString4.length() == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                optString4 = bean.getSearchInputTips();
            }
            bean.C(optString4);
            String optString5 = jsonObj.optString("search_input_model_tips");
            if (optString5.length() == 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (z26) {
                optString5 = bean.getSearchInputModelTips();
            }
            bean.B(optString5);
            String optString6 = jsonObj.optString("default_model_type");
            if (optString6.length() == 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            if (z27) {
                optString6 = bean.getDefaultModelType();
            }
            bean.u(optString6);
            String optString7 = jsonObj.optString("android_share_image_max_height");
            if (optString7.length() == 0) {
                z28 = true;
            } else {
                z28 = false;
            }
            if (z28) {
                optString7 = bean.getAndroidShareImageMaxHeight();
            }
            bean.t(optString7);
            String optString8 = jsonObj.optString("regex_pattern");
            Intrinsics.checkNotNullExpressionValue(optString8, "jsonObj.optString(\"regex_pattern\")");
            bean.z(optString8);
            String optString9 = jsonObj.optString("regex_replacement");
            Intrinsics.checkNotNullExpressionValue(optString9, "jsonObj.optString(\"regex_replacement\")");
            bean.A(optString9);
            bean.x(jsonObj.optInt("need_parse_delay"));
            bean.F(jsonObj.optInt("show_new_share"));
            String resultTipsLine1 = jsonObj.optString("search_result_tips_line1");
            String resultTipsLine2 = jsonObj.optString("search_result_tips_line2");
            Intrinsics.checkNotNullExpressionValue(resultTipsLine1, "resultTipsLine1");
            if (resultTipsLine1.length() > 0) {
                z29 = true;
            } else {
                z29 = false;
            }
            if (!z29) {
                Intrinsics.checkNotNullExpressionValue(resultTipsLine2, "resultTipsLine2");
                if (resultTipsLine2.length() > 0) {
                    z36 = true;
                } else {
                    z36 = false;
                }
            }
            bean.D(resultTipsLine1);
            Intrinsics.checkNotNullExpressionValue(resultTipsLine2, "resultTipsLine2");
            bean.E(resultTipsLine2);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jsonObj.optJSONArray("model_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        Intrinsics.checkNotNullExpressionValue(optJSONObject, "it.optJSONObject(i) ?: continue");
                        String optString10 = optJSONObject.optString("model_type");
                        if (optString10 == null) {
                            optString10 = "0";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(optString10, "modelObj.optString(\"model_type\") ?: \"0\"");
                        }
                        String str5 = optString10;
                        String optString11 = optJSONObject.optString("model_title");
                        if (optString11 == null) {
                            str = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(optString11, "modelObj.optString(\"model_title\") ?: \"\"");
                            str = optString11;
                        }
                        String optString12 = optJSONObject.optString("model_desc");
                        if (optString12 == null) {
                            str2 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(optString12, "modelObj.optString(\"model_desc\") ?: \"\"");
                            str2 = optString12;
                        }
                        String optString13 = optJSONObject.optString("model_share_info");
                        if (optString13 == null) {
                            str3 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(optString13, "modelObj.optString(\"model_share_info\") ?: \"\"");
                            str3 = optString13;
                        }
                        String optString14 = optJSONObject.optString("model_name");
                        if (optString14 == null) {
                            str4 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(optString14, "modelObj.optString(\"model_name\") ?: \"\"");
                            str4 = optString14;
                        }
                        arrayList.add(new GuildAISearchModel(str5, str, str2, str3, optJSONObject.optInt("show_speed", 50), str4));
                    }
                }
            }
            bean.modelList = arrayList;
            QLog.i("GuildAISearchConfBean", 1, "parseFromJson complete. shareContent = " + jsonObj);
        }

        Companion() {
        }
    }

    public GuildAISearchConfBean() {
        Lazy<Regex> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Regex>() { // from class: com.tencent.mobileqq.guild.config.GuildAISearchConfBean$lazyRegex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Regex invoke() {
                return new Regex(GuildAISearchConfBean.this.getRegex_pattern());
            }
        });
        this.lazyRegex = lazy;
        String r16 = QQGuildUIUtil.r(R.string.f139000a3);
        Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild_ai_search_title)");
        this.pageTitle = r16;
        this.iconUrl = "https://downv6.qq.com/innovate/guild/common/guild_ai_search_icon.png";
        String r17 = QQGuildUIUtil.r(R.string.f138880_r);
        Intrinsics.checkNotNullExpressionValue(r17, "getString(R.string.guild_ai_entrance_desc)");
        this.entranceDesc = r17;
        String r18 = QQGuildUIUtil.r(R.string.f138970a0);
        Intrinsics.checkNotNullExpressionValue(r18, "getString(R.string.guild_ai_search_input_tips)");
        this.searchInputTips = r18;
        String r19 = QQGuildUIUtil.r(R.string.f138960_z);
        Intrinsics.checkNotNullExpressionValue(r19, "getString(R.string.guild\u2026_search_input_model_tips)");
        this.searchInputModelTips = r19;
        String r26 = QQGuildUIUtil.r(R.string.f138980a1);
        Intrinsics.checkNotNullExpressionValue(r26, "getString(R.string.guild\u2026search_result_tips_line1)");
        this.searchResultLine1 = r26;
        String r27 = QQGuildUIUtil.r(R.string.f138990a2);
        Intrinsics.checkNotNullExpressionValue(r27, "getString(R.string.guild\u2026search_result_tips_line2)");
        this.searchResultLine2 = r27;
        this.defaultModelType = "";
        this.androidShareImageMaxHeight = "30000";
        this.regex_pattern = "";
        this.regex_replacement = "";
    }

    @JvmStatic
    @NotNull
    public static final GuildAISearchConfBean e() {
        return INSTANCE.a();
    }

    public final void A(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.regex_replacement = str;
    }

    public final void B(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchInputModelTips = str;
    }

    public final void C(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchInputTips = str;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchResultLine1 = str;
    }

    public final void E(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchResultLine2 = str;
    }

    public final void F(int i3) {
        this.show_new_share = i3;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAndroidShareImageMaxHeight() {
        return this.androidShareImageMaxHeight;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getDefaultModelType() {
        return this.defaultModelType;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getEntranceDesc() {
        return this.entranceDesc;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final ArrayList<GuildAISearchModel> i() {
        this.modelList.isEmpty();
        return new ArrayList<>(this.modelList);
    }

    /* renamed from: j, reason: from getter */
    public final int getNeed_parse_delay() {
        return this.need_parse_delay;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getPageTitle() {
        return this.pageTitle;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getRegex_pattern() {
        return this.regex_pattern;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getSearchInputModelTips() {
        return this.searchInputModelTips;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getSearchInputTips() {
        return this.searchInputTips;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getSearchResultLine1() {
        return this.searchResultLine1;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final String getSearchResultLine2() {
        return this.searchResultLine2;
    }

    /* renamed from: q, reason: from getter */
    public final int getShow_new_share() {
        return this.show_new_share;
    }

    public final boolean r() {
        if (this.globalSwitch == null) {
            QLog.i("GuildAISearchConfBean", 1, "not parse json, so just use false!");
            this.globalSwitch = Boolean.FALSE;
        }
        Boolean bool = this.globalSwitch;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @NotNull
    public final String s(@NotNull String text) {
        boolean z16;
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(text, "text");
        boolean z17 = true;
        if (this.regex_pattern.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.regex_replacement.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(this.lazyRegex.getValue().replace(text, this.regex_replacement));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                    m476constructorimpl = null;
                }
                String str = (String) m476constructorimpl;
                if (str != null) {
                    return str;
                }
                return text;
            }
            return text;
        }
        return text;
    }

    public final void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.androidShareImageMaxHeight = str;
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultModelType = str;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.entranceDesc = str;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconUrl = str;
    }

    public final void x(int i3) {
        this.need_parse_delay = i3;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageTitle = str;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.regex_pattern = str;
    }
}
