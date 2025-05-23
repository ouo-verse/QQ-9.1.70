package com.tencent.mobileqq.gamecenter.qa.editor.util;

import android.text.Spanned;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/util/RTLayout;", "Ljava/io/Serializable;", "", "offset", "getLineForOffset", "line", "getLineStart", "getLineEnd", "", "toString", "mNrOfLines", "I", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Paragraph;", "Lkotlin/collections/ArrayList;", "paragraphs", "Ljava/util/ArrayList;", "getParagraphs", "()Ljava/util/ArrayList;", "Landroid/text/Spanned;", "spanned", "<init>", "(Landroid/text/Spanned;)V", "Companion", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class RTLayout implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f212446d = Pattern.compile("\\r\\n|\\r|\\n");
    private static final long serialVersionUID = 2210969820444215580L;
    private int mNrOfLines;

    @NotNull
    private final ArrayList<Paragraph> paragraphs = new ArrayList<>();

    public RTLayout(@Nullable Spanned spanned) {
        boolean z16;
        if (spanned != null) {
            String obj = spanned.toString();
            this.mNrOfLines = 1;
            Matcher matcher = f212446d.matcher(obj);
            int i3 = 0;
            while (matcher.find()) {
                int end = matcher.end();
                if (this.mNrOfLines == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.paragraphs.add(new Paragraph(i3, end, z16, false));
                i3 = matcher.end();
                this.mNrOfLines++;
            }
            if (this.paragraphs.size() < this.mNrOfLines) {
                this.paragraphs.add(new Paragraph(i3, obj.length(), this.mNrOfLines == 1, true));
            }
        }
    }

    public final int getLineEnd(int line) {
        int i3 = this.mNrOfLines;
        if (i3 != 0 && line >= 0) {
            if (line < i3) {
                return this.paragraphs.get(line).getMEnd();
            }
            return this.paragraphs.get(i3 - 1).getMEnd() - 1;
        }
        return 0;
    }

    public final int getLineForOffset(int offset) {
        int i3 = 0;
        while (i3 < this.mNrOfLines && offset >= this.paragraphs.get(i3).getMEnd()) {
            i3++;
        }
        return Math.min(Math.max(0, i3), this.paragraphs.size() - 1);
    }

    public final int getLineStart(int line) {
        int i3 = this.mNrOfLines;
        if (i3 != 0 && line >= 0) {
            if (line < i3) {
                return this.paragraphs.get(line).getMStart();
            }
            return this.paragraphs.get(i3 - 1).getMEnd() - 1;
        }
        return 0;
    }

    @NotNull
    public final ArrayList<Paragraph> getParagraphs() {
        return this.paragraphs;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        Iterator<Paragraph> it = this.paragraphs.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            Paragraph next = it.next();
            int i16 = i3 + 1;
            sb5.append(i3);
            sb5.append(MsgSummary.STR_COLON);
            sb5.append(next.getMStart());
            sb5.append("-");
            sb5.append(next.getMEnd());
            if (next.getIsLast()) {
                str = "";
            } else {
                str = ", ";
            }
            sb5.append(str);
            i3 = i16;
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "s.toString()");
        return sb6;
    }
}
