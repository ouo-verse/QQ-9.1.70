package com.tencent.mobileqq.aio.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJB\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J@\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J8\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/utils/l;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/input/f$e;", "Lkotlin/collections/ArrayList;", "elementList", "Landroid/os/Bundle;", "robotCallbackDatas", "Landroid/content/Context;", "context", "c", "Landroid/widget/EditText;", "editText", "d", "e", "Lcom/tencent/qqnt/aio/at/a;", "atSpan", "f", "Lcom/tencent/mobileqq/aio/input/fullscreen/a;", "imageSpan", "g", "", "inputString", "Landroid/text/Spanned;", "editableText", "", "a", "", "robotBusinessFlag", "b", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f194165a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Spanned f194166d;

        public a(Spanned spanned) {
            this.f194166d = spanned;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) spanned);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(this.f194166d.getSpanStart((MetricAffectingSpan) t16)), Integer.valueOf(this.f194166d.getSpanStart((MetricAffectingSpan) t17)));
            return compareValues;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65286);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f194165a = new l();
        }
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<f.e> c(ArrayList<f.e> elementList, Bundle robotCallbackDatas, Context context) {
        if (context == null) {
            QLog.i(".AtSpanUtils", 1, "convertRobotDrawData return, context is null");
            return elementList;
        }
        String string = robotCallbackDatas.getString(QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME, "");
        String string2 = robotCallbackDatas.getString("require_name", "");
        String string3 = context.getString(R.string.f222326d8);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.robot_draw_prefix)");
        elementList.add(0, new f.e(string3, 0, 0L, 0L, null, 30, null));
        if (!TextUtils.isEmpty(string)) {
            String string4 = context.getResources().getString(R.string.f222346d_, string);
            Intrinsics.checkNotNullExpressionValue(string4, "context.resources.getStr\u2026otDrawStyle\n            )");
            elementList.add(new f.e(string4, 0, 0L, 0L, null, 30, null));
        }
        if (!TextUtils.isEmpty(string2)) {
            String string5 = context.getResources().getString(R.string.f222336d9, string2);
            Intrinsics.checkNotNullExpressionValue(string5, "context.resources.getStr\u2026DrawRequire\n            )");
            elementList.add(new f.e(string5, 0, 0L, 0L, null, 30, null));
        }
        return elementList;
    }

    private final ArrayList<f.e> d(ArrayList<f.e> elementList, Bundle robotCallbackDatas, EditText editText) {
        String replace$default;
        if (editText.getContext() == null) {
            QLog.i(".AtSpanUtils", 1, "convertRobotPromptData return, context is null");
            return elementList;
        }
        String template = robotCallbackDatas.getString("item_template", "");
        Intrinsics.checkNotNullExpressionValue(template, "template");
        replace$default = StringsKt__StringsJVMKt.replace$default(template, "{{input}}", editText.getEditableText().toString(), false, 4, (Object) null);
        editText.setText("");
        elementList.add(0, new f.e(replace$default, 0, 0L, 0L, null, 30, null));
        return elementList;
    }

    private final ArrayList<f.e> e(ArrayList<f.e> elementList, Bundle robotCallbackDatas) {
        ArrayList arrayList;
        boolean z16;
        String replace$default;
        List split$default;
        boolean z17;
        Serializable serializable = robotCallbackDatas.getSerializable("item_template");
        ArrayList arrayList2 = null;
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        Serializable serializable2 = robotCallbackDatas.getSerializable("require_template");
        if (serializable2 instanceof ArrayList) {
            arrayList2 = (ArrayList) serializable2;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return elementList;
        }
        Object obj = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "itemTemplateList[0]");
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            QLog.i(".AtSpanUtils", 1, "convertRobotWriteData return, itemTemplate is null");
            return elementList;
        }
        String str2 = "";
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                str2 = ((Object) str2) + ((String) it.next());
            }
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(str, "${require}", str2, false, 4, (Object) null);
        split$default = StringsKt__StringsKt.split$default((CharSequence) replace$default, new String[]{"${input}"}, false, 0, 6, (Object) null);
        List list = split$default;
        if (list != null && !list.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return elementList;
        }
        String str3 = (String) split$default.get(0);
        if (!TextUtils.isEmpty(str3)) {
            elementList.add(0, new f.e(str3, 0, 0L, 0L, null, 30, null));
        }
        if (split$default.size() > 1) {
            String str4 = (String) split$default.get(1);
            if (!TextUtils.isEmpty(str4)) {
                elementList.add(new f.e(str4, 0, 0L, 0L, null, 30, null));
            }
        }
        return elementList;
    }

    private final f.e f(com.tencent.qqnt.aio.at.a atSpan) {
        Long longOrNull;
        long j3;
        if (atSpan.l()) {
            String memberNickText = atSpan.g();
            String memberUid = atSpan.h();
            Intrinsics.checkNotNullExpressionValue(memberNickText, "memberNickText");
            Intrinsics.checkNotNullExpressionValue(memberUid, "memberUid");
            return new f.e(memberNickText, 1, 0L, 0L, memberUid, 12, null);
        }
        if (atSpan.m()) {
            String memberNickText2 = atSpan.g();
            String memberUid2 = atSpan.h();
            String k3 = atSpan.k();
            Intrinsics.checkNotNullExpressionValue(k3, "atSpan.troopMemUin");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(k3);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            Intrinsics.checkNotNullExpressionValue(memberNickText2, "memberNickText");
            Intrinsics.checkNotNullExpressionValue(memberUid2, "memberUid");
            return new f.e(memberNickText2, 2, j3, 0L, memberUid2, 8, null);
        }
        return null;
    }

    private final f.e g(com.tencent.mobileqq.aio.input.fullscreen.a imageSpan) {
        return new f.d("\u56fe\u7247", imageSpan.b(), imageSpan.a(), imageSpan.c());
    }

    @NotNull
    public final List<f.e> a(@NotNull String inputString, @NotNull Spanned editableText) {
        boolean z16;
        List<f.e> emptyList;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) inputString, (Object) editableText);
        }
        Intrinsics.checkNotNullParameter(inputString, "inputString");
        Intrinsics.checkNotNullParameter(editableText, "editableText");
        if (inputString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (editableText.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                com.tencent.qqnt.aio.at.a[] atSpanList = (com.tencent.qqnt.aio.at.a[]) editableText.getSpans(0, editableText.length(), com.tencent.qqnt.aio.at.a.class);
                com.tencent.mobileqq.aio.input.fullscreen.a[] imageSpanList = (com.tencent.mobileqq.aio.input.fullscreen.a[]) editableText.getSpans(0, editableText.length(), com.tencent.mobileqq.aio.input.fullscreen.a.class);
                ArrayList arrayList = new ArrayList();
                Intrinsics.checkNotNullExpressionValue(atSpanList, "atSpanList");
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, atSpanList);
                Intrinsics.checkNotNullExpressionValue(imageSpanList, "imageSpanList");
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, imageSpanList);
                if (arrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new a(editableText));
                }
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i3 = 0;
                for (int i16 = 0; i16 < size; i16++) {
                    Object obj = arrayList.get(i16);
                    Intrinsics.checkNotNullExpressionValue(obj, "spanList[index]");
                    MetricAffectingSpan metricAffectingSpan = (MetricAffectingSpan) obj;
                    int spanStart = editableText.getSpanStart(metricAffectingSpan);
                    if (spanStart > i3) {
                        String substring = inputString.substring(i3, spanStart);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        arrayList2.add(new f.e(substring, 0, 0L, 0L, null, 30, null));
                    }
                    if (metricAffectingSpan instanceof com.tencent.qqnt.aio.at.a) {
                        f.e f16 = f((com.tencent.qqnt.aio.at.a) metricAffectingSpan);
                        if (f16 != null) {
                            arrayList2.add(f16);
                        }
                    } else if (metricAffectingSpan instanceof com.tencent.mobileqq.aio.input.fullscreen.a) {
                        arrayList2.add(g((com.tencent.mobileqq.aio.input.fullscreen.a) metricAffectingSpan));
                    }
                    i3 = editableText.getSpanEnd(metricAffectingSpan);
                }
                if (i3 < editableText.length()) {
                    String substring2 = inputString.substring(i3, editableText.length());
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    arrayList2.add(new f.e(substring2, 0, 0L, 0L, null, 30, null));
                }
                return arrayList2;
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @NotNull
    public final List<f.e> b(@NotNull EditText editText, int robotBusinessFlag, @Nullable Bundle robotCallbackDatas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, editText, Integer.valueOf(robotBusinessFlag), robotCallbackDatas);
        }
        Intrinsics.checkNotNullParameter(editText, "editText");
        String obj = editText.getText().toString();
        Editable editableText = editText.getEditableText();
        Intrinsics.checkNotNullExpressionValue(editableText, "editText.editableText");
        List<f.e> a16 = a(obj, editableText);
        if (robotCallbackDatas != null && !robotCallbackDatas.isEmpty()) {
            if (!(a16 instanceof ArrayList)) {
                QLog.i(".AtSpanUtils", 1, "convertInputToElementsWithRobotData return, elementList is not ArrayList");
                return a16;
            }
            if (QLog.isColorLevel()) {
                QLog.i(".AtSpanUtils", 1, "convertInputToElementsWithRobotData robotBusinessFlag = " + robotBusinessFlag + ", robotCallbackDatas = " + robotCallbackDatas);
            }
            if (robotBusinessFlag == 2) {
                return c((ArrayList) a16, robotCallbackDatas, editText.getContext());
            }
            if (robotBusinessFlag == 4) {
                return d(new ArrayList<>(), robotCallbackDatas, editText);
            }
            if (robotBusinessFlag == 3) {
                return e((ArrayList) a16, robotCallbackDatas);
            }
            return a16;
        }
        QLog.i(".AtSpanUtils", 1, "convertInputToElementsWithRobotData return, robotCallbackDatas.isEmpty");
        return a16;
    }
}
