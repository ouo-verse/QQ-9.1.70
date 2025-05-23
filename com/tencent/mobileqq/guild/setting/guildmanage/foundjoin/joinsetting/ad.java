package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B+\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/ad;", "Lcom/tencent/mobileqq/widget/selectorview/h;", "", "row", "", "p", "Landroid/content/Context;", "context", "", "isNightTheme", "answerNum", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/ad$c;", "listener", "<init>", "(Landroid/content/Context;ZILcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/ad$c;)V", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ad extends com.tencent.mobileqq.widget.selectorview.h {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/ad$b;", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "", "getColumnCount", "column", "getRowCount", "row", "", "getText", "a", "I", "answerNum", "", "b", "Ljava/util/List;", "answers", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements QPickerView.e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int answerNum;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Integer> answers;

        public b(int i3) {
            this.answerNum = i3;
            ArrayList arrayList = new ArrayList();
            while (i3 > 0) {
                arrayList.add(Integer.valueOf(i3));
                i3--;
            }
            this.answers = arrayList;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int column) {
            return this.answers.size();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        @NotNull
        public String getText(int column, int row) {
            if (row == 0) {
                return "\u5168\u90e8\u7b54\u5bf9";
            }
            return "\u7b54\u5bf9" + this.answers.get(row) + "\u9898";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/ad$c;", "", "", "correctNum", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface c {
        void a(@NotNull String correctNum);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ad(@NotNull Context context, boolean z16, int i3, @NotNull c listener) {
        super(context, z16);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        b bVar = new b(i3);
        this.f317413c.j(bVar);
        k(context.getString(R.string.f147220wa));
        i(new a(listener, bVar, this));
    }

    public final void p(int row) {
        this.f317413c.setSelection(0, row);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/ad$a", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f233876d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f233877e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ad f233878f;

        a(c cVar, b bVar, ad adVar) {
            this.f233876d = cVar;
            this.f233877e = bVar;
            this.f233878f = adVar;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            this.f233876d.a(this.f233877e.getText(0, ((com.tencent.mobileqq.widget.selectorview.h) this.f233878f).f317413c.h(0)));
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
