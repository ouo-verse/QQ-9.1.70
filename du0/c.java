package du0;

import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ8\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002JD\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J^\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t0\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a8\u0006\u001b"}, d2 = {"Ldu0/c;", "", "", "startPos", "", "txtStr", "", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "atUserInfoMap", "Lkotlin/Pair;", "a", "Landroid/text/Spannable;", "spannable", "color", "", "underLine", "Ldu0/a;", "clickable", "subStartPos", "subEndPos", "atUserId", "", "b", "", "c", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f394859a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"du0/c$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ du0.a f394860d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f394861e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f394862f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f394863h;

        a(du0.a aVar, CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, boolean z16) {
            this.f394860d = aVar;
            this.f394861e = commonOuterClass$QQUserId;
            this.f394862f = i3;
            this.f394863h = z16;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            this.f394860d.a(this.f394861e);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(this.f394862f);
            ds5.setUnderlineText(this.f394863h);
        }
    }

    c() {
    }

    private final Pair<Integer, String> a(int startPos, String txtStr, Map<String, CommonOuterClass$QQUserId> atUserInfoMap) {
        int indexOf$default;
        ArrayList arrayList = new ArrayList();
        Pair<Integer, String> pair = new Pair<>(-1, "");
        for (Map.Entry<String, CommonOuterClass$QQUserId> entry : atUserInfoMap.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                String str = "@" + ((Object) entry.getKey());
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) txtStr, str, startPos, false, 4, (Object) null);
                if (indexOf$default >= 0 && (indexOf$default < pair.getFirst().intValue() || pair.getFirst().intValue() < 0)) {
                    pair = new Pair<>(Integer.valueOf(str.length() + indexOf$default), entry.getKey());
                    arrayList.add(Integer.valueOf(indexOf$default + str.length()));
                }
            }
        }
        return pair;
    }

    private final void b(Spannable spannable, int color, boolean underLine, du0.a clickable, int subStartPos, int subEndPos, CommonOuterClass$QQUserId atUserId) {
        spannable.setSpan(Integer.valueOf(color), subStartPos, subEndPos, 33);
        if (clickable != null) {
            spannable.setSpan(new a(clickable, atUserId, color, underLine), subStartPos, subEndPos, 33);
        }
    }

    @NotNull
    public final List<Pair<Integer, String>> c(int startPos, @NotNull String txtStr, @NotNull Map<String, CommonOuterClass$QQUserId> atUserInfoMap, @NotNull Spannable spannable, int color, boolean underLine, @Nullable du0.a clickable) {
        boolean contains$default;
        int indexOf$default;
        boolean z16;
        ArrayList arrayList;
        String str;
        Intrinsics.checkNotNullParameter(txtStr, "txtStr");
        Intrinsics.checkNotNullParameter(atUserInfoMap, "atUserInfoMap");
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        String str2 = "ICGameAudience|nickname_module|ICGameChatAtMessageUtil";
        rt0.a.INSTANCE.f("ICGameAudience|nickname_module|ICGameChatAtMessageUtil", "resetAtContentSpan start");
        ArrayList arrayList2 = new ArrayList();
        if ((!atUserInfoMap.isEmpty()) && !TextUtils.isEmpty(txtStr)) {
            boolean z17 = false;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) txtStr, (CharSequence) "@", false, 2, (Object) null);
            if (contains$default) {
                int i3 = startPos;
                loop0: while (true) {
                    boolean z18 = true;
                    while (i3 <= txtStr.length() && z18) {
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) txtStr, "@", i3, false, 4, (Object) null);
                        if (indexOf$default >= i3) {
                            Pair<Integer, String> a16 = a(indexOf$default, txtStr, atUserInfoMap);
                            int intValue = a16.getFirst().intValue();
                            if (intValue > indexOf$default && intValue <= txtStr.length()) {
                                arrayList2.add(a16);
                                String substring = txtStr.substring(indexOf$default + 1, intValue);
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                if (atUserInfoMap.containsKey(substring)) {
                                    z16 = z17;
                                    arrayList = arrayList2;
                                    str = str2;
                                    b(spannable, color, underLine, clickable, indexOf$default, intValue, atUserInfoMap.get(substring));
                                    i3 = intValue + 1;
                                } else {
                                    z16 = z17;
                                    arrayList = arrayList2;
                                    str = str2;
                                    i3++;
                                }
                                str2 = str;
                                z17 = z16;
                                arrayList2 = arrayList;
                            }
                        }
                        str2 = str2;
                        z18 = z17;
                        z17 = z18;
                        arrayList2 = arrayList2;
                    }
                }
            }
        }
        ArrayList arrayList3 = arrayList2;
        rt0.a.INSTANCE.f(str2, "resetAtContentSpan end");
        return arrayList3;
    }
}
