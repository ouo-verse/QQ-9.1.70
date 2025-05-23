package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0007JB\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/webviewplugin/NTJuBaoUtil;", "", "", "oldReportMsg", "uin", "groupId", "", "scene", "Landroid/os/Bundle;", "extra", "Lkotlin/Function1;", "", "callback", "b", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class NTJuBaoUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NTJuBaoUtil f97301a = new NTJuBaoUtil();

    NTJuBaoUtil() {
    }

    @JvmStatic
    public static final void a(@NotNull final String uin, @Nullable final String groupId, final int scene, @Nullable Bundle extra, @NotNull final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final GetMsgReq F = NewReportPlugin.F(uin, groupId, scene, extra);
        Intrinsics.checkNotNullExpressionValue(F, "makeGetMsgReq(uin, groupId, scene, extra)");
        NTJuBaoUtilKt.b(F.getUinType(), F.getUin(), F.getMaxCount(), new Function1<List<? extends MsgRecord>, Unit>() { // from class: com.tencent.biz.webviewplugin.NTJuBaoUtil$getReportMsg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MsgRecord> list) {
                invoke2((List<MsgRecord>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<MsgRecord> list) {
                if (QLog.isColorLevel()) {
                    QLog.i("NewReportPlugin", 2, "getReportMsg [" + GetMsgReq.this.getUin() + ", " + GetMsgReq.this.getUinType() + ", " + scene + ", " + (list != null ? Integer.valueOf(list.size()) : null) + "]");
                }
                Function1<String, Unit> function1 = callback;
                String str = uin;
                String str2 = groupId;
                int i3 = scene;
                int maxCount = GetMsgReq.this.getMaxCount();
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                function1.invoke(NewReportPlugin.t(str, str2, i3, maxCount, list));
            }
        });
    }

    @JvmStatic
    public static final void b(@Nullable String oldReportMsg, @NotNull String uin, @Nullable String groupId, int scene, @Nullable Bundle extra, @NotNull final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if ((MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) && TextUtils.isEmpty(oldReportMsg)) {
            a(uin, groupId, scene, extra, new Function1<String, Unit>() { // from class: com.tencent.biz.webviewplugin.NTJuBaoUtil$getReportMsgIfNull$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str) {
                    Function1<String, Unit> function1 = callback;
                    if (str == null) {
                        str = "";
                    }
                    function1.invoke(str);
                }
            });
            return;
        }
        if (oldReportMsg == null) {
            oldReportMsg = "";
        }
        callback.invoke(oldReportMsg);
    }
}
