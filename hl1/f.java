package hl1;

import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.EditorFields;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.GestureTextView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lhl1/f;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lhl1/g;", "", "position", "", "getItemId", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Lkotlin/Pair;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Pair;", "savedSelection", "Lhl1/d;", "diffCallback", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "delegatesManager", "<init>", "(Lhl1/d;Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends AsyncListDifferDelegationAdapter<g> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Pair<Integer, Integer> savedSelection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull d diffCallback, @NotNull AdapterDelegatesManager<List<g>> delegatesManager) {
        super(diffCallback, delegatesManager);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(GestureTextView textView, int i3, int i16) {
        boolean z16;
        Spannable spannable;
        Intrinsics.checkNotNullParameter(textView, "$textView");
        CharSequence text = textView.getText();
        if (text != null) {
            int length = text.length();
            boolean z17 = true;
            if (i3 >= 0 && i3 < length) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i16 < 0 || i16 > length) {
                z17 = false;
            }
            if (z16 && z17) {
                CharSequence text2 = textView.getText();
                Method method = null;
                if (text2 instanceof Spannable) {
                    spannable = (Spannable) text2;
                } else {
                    spannable = null;
                }
                if (spannable == null) {
                    spannable = new SpannableString(textView.getText());
                }
                int min = Math.min(i3, i16);
                int max = Math.max(i3, i16);
                textView.requestFocus();
                Selection.setSelection(spannable, min, max);
                m mVar = m.f221619a;
                EditorFields editorFields = textView.getEditorFields();
                if (editorFields != null) {
                    method = editorFields.getShowHandlerMethod();
                }
                mVar.d(method, textView.getSelectionController(), new Object[0]);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return getItems().get(position).getItemId();
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Pair<Integer, Integer> pair;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final GestureTextView gestureTextView = (GestureTextView) holder.itemView.findViewById(R.id.f165512we2);
        if (gestureTextView != null && (pair = this.savedSelection) != null) {
            final int intValue = pair.component1().intValue();
            final int intValue2 = pair.component2().intValue();
            gestureTextView.post(new Runnable() { // from class: hl1.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.j0(GestureTextView.this, intValue, intValue2);
                }
            });
            this.savedSelection = null;
        }
        super.onViewAttachedToWindow(holder);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Method method;
        Intrinsics.checkNotNullParameter(holder, "holder");
        GestureTextView gestureTextView = (GestureTextView) holder.itemView.findViewById(R.id.f165512we2);
        if (gestureTextView != null) {
            int selectionStart = gestureTextView.getSelectionStart();
            int selectionEnd = gestureTextView.getSelectionEnd();
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart < selectionEnd) {
                this.savedSelection = TuplesKt.to(Integer.valueOf(selectionStart), Integer.valueOf(selectionEnd));
                m mVar = m.f221619a;
                EditorFields editorFields = gestureTextView.getEditorFields();
                if (editorFields != null) {
                    method = editorFields.getHideHandlerMethod();
                } else {
                    method = null;
                }
                mVar.d(method, gestureTextView.getSelectionController(), new Object[0]);
            }
        }
        super.onViewDetachedFromWindow(holder);
    }
}
