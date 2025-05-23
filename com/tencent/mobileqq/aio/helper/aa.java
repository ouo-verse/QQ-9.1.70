package com.tencent.mobileqq.aio.helper;

import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.SparseArray;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.input.dialog.msgintent.InputDialogPriorityMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0007*\u0001=\b\u0007\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001BB\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J(\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J,\u0010\"\u001a\u00020!\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0002J \u0010$\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R&\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u001604j\b\u0012\u0004\u0012\u00020\u0016`58\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010>\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/aa;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "c", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$EditTextChangedMsgIntent;", "g", "Lcom/tencent/mobileqq/aio/input/dialog/msgintent/InputDialogPriorityMsgIntent$AddProcessBarrier;", "e", "Lcom/tencent/mobileqq/aio/input/dialog/msgintent/InputDialogPriorityMsgIntent$RemoveProcessBarrier;", "i", "event", "", "traceId", tl.h.F, "Landroid/text/Spanned;", "spannedText", "", "charSequence", "end", "Lcom/tencent/mobileqq/aio/input/dialog/a;", "b", "targetChar", "startIndex", "endIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "T", "spanned", "index", "Ljava/lang/Class;", "spanClass", "", "j", "processor", "k", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mProcessorList", "f", "Lcom/tencent/mobileqq/aio/input/dialog/a;", "mCurrentProcessor", "Ljava/lang/String;", "mCurrentBarrier", "com/tencent/mobileqq/aio/helper/aa$b", "Lcom/tencent/mobileqq/aio/helper/aa$b;", "mAction", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class aa implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ArrayList<com.tencent.mobileqq.aio.input.dialog.a> mProcessorList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.input.dialog.a mCurrentProcessor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mCurrentBarrier;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/aa$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.aa$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/aa$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aa.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                aa.this.c(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50228);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAction = new b();
        }
    }

    private final com.tencent.mobileqq.aio.input.dialog.a b(Spanned spannedText, CharSequence charSequence, int end) {
        boolean z16;
        int lastIndexOf$default;
        int i3 = 0;
        if (charSequence.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && end >= 1) {
            int length = charSequence.length();
            if (end > length) {
                end = length;
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray = new SparseArray();
            ArrayList<com.tencent.mobileqq.aio.input.dialog.a> arrayList2 = this.mProcessorList;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProcessorList");
                arrayList2 = null;
            }
            ArrayList<com.tencent.mobileqq.aio.input.dialog.a> arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (((com.tencent.mobileqq.aio.input.dialog.a) obj).f()) {
                    arrayList3.add(obj);
                }
            }
            for (com.tencent.mobileqq.aio.input.dialog.a aVar : arrayList3) {
                Iterator<T> it = aVar.g().iterator();
                while (it.hasNext()) {
                    char charValue = ((Character) it.next()).charValue();
                    arrayList.add(Integer.valueOf(charValue));
                    sparseArray.put(charValue, aVar);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            int i16 = end - 1;
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) spannedText, '\n', i16, false, 4, (Object) null);
            int size = arrayList.size();
            int i17 = -1;
            while (true) {
                if (i3 < size) {
                    Object obj2 = arrayList.get(i3);
                    Intrinsics.checkNotNullExpressionValue(obj2, "specialCharIntList[tempIndex]");
                    int m3 = m(spannedText, ((Number) obj2).intValue(), lastIndexOf$default + 1, end);
                    if (m3 > lastIndexOf$default) {
                        i17 = i3;
                        lastIndexOf$default = m3;
                    }
                    if (lastIndexOf$default == i16) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = i17;
                    break;
                }
            }
            if (i3 >= 0 && i3 < arrayList.size()) {
                Object obj3 = arrayList.get(i3);
                Intrinsics.checkNotNullExpressionValue(obj3, "specialCharIntList[specialCharResult]");
                return (com.tencent.mobileqq.aio.input.dialog.a) sparseArray.get(((Number) obj3).intValue());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(MsgIntent msgIntent) {
        if (msgIntent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            g((InputEditTextMsgIntent.EditTextChangedMsgIntent) msgIntent);
        } else if (msgIntent instanceof InputDialogPriorityMsgIntent.AddProcessBarrier) {
            e((InputDialogPriorityMsgIntent.AddProcessBarrier) msgIntent);
        } else if (msgIntent instanceof InputDialogPriorityMsgIntent.RemoveProcessBarrier) {
            i((InputDialogPriorityMsgIntent.RemoveProcessBarrier) msgIntent);
        }
    }

    private final void e(InputDialogPriorityMsgIntent.AddProcessBarrier msgIntent) {
        if (msgIntent.b() != 0) {
            return;
        }
        this.mCurrentBarrier = msgIntent.a();
    }

    private final void g(InputEditTextMsgIntent.EditTextChangedMsgIntent msgIntent) {
        int hashCode = msgIntent.hashCode();
        String str = this.mCurrentBarrier;
        if (str != null) {
            QLog.i("InputDialogPriorityHelper", 1, "[handleEditTextChangedMsgIntent]: traceId=" + hashCode + ", blocked by " + str);
            return;
        }
        h(msgIntent, hashCode);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(InputEditTextMsgIntent.EditTextChangedMsgIntent event, int traceId) {
        boolean z16;
        com.tencent.mobileqq.aio.input.dialog.a aVar = this.mCurrentProcessor;
        String str = null;
        if (aVar != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            if (!aVar.c(aVar2)) {
                aVar = null;
            }
            if (aVar != null) {
                com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    aVar3 = null;
                }
                z16 = aVar.e(aVar3, event.c(), event.b(), event.a());
                if (!z16) {
                    com.tencent.mobileqq.aio.input.dialog.a aVar4 = this.mCurrentProcessor;
                    if (aVar4 != null) {
                        str = aVar4.getTag();
                    }
                    QLog.i("InputDialogPriorityHelper", 1, "[handleEditTextChangedMsgIntent]: traceId=" + traceId + " processor[" + str + "] keeps processing");
                    return;
                }
                com.tencent.mobileqq.aio.input.dialog.a aVar5 = this.mCurrentProcessor;
                if (aVar5 != null) {
                    com.tencent.aio.api.runtime.a aVar6 = this.mAIOContext;
                    if (aVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        aVar6 = null;
                    }
                    aVar5.d(traceId, aVar6);
                }
                this.mCurrentProcessor = null;
                ArrayList<com.tencent.mobileqq.aio.input.dialog.a> arrayList = this.mProcessorList;
                if (arrayList == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mProcessorList");
                    arrayList = null;
                }
                Iterator<com.tencent.mobileqq.aio.input.dialog.a> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mobileqq.aio.input.dialog.a processor = it.next();
                    com.tencent.aio.api.runtime.a aVar7 = this.mAIOContext;
                    if (aVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        aVar7 = null;
                    }
                    if (processor.a(aVar7, event.c(), event.b(), event.a())) {
                        Intrinsics.checkNotNullExpressionValue(processor, "processor");
                        z16 = k(processor, event, traceId);
                        if (z16) {
                            this.mCurrentProcessor = processor;
                            break;
                        }
                    }
                }
                if (z16) {
                    com.tencent.mobileqq.aio.input.dialog.a aVar8 = this.mCurrentProcessor;
                    if (aVar8 != null) {
                        str = aVar8.getTag();
                    }
                    QLog.i("InputDialogPriorityHelper", 1, "[handleEditTextChangedMsgIntent]: traceId=" + traceId + " processor[" + str + "] preJudge accepted");
                    return;
                }
                com.tencent.mobileqq.aio.input.dialog.a b16 = b(event.c(), event.c(), event.b());
                if (b16 != null && k(b16, event, traceId)) {
                    QLog.i("InputDialogPriorityHelper", 1, "[handleEditTextChangedMsgIntent]: traceId=" + traceId + " processor[" + b16.getTag() + "] is chosen to process");
                    this.mCurrentProcessor = b16;
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private final void i(InputDialogPriorityMsgIntent.RemoveProcessBarrier msgIntent) {
        if (msgIntent.b() == 0 && TextUtils.equals(this.mCurrentBarrier, msgIntent.a())) {
            this.mCurrentBarrier = null;
        }
    }

    private final <T> boolean j(Spanned spanned, int index, Class<T> spanClass) {
        Object[] spans;
        boolean z16;
        boolean z17;
        if (index >= 0 && index < spanned.length() && (spans = spanned.getSpans(index, index, spanClass)) != null) {
            if (spans.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (Object obj : spans) {
                    int spanStart = spanned.getSpanStart(obj);
                    int spanEnd = spanned.getSpanEnd(obj);
                    if (spanStart <= index && index < spanEnd) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean k(com.tencent.mobileqq.aio.input.dialog.a processor, InputEditTextMsgIntent.EditTextChangedMsgIntent event, int traceId) {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar3 = null;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        } else {
            aVar = aVar2;
        }
        processor.b(traceId, aVar, event.c(), event.b(), event.a());
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar4 = null;
        }
        boolean e16 = processor.e(aVar4, event.c(), event.b(), event.a());
        if (!e16) {
            com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar3 = aVar5;
            }
            processor.d(traceId, aVar3);
        }
        return e16;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int m(Spanned spannedText, int targetChar, int startIndex, int endIndex) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        boolean z17;
        String substring = spannedText.toString().substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        int i18 = endIndex - startIndex;
        if (i18 > 0) {
            if (substring.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                i3 = -1;
                i17 = -1;
                for (i16 = 0; z16 && i16 < substring.length(); i16++) {
                    i17 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) substring, (char) targetChar, i18 - 1, false, 4, (Object) null);
                    int i19 = i17 + startIndex;
                    boolean j3 = j(spannedText, i19, com.tencent.qqnt.aio.at.c.class);
                    boolean j16 = j(spannedText, i19, ReplacementSpan.class);
                    if (i17 == -1 && !j3 && j16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        i18 = i17;
                    } else if (j3) {
                        break;
                    }
                }
                i3 = i17;
                if (i3 < 0) {
                    return i3 + startIndex;
                }
                return i3;
            }
        }
        z16 = false;
        i3 = -1;
        i17 = -1;
        while (z16) {
            i17 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) substring, (char) targetChar, i18 - 1, false, 4, (Object) null);
            int i192 = i17 + startIndex;
            boolean j36 = j(spannedText, i192, com.tencent.qqnt.aio.at.c.class);
            boolean j162 = j(spannedText, i192, ReplacementSpan.class);
            if (i17 == -1) {
            }
            z16 = false;
            if (!z16) {
            }
        }
        i3 = i17;
        if (i3 < 0) {
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 45;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.dialog.msgintent.InputDialogPriorityMsgIntent.AddProcessBarrier");
        hashSet.add("com.tencent.mobileqq.aio.input.dialog.msgintent.InputDialogPriorityMsgIntent.RemoveProcessBarrier");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "InputDialogPriorityHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        ArrayList<com.tencent.mobileqq.aio.input.dialog.a> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a17 = param.a();
        this.mAIOContext = a17;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a17 = null;
        }
        int e16 = a17.g().r().c().e();
        if (e16 != 1) {
            if (e16 != 2) {
                a16 = new ArrayList<>();
            } else {
                a16 = com.tencent.mobileqq.aio.input.dialog.b.f189373a.b();
            }
        } else {
            a16 = com.tencent.mobileqq.aio.input.dialog.b.f189373a.a();
        }
        this.mProcessorList = a16;
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().f(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        h.a.b(this);
        ArrayList<com.tencent.mobileqq.aio.input.dialog.a> arrayList = this.mProcessorList;
        com.tencent.aio.api.runtime.a aVar = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProcessorList");
            arrayList = null;
        }
        arrayList.clear();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().i(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, state);
        }
    }
}
