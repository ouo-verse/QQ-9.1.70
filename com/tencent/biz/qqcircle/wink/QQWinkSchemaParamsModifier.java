package com.tencent.biz.qqcircle.wink;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import feedcloud.FeedCloudMeta$StTagInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J)\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/wink/QQWinkSchemaParamsModifier;", "", "", QZoneDTLoginReporter.SCHEMA, "Lfeedcloud/FeedCloudMeta$StTagInfo;", "tagInfo", "a", "paramKey", "paramValue", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QQWinkSchemaParamsModifier {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQWinkSchemaParamsModifier f93925a = new QQWinkSchemaParamsModifier();

    QQWinkSchemaParamsModifier() {
    }

    @NotNull
    public final String a(@NotNull String schema, @Nullable FeedCloudMeta$StTagInfo tagInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(schema, "schema");
        if (tagInfo == null) {
            return schema;
        }
        if (tagInfo.nature.get() != 2) {
            return schema;
        }
        String str = tagInfo.tagName.get();
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                schema = i.a(schema, QCircleScheme.AttrQQPublish.CHALLENGE_TAG, str);
            }
        }
        int i3 = tagInfo.tagTotalUser.get();
        if (i3 > 0) {
            return i.a(schema, QCircleScheme.AttrQQPublish.CHALLENGE_NUMS, String.valueOf(i3));
        }
        return schema;
    }

    @NotNull
    public final String b(@NotNull String schema, @NotNull final String paramKey, @Nullable final String paramValue) {
        boolean z16;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(paramKey, "paramKey");
        if (paramValue != null && paramValue.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return schema;
        }
        Regex regex = new Regex(paramKey + "=([^&]*)");
        if (!regex.containsMatchIn(schema)) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) schema, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
            if (contains$default) {
                return schema + ContainerUtils.FIELD_DELIMITER + paramKey + ContainerUtils.KEY_VALUE_DELIMITER + paramValue;
            }
            return schema + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + paramKey + ContainerUtils.KEY_VALUE_DELIMITER + paramValue;
        }
        return regex.replace(schema, new Function1<MatchResult, CharSequence>() { // from class: com.tencent.biz.qqcircle.wink.QQWinkSchemaParamsModifier$appendOrReplaceParam$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull MatchResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return paramKey + ContainerUtils.KEY_VALUE_DELIMITER + paramValue;
            }
        });
    }
}
