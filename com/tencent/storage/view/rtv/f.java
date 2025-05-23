package com.tencent.storage.view.rtv;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0019\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b9\u0010:J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\"\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u0003\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\"R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\"\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020)0)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010'R\"\u00102\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00104\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010-\u001a\u0004\b,\u0010/\"\u0004\b3\u00101R\u0011\u00107\u001a\u0002058F\u00a2\u0006\u0006\u001a\u0004\b&\u00106R\u0011\u00108\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b*\u0010/\u00a8\u0006;"}, d2 = {"Lcom/tencent/storage/view/rtv/f;", "", "", "c", "Landroid/text/TextPaint;", "textPaint", "", "a", "Landroid/content/res/Resources;", "res", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/content/res/Resources;)V", "", "progress", "l", "i", "Landroid/graphics/Canvas;", PM.CANVAS, "b", "", "targetText", "k", "", "expand", h.F, "Landroid/text/TextPaint;", "Lcom/tencent/storage/view/rtv/a;", "Lcom/tencent/storage/view/rtv/a;", "()Lcom/tencent/storage/view/rtv/a;", "j", "(Lcom/tencent/storage/view/rtv/a;)V", "charOrderStrategy", "", "Ljava/util/Map;", "map", "", "Lcom/tencent/storage/view/rtv/e;", "d", "Ljava/util/List;", "textColumns", "", "e", "charListColumns", "f", UserInfo.SEX_FEMALE, "g", "()F", "setTextHeight", "(F)V", "textHeight", CanvasView.ACTION_SET_BASELINE, "textBaseline", "", "()[C", "currentText", "currentTextWidth", "<init>", "(Landroid/text/TextPaint;Lcom/tencent/storage/view/rtv/a;)V", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextPaint textPaint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a charOrderStrategy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Character, Float> map;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e> textColumns;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends List<Character>> charListColumns;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float textHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float textBaseline;

    public f(@NotNull TextPaint textPaint, @NotNull a charOrderStrategy) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        Intrinsics.checkNotNullParameter(charOrderStrategy, "charOrderStrategy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) textPaint, (Object) charOrderStrategy);
            return;
        }
        this.textPaint = textPaint;
        this.charOrderStrategy = charOrderStrategy;
        this.map = new LinkedHashMap(36);
        this.textColumns = new ArrayList();
        List<? extends List<Character>> emptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
        this.charListColumns = emptyList;
    }

    public final float a(char c16, @NotNull TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, this, Character.valueOf(c16), textPaint)).floatValue();
        }
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        if (c16 == 0) {
            return 0.0f;
        }
        Float f16 = this.map.get(Character.valueOf(c16));
        if (f16 != null) {
            return f16.floatValue();
        }
        float measureText = textPaint.measureText(String.valueOf(c16));
        this.map.put(Character.valueOf(c16), Float.valueOf(measureText));
        return measureText;
    }

    public final void b(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        for (e eVar : this.textColumns) {
            eVar.a(canvas);
            canvas.translate(eVar.g(), 0.0f);
        }
    }

    @NotNull
    public final a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.charOrderStrategy;
    }

    @NotNull
    public final char[] d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (char[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        int size = this.textColumns.size();
        char[] cArr = new char[size];
        for (int i3 = 0; i3 < size; i3++) {
            cArr[i3] = this.textColumns.get(i3).f();
        }
        return cArr;
    }

    public final float e() {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Float) iPatchRedirector.redirect((short) 15, (Object) this)).floatValue();
        }
        List<e> list = this.textColumns;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((e) it.next()).g()));
        }
        Iterator it5 = arrayList.iterator();
        float f16 = 0.0f;
        while (it5.hasNext()) {
            f16 += ((Number) it5.next()).floatValue();
        }
        return f16;
    }

    public final float f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.textBaseline;
    }

    public final float g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.textHeight;
    }

    public final void h(boolean expand2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, expand2);
            return;
        }
        for (e eVar : this.textColumns) {
            eVar.o(expand2);
            eVar.j();
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Iterator<T> it = this.textColumns.iterator();
        while (it.hasNext()) {
            ((e) it.next()).l();
        }
    }

    public final void j(@NotNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.charOrderStrategy = aVar;
        }
    }

    public final void k(@NotNull CharSequence targetText) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) targetText);
            return;
        }
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        String str = new String(d());
        int max = Math.max(str.length(), targetText.length());
        for (int i3 = 0; i3 < max; i3++) {
            Pair<List<Character>, Direction> b16 = this.charOrderStrategy.b(str, targetText, i3);
            List<Character> component1 = b16.component1();
            Direction component2 = b16.component2();
            if (i3 >= max - str.length()) {
                this.textColumns.get(i3).n(component1, component2);
            } else {
                this.textColumns.add(i3, new e(this, this.textPaint, component1, component2, false, 16, null));
            }
        }
        List<e> list = this.textColumns;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((e) it.next()).e());
        }
        this.charListColumns = arrayList;
    }

    public final void l(double progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Double.valueOf(progress));
            return;
        }
        for (Object obj : this.textColumns) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            b c16 = this.charOrderStrategy.c(progress, i3, this.charListColumns);
            ((e) obj).m(c16.a(), c16.b(), c16.c());
            i3 = i16;
        }
    }

    public final void m(@NotNull Resources res) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) res);
            return;
        }
        Intrinsics.checkNotNullParameter(res, "res");
        this.map.clear();
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (fontMetrics.bottom - fontMetrics.top) + com.tencent.storage.view.c.f373802a.c(12.0f, res);
        this.textBaseline = -fontMetrics.top;
        Iterator<T> it = this.textColumns.iterator();
        while (it.hasNext()) {
            ((e) it.next()).j();
        }
    }

    public /* synthetic */ f(TextPaint textPaint, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(textPaint, (i3 & 2) != 0 ? new a() : aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, textPaint, aVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
