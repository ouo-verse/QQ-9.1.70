package com.tencent.storage.view.rtv;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001d\b\u0000\u0018\u0000 J2\u00020\u0001:\u0001\u0015B7\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010&\u001a\u00020\u0007\u0012\b\b\u0002\u0010-\u001a\u00020'\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000f\u0010\n\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00106\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00100R\u0016\u00108\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00100R\u0016\u0010;\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010<R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010>R\u0016\u0010@\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00100R\u0016\u0010A\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010>R\u0016\u0010B\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00100R$\u0010E\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b+\u0010>\u001a\u0004\b/\u0010DR\u0014\u0010F\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010DR\u0011\u0010G\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b7\u0010D\u00a8\u0006K"}, d2 = {"Lcom/tencent/storage/view/rtv/e;", "", "", "k", "", "", "charList", "Lcom/tencent/storage/view/rtv/Direction;", QzoneZipCacheHelper.DIR, DomainData.DOMAIN_NAME, "j", "()V", "", "currentIndex", "", "offsetPercentage", "progress", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Landroid/graphics/Canvas;", PM.CANVAS, "a", "Lcom/tencent/storage/view/rtv/f;", "Lcom/tencent/storage/view/rtv/f;", "manager", "Landroid/text/TextPaint;", "b", "Landroid/text/TextPaint;", "textPaint", "c", "Ljava/util/List;", "e", "()Ljava/util/List;", "setChangeCharList", "(Ljava/util/List;)V", "changeCharList", "d", "Lcom/tencent/storage/view/rtv/Direction;", "direction", "", "Z", "getNeedExpand$storage_view_kit_release", "()Z", "o", "(Z)V", "needExpand", "", "f", UserInfo.SEX_FEMALE, "g", "()F", "setCurrentWidth", "(F)V", "currentWidth", "sourceWidth", h.F, "targetWidth", "i", "D", "yOffset", "I", "index", BdhLogUtil.LogTag.Tag_Conn, "firstChar", "firstCharWidth", "lastChar", "lastCharWidth", "<set-?>", "()C", "currentChar", "targetChar", "sourceChar", "<init>", "(Lcom/tencent/storage/view/rtv/f;Landroid/text/TextPaint;Ljava/util/List;Lcom/tencent/storage/view/rtv/Direction;Z)V", "p", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f manager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextPaint textPaint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Character> changeCharList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Direction direction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needExpand;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float currentWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float sourceWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float targetWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private double yOffset;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int index;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private char firstChar;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float firstCharWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private char lastChar;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private float lastCharWidth;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private char currentChar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/storage/view/rtv/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.storage.view.rtv.e$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35598);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull f manager, @NotNull TextPaint textPaint, @NotNull List<Character> changeCharList, @NotNull Direction direction, boolean z16) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        Intrinsics.checkNotNullParameter(changeCharList, "changeCharList");
        Intrinsics.checkNotNullParameter(direction, "direction");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, manager, textPaint, changeCharList, direction, Boolean.valueOf(z16));
            return;
        }
        this.manager = manager;
        this.textPaint = textPaint;
        this.changeCharList = changeCharList;
        this.direction = direction;
        this.needExpand = z16;
        j();
    }

    private static final void b(e eVar, Canvas canvas, int i3, float f16, float f17) {
        if (i3 >= 0 && i3 < eVar.changeCharList.size() && eVar.changeCharList.get(i3).charValue() != 0) {
            canvas.drawText(c(eVar, i3), 0, 1, f16, f17, eVar.textPaint);
        }
    }

    private static final char[] c(e eVar, int i3) {
        return new char[]{eVar.changeCharList.get(i3).charValue()};
    }

    static /* synthetic */ void d(e eVar, Canvas canvas, int i3, float f16, float f17, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            f16 = 0.0f;
        }
        if ((i16 & 16) != 0) {
            f17 = 0.0f;
        }
        b(eVar, canvas, i3, f16, f17);
    }

    private final char i() {
        Object last;
        if (!this.changeCharList.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.changeCharList);
            return ((Character) last).charValue();
        }
        return (char) 0;
    }

    private final void k() {
        this.sourceWidth = this.manager.a(h(), this.textPaint);
        this.targetWidth = this.manager.a(i(), this.textPaint);
        this.currentWidth = Math.max(this.sourceWidth, this.firstCharWidth);
    }

    public final void a(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        Rect clipBounds = canvas.getClipBounds();
        Intrinsics.checkNotNullExpressionValue(clipBounds, "canvas.clipBounds");
        canvas.clipRect(0, clipBounds.top, (int) this.currentWidth, clipBounds.bottom);
        d(this, canvas, this.index + 1, 0.0f, ((float) this.yOffset) - (this.manager.g() * this.direction.getValue()), 8, null);
        d(this, canvas, this.index, 0.0f, (float) this.yOffset, 8, null);
        d(this, canvas, this.index - 1, 0.0f, ((float) this.yOffset) + (this.manager.g() * this.direction.getValue()), 8, null);
        canvas.restoreToCount(save);
    }

    @NotNull
    public final List<Character> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.changeCharList;
    }

    public final char f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Character) iPatchRedirector.redirect((short) 9, (Object) this)).charValue();
        }
        return this.currentChar;
    }

    public final float g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.currentWidth;
    }

    public final char h() {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Character) iPatchRedirector.redirect((short) 10, (Object) this)).charValue();
        }
        if (this.changeCharList.size() >= 2) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.changeCharList);
            return ((Character) first).charValue();
        }
        return (char) 0;
    }

    public final void j() {
        Object lastOrNull;
        char c16;
        Object firstOrNull;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.changeCharList.size() < 2) {
            this.currentChar = i();
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.changeCharList);
        Character ch5 = (Character) lastOrNull;
        char c17 = 0;
        if (ch5 != null) {
            c16 = ch5.charValue();
        } else {
            c16 = 0;
        }
        this.lastChar = c16;
        this.lastCharWidth = this.manager.a(c16, this.textPaint);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.changeCharList);
        Character ch6 = (Character) firstOrNull;
        if (ch6 != null) {
            c17 = ch6.charValue();
        }
        this.firstChar = c17;
        if (this.needExpand) {
            f16 = this.manager.a(c17, this.textPaint);
        } else {
            f16 = this.lastCharWidth;
        }
        this.firstCharWidth = f16;
        k();
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.currentChar = i();
            this.yOffset = 0.0d;
        }
    }

    public final void m(int currentIndex, double offsetPercentage, double progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(currentIndex), Double.valueOf(offsetPercentage), Double.valueOf(progress));
            return;
        }
        this.index = currentIndex;
        this.currentChar = this.changeCharList.get(currentIndex).charValue();
        this.yOffset = offsetPercentage * this.manager.g() * this.direction.getValue();
        float f16 = this.lastCharWidth;
        float f17 = this.firstCharWidth;
        this.currentWidth = ((f16 - f17) * ((float) progress)) + f17;
    }

    public final void n(@NotNull List<Character> charList, @NotNull Direction dir) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) charList, (Object) dir);
            return;
        }
        Intrinsics.checkNotNullParameter(charList, "charList");
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.changeCharList = charList;
        this.direction = dir;
        j();
        this.index = 0;
        this.yOffset = 0.0d;
    }

    public final void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.needExpand = z16;
        }
    }

    public /* synthetic */ e(f fVar, TextPaint textPaint, List list, Direction direction, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar, textPaint, list, direction, (i3 & 16) != 0 ? true : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, fVar, textPaint, list, direction, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
