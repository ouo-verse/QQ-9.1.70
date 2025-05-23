package com.tencent.mobileqq.filebrowser.toogle;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a>\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000bj\b\u0012\u0004\u0012\u00020\t`\f2\u0006\u0010\u000f\u001a\u00020\u000e\u001a4\u0010\u0016\u001a\u00020\u00102\u001e\u0010\u0014\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"T", "Lkotlin/Function0;", QCircleDaTongConstant.ElementParamValue.OPERATION, "Lkotlin/Result;", "c", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "rootMsgIds", "subMsgIds", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "srcContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dstContacts", "Lcom/tencent/qqnt/kernel/nativeinterface/IForwardOperateCallback;", "forwardCallback", "", "a", "Lkotlin/Function1;", "Lkotlin/Pair;", "opt", "orNot", "b", "qqfile-filebrowser-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    public static final void a(@NotNull long[] rootMsgIds, @NotNull long[] subMsgIds, @NotNull Contact srcContact, @NotNull ArrayList<Contact> dstContacts, @NotNull IForwardOperateCallback forwardCallback) {
        Collection collection;
        Collection collection2;
        Intrinsics.checkNotNullParameter(rootMsgIds, "rootMsgIds");
        Intrinsics.checkNotNullParameter(subMsgIds, "subMsgIds");
        Intrinsics.checkNotNullParameter(srcContact, "srcContact");
        Intrinsics.checkNotNullParameter(dstContacts, "dstContacts");
        Intrinsics.checkNotNullParameter(forwardCallback, "forwardCallback");
        w e16 = f.e();
        if (e16 == null) {
            QLog.e("NTC2CFileTransferMgrOpt", 1, "getKernelMsgService is Null");
        }
        if (e16 != null) {
            collection = ArraysKt___ArraysKt.toCollection(rootMsgIds, new ArrayList());
            ArrayList<Long> arrayList = (ArrayList) collection;
            collection2 = ArraysKt___ArraysKt.toCollection(subMsgIds, new ArrayList());
            e16.k(arrayList, (ArrayList) collection2, srcContact, dstContacts, null, forwardCallback);
        }
    }

    public static final void b(@NotNull Function1<? super Pair<long[], long[]>, Unit> opt, @NotNull Function0<Unit> orNot) {
        Intent intent;
        boolean z16;
        Intrinsics.checkNotNullParameter(opt, "opt");
        Intrinsics.checkNotNullParameter(orNot, "orNot");
        try {
            NTFileTransferMgrOpt nTFileTransferMgrOpt = NTFileTransferMgrOpt.f206055a;
            if (!nTFileTransferMgrOpt.c()) {
                orNot.invoke();
                Unit unit = Unit.INSTANCE;
                QLog.e("NTC2CFileTransferMgrOpt", 1, "error isOptToggle close");
                return;
            }
            Activity topActivity = Foreground.getTopActivity();
            Intent intent2 = null;
            if (topActivity != null) {
                intent = topActivity.getIntent();
            } else {
                intent = null;
            }
            if (intent == null) {
                orNot.invoke();
                Unit unit2 = Unit.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("error intent ");
                Activity topActivity2 = Foreground.getTopActivity();
                if (topActivity2 != null) {
                    intent2 = topActivity2.getIntent();
                }
                sb5.append(intent2);
                QLog.e("NTC2CFileTransferMgrOpt", 1, sb5.toString());
                return;
            }
            if (nTFileTransferMgrOpt.a(intent) != null) {
                boolean z17 = false;
                if (nTFileTransferMgrOpt.b(intent).length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (nTFileTransferMgrOpt.b(intent).length == 0) {
                        z17 = true;
                    }
                    if (z17) {
                        orNot.invoke();
                        Unit unit3 = Unit.INSTANCE;
                        QLog.e("NTC2CFileTransferMgrOpt", 1, "error getSubIds");
                        return;
                    } else {
                        long[] a16 = nTFileTransferMgrOpt.a(intent);
                        Intrinsics.checkNotNull(a16);
                        opt.invoke(TuplesKt.to(a16, nTFileTransferMgrOpt.b(intent)));
                        Unit unit4 = Unit.INSTANCE;
                        QLog.d("NTC2CFileTransferMgrOpt", 1, "forward with opt!!");
                        return;
                    }
                }
            }
            orNot.invoke();
            Unit unit5 = Unit.INSTANCE;
            QLog.e("NTC2CFileTransferMgrOpt", 1, "error hasNoRootIds");
        } catch (Throwable th5) {
            QLog.e("NTC2CFileTransferMgrOpt", 1, "error withOptOrNOt", th5);
            orNot.invoke();
        }
    }

    @NotNull
    public static final <T> Object c(@NotNull Function0<? extends T> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        try {
            if (!NTFileTransferMgrOpt.f206055a.c()) {
                Result.Companion companion = Result.INSTANCE;
                return Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException("wrapToggleAndThrowable close!!")));
            }
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m476constructorimpl(operation.invoke());
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }
}
