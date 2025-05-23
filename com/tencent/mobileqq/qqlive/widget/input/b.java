package com.tencent.mobileqq.qqlive.widget.input;

import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ8\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002JD\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J^\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t0\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/input/b;", "", "", "startPos", "", "txtStr", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "atUserInfoMap", "Lkotlin/Pair;", "a", "Landroid/text/Spannable;", "spannable", "color", "", "underLine", "Lcom/tencent/mobileqq/qqlive/widget/input/a;", "clickable", "subStartPos", "subEndPos", "atUserId", "", "b", "", "c", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f273995a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/widget/input/b$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f273996d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f273997e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f273998f;

        a(com.tencent.mobileqq.qqlive.widget.input.a aVar, CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, boolean z16) {
            this.f273996d = commonOuterClass$QQUserId;
            this.f273997e = i3;
            this.f273998f = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, commonOuterClass$QQUserId, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) widget);
            } else {
                Intrinsics.checkNotNullParameter(widget, "widget");
                throw null;
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(this.f273997e);
            ds5.setUnderlineText(this.f273998f);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35539);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f273995a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Pair<Integer, String> a(int startPos, String txtStr, Map<String, CommonOuterClass$QQUserId> atUserInfoMap) {
        int indexOf$default;
        ArrayList arrayList = new ArrayList();
        Pair<Integer, String> pair = new Pair<>(-1, "");
        for (Map.Entry<String, CommonOuterClass$QQUserId> entry : atUserInfoMap.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                String str = '@' + entry.getKey();
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) txtStr, str, startPos, false, 4, (Object) null);
                if (indexOf$default >= 0 && (indexOf$default < pair.getFirst().intValue() || pair.getFirst().intValue() < 0)) {
                    pair = new Pair<>(Integer.valueOf(str.length() + indexOf$default), entry.getKey());
                    arrayList.add(Integer.valueOf(indexOf$default + str.length()));
                }
            }
        }
        return pair;
    }

    private final void b(Spannable spannable, int color, boolean underLine, com.tencent.mobileqq.qqlive.widget.input.a clickable, int subStartPos, int subEndPos, CommonOuterClass$QQUserId atUserId) {
        spannable.setSpan(Integer.valueOf(color), subStartPos, subEndPos, 33);
        if (clickable != null) {
            spannable.setSpan(new a(clickable, atUserId, color, underLine), subStartPos, subEndPos, 33);
        }
    }

    @NotNull
    public final List<Pair<Integer, String>> c(int startPos, @NotNull String txtStr, @NotNull Map<String, CommonOuterClass$QQUserId> atUserInfoMap, @NotNull Spannable spannable, int color, boolean underLine, @Nullable com.tencent.mobileqq.qqlive.widget.input.a clickable) {
        boolean contains$default;
        int indexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(startPos), txtStr, atUserInfoMap, spannable, Integer.valueOf(color), Boolean.valueOf(underLine), clickable);
        }
        Intrinsics.checkNotNullParameter(txtStr, "txtStr");
        Intrinsics.checkNotNullParameter(atUserInfoMap, "atUserInfoMap");
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        AegisLogger.INSTANCE.d("Audience|nickname_module|ChatAtMessageUtil", "resetAtContentSpan start");
        ArrayList arrayList = new ArrayList();
        if ((!atUserInfoMap.isEmpty()) && !TextUtils.isEmpty(txtStr)) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) txtStr, (CharSequence) "@", false, 2, (Object) null);
            if (contains$default) {
                int i3 = startPos;
                loop0: while (true) {
                    for (boolean z16 = true; i3 <= txtStr.length() && z16; z16 = false) {
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) txtStr, "@", i3, false, 4, (Object) null);
                        if (indexOf$default >= i3) {
                            Pair<Integer, String> a16 = a(indexOf$default, txtStr, atUserInfoMap);
                            int intValue = a16.getFirst().intValue();
                            if (intValue > indexOf$default && intValue <= txtStr.length()) {
                                arrayList.add(a16);
                                String substring = txtStr.substring(indexOf$default + 1, intValue);
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                if (atUserInfoMap.containsKey(substring)) {
                                    b(spannable, color, underLine, clickable, indexOf$default, intValue, atUserInfoMap.get(substring));
                                    i3 = intValue + 1;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                }
            }
        }
        AegisLogger.INSTANCE.d("Audience|nickname_module|ChatAtMessageUtil", "resetAtContentSpan end");
        return arrayList;
    }
}
