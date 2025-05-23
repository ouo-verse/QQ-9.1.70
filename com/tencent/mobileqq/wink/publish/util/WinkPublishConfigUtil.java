package com.tencent.mobileqq.wink.publish.util;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.publish.part.PublishContentPart;
import com.tencent.mobileqq.wink.publish.part.af;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0002R#\u0010\u0016\u001a\n \u0012*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/publish/util/WinkPublishConfigUtil;", "", "", h.F, "i", "", "key", "c", ReportConstant.COSTREPORT_PREFIX, "", "f", "b", "", "e", "d", "", "g", "j", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "a", "()Ljava/lang/String;", "account", "Lcom/tencent/mobileqq/qcircle/api/IQCircleABTestApi;", "getAbTestApi", "()Lcom/tencent/mobileqq/qcircle/api/IQCircleABTestApi;", "abTestApi", "I", "tagMaxCount", "Ljava/lang/String;", "tagExceedMessage", "tagHistoryIconUrl", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkPublishConfigUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkPublishConfigUtil f325969a = new WinkPublishConfigUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy account;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy abTestApi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int tagMaxCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String tagExceedMessage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String tagHistoryIconUrl;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.publish.util.WinkPublishConfigUtil$account$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return WinkCommonUtil.getCurrentAccount();
            }
        });
        account = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IQCircleABTestApi>() { // from class: com.tencent.mobileqq.wink.publish.util.WinkPublishConfigUtil$abTestApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IQCircleABTestApi invoke() {
                return (IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class);
            }
        });
        abTestApi = lazy2;
        tagMaxCount = -1;
        tagExceedMessage = "";
        tagHistoryIconUrl = "";
    }

    WinkPublishConfigUtil() {
    }

    private final String a() {
        return (String) account.getValue();
    }

    private final String c(String key) {
        return key + "_" + a();
    }

    private final void h() {
        tagMaxCount = 10;
        tagExceedMessage = "\u5185\u5bb9\u6700\u591a\u53ef\u5e2610\u4e2a\u8bdd\u9898";
        tagHistoryIconUrl = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/9035/topic/qvideo_topic_icon_history.png";
    }

    private final void i() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102281", "");
        QLog.d("WinkPublishConfigUtil", 1, "[parseTagConfig] config=" + loadAsString);
        if (TextUtils.isEmpty(loadAsString)) {
            QLog.w("WinkPublishConfigUtil", 1, "[parseTagConfig] invalid config");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(loadAsString);
            tagMaxCount = jSONObject.optInt("max_compose_tag_count", 10);
            String msg2 = jSONObject.optString("cannot_append_tag_hint", "\u5185\u5bb9\u6700\u591a\u53ef\u5e2610\u4e2a\u8bdd\u9898");
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            tagExceedMessage = msg2;
            String url = jSONObject.optString("history_tag_icon_url", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/9035/topic/qvideo_topic_icon_history.png");
            Intrinsics.checkNotNullExpressionValue(url, "url");
            tagHistoryIconUrl = url;
            QLog.d("WinkPublishConfigUtil", 1, "[parseTagConfig] tag warn msg=" + msg2);
        } catch (Exception e16) {
            QLog.e(af.L, 1, "[parseTagConfig] ", e16);
            tagMaxCount = 10;
            tagExceedMessage = "\u5185\u5bb9\u6700\u591a\u53ef\u5e2610\u4e2a\u8bdd\u9898";
            tagHistoryIconUrl = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/9035/topic/qvideo_topic_icon_history.png";
        }
    }

    @NotNull
    public final String b() {
        boolean isBlank;
        boolean isBlank2;
        isBlank = StringsKt__StringsJVMKt.isBlank(tagHistoryIconUrl);
        if (isBlank) {
            i();
        }
        isBlank2 = StringsKt__StringsJVMKt.isBlank(tagHistoryIconUrl);
        if (isBlank2) {
            h();
        }
        return tagHistoryIconUrl;
    }

    @NotNull
    public final String d() {
        boolean isBlank;
        boolean isBlank2;
        isBlank = StringsKt__StringsJVMKt.isBlank(tagExceedMessage);
        if (isBlank) {
            i();
        }
        isBlank2 = StringsKt__StringsJVMKt.isBlank(tagExceedMessage);
        if (isBlank2) {
            h();
        }
        return tagExceedMessage;
    }

    public final int e() {
        if (tagMaxCount <= 0) {
            i();
        }
        if (tagMaxCount <= 0) {
            h();
        }
        return tagMaxCount;
    }

    @NotNull
    public final List<String> f(@NotNull String s16) {
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(s16, "s");
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(s16);
        Matcher matcher = PublishContentPart.f325693f0.matcher(s16);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (end - start != 1) {
                String obj = spannableStringBuilder.subSequence(start, end).toString();
                int length = obj.length() - 1;
                int i16 = 0;
                boolean z17 = false;
                while (i16 <= length) {
                    if (!z17) {
                        i3 = i16;
                    } else {
                        i3 = length;
                    }
                    if (Intrinsics.compare((int) obj.charAt(i3), 32) <= 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z17) {
                        if (!z16) {
                            z17 = true;
                        } else {
                            i16++;
                        }
                    } else {
                        if (!z16) {
                            break;
                        }
                        length--;
                    }
                }
                arrayList.add(obj.subSequence(i16, length + 1).toString());
            }
        }
        return arrayList;
    }

    public final boolean g() {
        boolean c16 = ar.f326685a.c(c("key_has_showed_hash_tag_tip"), false);
        QLog.d("WinkPublishConfigUtil", 1, "hasShowedHashTagTip, ret:" + c16);
        return c16;
    }

    public final void j() {
        ar.f326685a.m(c("key_has_showed_hash_tag_tip"), true);
    }
}
