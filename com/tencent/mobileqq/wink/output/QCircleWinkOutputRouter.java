package com.tencent.mobileqq.wink.output;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import b93.OutputData;
import b93.a;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.preprocess.m;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@RoutePage(desc = "\u5c0f\u4e16\u754c\u8c03\u7528wink\u7684\u8f93\u51fa\u8def\u7531", path = QQWinkConstants.QCIRCLE_OUTPUT_ROUTE)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\r\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0002J\u001e\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/output/QCircleWinkOutputRouter;", "Lb93/a;", "Landroid/content/Context;", "context", "Lb93/b;", "outputData", "", "handlePublish", "", QZoneDTLoginReporter.SCHEMA, "startSchema", "", Node.ATTRS_ATTR, "backToBusinessSchema", "", "needShowBackToBusinessDialog", "tryMiniBack", "Landroid/os/Bundle;", "bundle", "tryShareBack", "tryReturnSchema", "handleQcircleSchema", "onBack", "onOutput", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleWinkOutputRouter implements a {

    @NotNull
    public static final String DISMISS_DIALOG = "0";

    @NotNull
    public static final String JUMP_TO_FOLDER_SCHEMA = "mqqapi://qcircle/openfolder?tabtype=1&key_is_from_publish=1";

    @NotNull
    public static final String SHOW_DIALOG = "1";

    @NotNull
    public static final String TAG = "QCircleWinkOutputRouter";

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
    
        if (r0 != false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String backToBusinessSchema(Map<String, String> attrs) {
        String str;
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        boolean isBlank4;
        String str4 = null;
        if (attrs != null) {
            str = attrs.get(QCircleScheme.AttrQQPublish.MINI_GAME_ID);
        } else {
            str = null;
        }
        if (attrs != null) {
            str2 = attrs.get(QCircleScheme.AttrQQPublish.BUSINESS_TASK_NAME);
        } else {
            str2 = null;
        }
        if (attrs != null) {
            str3 = attrs.get(QCircleScheme.AttrQQPublish.BUSINESS_TASK_SHOW_BACK_DIALOG);
        } else {
            str3 = null;
        }
        if (attrs != null) {
            str4 = attrs.get("taskid");
        }
        StringBuilder sb5 = new StringBuilder(JUMP_TO_FOLDER_SCHEMA);
        boolean z19 = false;
        if (str != null) {
            isBlank4 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank4) {
                z16 = false;
                if (!z16) {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                    sb5.append(QCircleScheme.AttrQQPublish.MINI_GAME_ID);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(str);
                }
                if (str2 != null) {
                    isBlank3 = StringsKt__StringsJVMKt.isBlank(str2);
                    if (!isBlank3) {
                        z17 = false;
                        if (!z17) {
                            sb5.append(ContainerUtils.FIELD_DELIMITER);
                            sb5.append(QCircleScheme.AttrQQPublish.BUSINESS_TASK_NAME);
                            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb5.append(str2);
                        }
                        if (str3 != null) {
                            isBlank2 = StringsKt__StringsJVMKt.isBlank(str3);
                            if (!isBlank2) {
                                z18 = false;
                                if (!z18) {
                                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                                    sb5.append(QCircleScheme.AttrQQPublish.BUSINESS_TASK_SHOW_BACK_DIALOG);
                                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                    sb5.append(str3);
                                }
                                if (str4 != null) {
                                    isBlank = StringsKt__StringsJVMKt.isBlank(str4);
                                }
                                z19 = true;
                                if (!z19) {
                                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                                    sb5.append("taskid");
                                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                    sb5.append(str4);
                                }
                                sb5.append(ContainerUtils.FIELD_DELIMITER);
                                sb5.append("is_force_jump_sub_page");
                                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                sb5.append("1");
                                String sb6 = sb5.toString();
                                Intrinsics.checkNotNullExpressionValue(sb6, "schema.toString()");
                                return sb6;
                            }
                        }
                        z18 = true;
                        if (!z18) {
                        }
                        if (str4 != null) {
                        }
                        z19 = true;
                        if (!z19) {
                        }
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                        sb5.append("is_force_jump_sub_page");
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append("1");
                        String sb62 = sb5.toString();
                        Intrinsics.checkNotNullExpressionValue(sb62, "schema.toString()");
                        return sb62;
                    }
                }
                z17 = true;
                if (!z17) {
                }
                if (str3 != null) {
                }
                z18 = true;
                if (!z18) {
                }
                if (str4 != null) {
                }
                z19 = true;
                if (!z19) {
                }
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append("is_force_jump_sub_page");
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append("1");
                String sb622 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb622, "schema.toString()");
                return sb622;
            }
        }
        z16 = true;
        if (!z16) {
        }
        if (str2 != null) {
        }
        z17 = true;
        if (!z17) {
        }
        if (str3 != null) {
        }
        z18 = true;
        if (!z18) {
        }
        if (str4 != null) {
        }
        z19 = true;
        if (!z19) {
        }
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("is_force_jump_sub_page");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append("1");
        String sb6222 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6222, "schema.toString()");
        return sb6222;
    }

    private final void handlePublish(Context context, OutputData outputData) {
        b.f(TAG, "[handlePublish]");
        if (tryReturnSchema(context, outputData)) {
            return;
        }
        handleQcircleSchema(context, outputData);
    }

    private final void handleQcircleSchema(Context context, OutputData outputData) {
        Object obj;
        String str;
        try {
            Bundle bundle = outputData.getBundle();
            HashMap hashMap = null;
            if (bundle != null) {
                obj = bundle.getSerializable("key_attrs");
            } else {
                obj = null;
            }
            if (obj instanceof HashMap) {
                hashMap = (HashMap) obj;
            }
            if (needShowBackToBusinessDialog(hashMap)) {
                str = backToBusinessSchema(hashMap);
            } else {
                str = JUMP_TO_FOLDER_SCHEMA;
            }
            b.f(TAG, "[handleQcircleSchema] " + str);
            startSchema(context, str);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[handleQcircleSchema] ", e16);
            startSchema(context, JUMP_TO_FOLDER_SCHEMA);
        }
    }

    private final boolean needShowBackToBusinessDialog(Map<String, String> attrs) {
        String str;
        boolean z16;
        boolean isBlank;
        if (attrs != null) {
            str = attrs.get(QCircleScheme.AttrQQPublish.BUSINESS_TASK_SHOW_BACK_DIALOG);
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16 && !Intrinsics.areEqual(str, "0")) {
                    return true;
                }
            }
        }
        z16 = true;
        return z16 ? false : false;
    }

    private final void startSchema(Context context, String schema) {
        CharSequence trim;
        boolean z16;
        trim = StringsKt__StringsKt.trim((CharSequence) schema);
        if (trim.toString().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false, 0, null, 15, null));
            return;
        }
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setPackage(MobileQQ.PACKAGE_NAME);
        intent.setData(Uri.parse(schema));
        context.startActivity(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean tryMiniBack(Context context) {
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        WinkContext.Companion companion = WinkContext.INSTANCE;
        String p16 = companion.d().p("taskid");
        if (p16 != null) {
            isBlank3 = StringsKt__StringsJVMKt.isBlank(p16);
            if (!isBlank3) {
                z16 = false;
                if (!z16) {
                    QLog.i(TAG, 1, "[compactMiniBack] no taskId");
                    return false;
                }
                String p17 = companion.d().p(QCircleScheme.AttrQQPublish.MINI_GAME_ID);
                if (p17 != null) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(p17);
                    if (!isBlank2) {
                        z17 = false;
                        if (z17) {
                            p17 = companion.d().p("mini_app_id");
                        }
                        str = p17;
                        if (str != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(str);
                            if (!isBlank) {
                                z18 = false;
                                if (z18) {
                                    QLog.i(TAG, 1, "[compactMiniBack] no miniId");
                                    return false;
                                }
                                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(context, str, "", "", 1131, null);
                                QLog.i(TAG, 1, "[compactMiniBack] back to mini");
                                return true;
                            }
                        }
                        z18 = true;
                        if (z18) {
                        }
                    }
                }
                z17 = true;
                if (z17) {
                }
                str = p17;
                if (str != null) {
                }
                z18 = true;
                if (z18) {
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final boolean tryReturnSchema(Context context, OutputData outputData) {
        QLog.i(TAG, 1, "[tryReturnSchema] " + outputData.getBusinessReturnSchema());
        String businessReturnSchema = outputData.getBusinessReturnSchema();
        if (businessReturnSchema != null) {
            startSchema(context, businessReturnSchema);
            return true;
        }
        return false;
    }

    private final boolean tryShareBack(Context context, Bundle bundle) {
        boolean z16;
        if (bundle != null) {
            z16 = bundle.getBoolean("wink_share_result");
        } else {
            z16 = false;
        }
        return m.c(context, z16);
    }

    @Override // b93.a
    public boolean interceptExitWink() {
        return a.C0112a.a(this);
    }

    @Override // b93.a
    public void onBack(@NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        b.f(TAG, "[onBack]");
        if (!tryMiniBack(context)) {
            tryShareBack(context, bundle);
        }
    }

    @Override // b93.a
    public void onOutput(@NotNull Context context, @NotNull OutputData outputData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        b.f(TAG, "[onOutput] point=" + outputData.getOutputPoint());
        if (outputData.getOutputPoint() == 64) {
            handlePublish(context, outputData);
        }
    }
}
