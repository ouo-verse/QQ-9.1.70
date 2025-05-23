package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import com.tencent.mobileqq.gamecenter.qa.editor.span.BoldSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.ItalicSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.UnderlineSpan;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J;\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0004\"\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0007\u00a2\u0006\u0004\b\b\u0010\tJK\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n2\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0004\"\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0002\u00a2\u0006\u0004\b\f\u0010\rR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R4\u0010\u001c\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0018j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005`\u00198\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR4\u0010\u001e\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0018j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005`\u00198\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\"\u001a\u00020\u001f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/h;", "", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;", "editor", "", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/g;", "exclude", "", "b", "(Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;[Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/g;)V", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/m;", QQWinkConstants.TAB_EFFECT, "a", "(Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/m;[Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/g;)V", "", "Lcom/tencent/mobileqq/gamecenter/qa/editor/span/BoldSpan;", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/g;", "BOLD", "Lcom/tencent/mobileqq/gamecenter/qa/editor/span/ItalicSpan;", "c", "ITALIC", "Lcom/tencent/mobileqq/gamecenter/qa/editor/span/UnderlineSpan;", "d", "UNDERLINE", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "ALL_EFFECTS", "f", "FORMATTING_EFFECTS", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/i;", "g", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/i;", "FONTSIZE", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/a;", tl.h.F, "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/a;", "ALIGNMENT", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/d;", "i", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/d;", "BULLET", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/l;", "j", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/l;", "NUMBER", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/j;", "k", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/j;", "INDENTATION", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f212421a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final g<Boolean, BoldSpan> BOLD;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final g<Boolean, ItalicSpan> ITALIC;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final g<Boolean, UnderlineSpan> UNDERLINE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final ArrayList<g<?, ?>> ALL_EFFECTS;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final ArrayList<g<?, ?>> FORMATTING_EFFECTS;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final i FONTSIZE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final a ALIGNMENT;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final d BULLET;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final l NUMBER;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final j INDENTATION;

    static {
        b bVar = new b();
        BOLD = bVar;
        k kVar = new k();
        ITALIC = kVar;
        q qVar = new q();
        UNDERLINE = qVar;
        ArrayList<g<?, ?>> arrayList = new ArrayList<>();
        ALL_EFFECTS = arrayList;
        ArrayList<g<?, ?>> arrayList2 = new ArrayList<>();
        FORMATTING_EFFECTS = arrayList2;
        i iVar = new i();
        FONTSIZE = iVar;
        a aVar = new a();
        ALIGNMENT = aVar;
        d dVar = new d();
        BULLET = dVar;
        l lVar = new l();
        NUMBER = lVar;
        j jVar = new j();
        INDENTATION = jVar;
        arrayList.add(bVar);
        arrayList.add(kVar);
        arrayList.add(qVar);
        arrayList.add(aVar);
        arrayList.add(iVar);
        arrayList.add(dVar);
        arrayList.add(lVar);
        arrayList.add(jVar);
        arrayList2.add(bVar);
        arrayList2.add(kVar);
        arrayList2.add(qVar);
        arrayList2.add(aVar);
        arrayList2.add(iVar);
        arrayList2.add(dVar);
        arrayList2.add(lVar);
        arrayList2.add(jVar);
    }

    h() {
    }

    private final void a(GameStrategyEditTextView editor, m<?, ?> effect, g<?, ?>... exclude) {
        for (g<?, ?> gVar : exclude) {
            if (effect == gVar) {
                return;
            }
        }
        effect.g(editor, null, null);
    }

    @JvmStatic
    public static final void b(@NotNull GameStrategyEditTextView editor, @NotNull g<?, ?>... exclude) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Intrinsics.checkNotNullParameter(exclude, "exclude");
        h hVar = f212421a;
        hVar.a(editor, ALIGNMENT, (g[]) Arrays.copyOf(exclude, exclude.length));
        hVar.a(editor, INDENTATION, (g[]) Arrays.copyOf(exclude, exclude.length));
        hVar.a(editor, BULLET, (g[]) Arrays.copyOf(exclude, exclude.length));
        hVar.a(editor, NUMBER, (g[]) Arrays.copyOf(exclude, exclude.length));
    }
}
