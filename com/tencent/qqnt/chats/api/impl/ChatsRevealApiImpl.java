package com.tencent.qqnt.chats.api.impl;

import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsRevealApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessClearType;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsRevealApiImpl;", "Lcom/tencent/qqnt/chats/api/IChatsRevealApi;", "", QZoneDTLoginReporter.SCHEMA, "transformSchema", "", "parseSchemaParams", "", "params", "replaceSchemaParams", "uid", "", "tryClearLiteBusiness", "content", "handleClick", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsRevealApiImpl implements IChatsRevealApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String KEY_JUMP_SCHEME = "jump_schema";

    @NotNull
    public static final String TAG = "ChatsRevealApiImpl";

    @NotNull
    public static final String XSJ_CUSTOM_PGID = "xsj_custom_pgid";

    @NotNull
    public static final String XSJ_MAIN_ENTRANCE = "xsj_main_entrance";

    @NotNull
    public static final String XSJ_SUB_ENTRANCE = "xsj_sub_entrance";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsRevealApiImpl$a;", "", "", "KEY_JUMP_SCHEME", "Ljava/lang/String;", "TAG", "XSJ_CUSTOM_PGID", "XSJ_MAIN_ENTRANCE", "XSJ_SUB_ENTRANCE", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63896);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatsRevealApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, String> parseSchemaParams(String schema) {
        int indexOf$default;
        List<String> split$default;
        int indexOf$default2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) schema, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            return linkedHashMap;
        }
        String substring = schema.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        split$default = StringsKt__StringsKt.split$default((CharSequence) substring, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        for (String str : split$default) {
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, ContainerUtils.KEY_VALUE_DELIMITER, 0, false, 6, (Object) null);
            String substring2 = str.substring(0, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring3 = str.substring(indexOf$default2 + 1);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
            linkedHashMap.put(substring2, substring3);
        }
        return linkedHashMap;
    }

    private final String replaceSchemaParams(String schema, Map<String, String> params) {
        int indexOf$default;
        String str;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) schema, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            return schema;
        }
        String substring = schema.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        boolean z16 = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (z16) {
                str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            } else {
                str = ContainerUtils.FIELD_DELIMITER;
            }
            substring = substring + str + key + ContainerUtils.KEY_VALUE_DELIMITER + value;
            z16 = false;
        }
        return substring;
    }

    private final String transformSchema(String schema) {
        Map<String, String> parseSchemaParams = parseSchemaParams(schema);
        parseSchemaParams.put("xsj_main_entrance", "qq_avatar");
        parseSchemaParams.put("xsj_sub_entrance", "avatar_aperture");
        parseSchemaParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_AVATAR_APERTURE_PAGE);
        return replaceSchemaParams(schema, parseSchemaParams);
    }

    private final void tryClearLiteBusiness(String uid) {
        final HashSet<LiteBusinessClearType> hashSet = new HashSet<>();
        hashSet.add(LiteBusinessClearType.KLIGHTRINGREVEAL);
        IKernelLiteBusinessService liteBusinessService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getLiteBusinessService();
        if (liteBusinessService != null) {
            liteBusinessService.clearLiteBusiness(uid, hashSet, new IOperateCallback() { // from class: com.tencent.qqnt.chats.api.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    ChatsRevealApiImpl.tryClearLiteBusiness$lambda$2(hashSet, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryClearLiteBusiness$lambda$2(HashSet clearTypes, int i3, String str) {
        Intrinsics.checkNotNullParameter(clearTypes, "$clearTypes");
        QLog.d(TAG, 1, "handleReveal clearLiteBusiness:: clearLiteBusiness, type=" + clearTypes + ", result=" + i3 + ", errMsg=" + str);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsRevealApi
    public void handleClick(@NotNull String content, @NotNull String uid) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) content, (Object) uid);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "OnClick: " + uid + " " + content);
        }
        try {
            BaseApplication context = BaseApplication.getContext();
            String schema = new JSONObject(content).optString(KEY_JUMP_SCHEME);
            QLog.d(TAG, 1, "OnClick: " + uid + " " + schema);
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            if (schema.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                intent.addFlags(268435456);
                intent.setData(Uri.parse(transformSchema(schema)));
                context.startActivity(intent);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getValueFromBusiExtra : " + e16);
        }
        tryClearLiteBusiness(uid);
    }
}
