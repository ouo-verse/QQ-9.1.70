package com.tencent.mobileqq.emoticonview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.emoticonview.searchemo.IHotTagsCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicHotWordsItem;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/SearchTagAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/emoticonview/SearchTagAdapter$TagViewHolder;", "tagList", "", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicHotWordsItem;", "fromSearchEmotionDialog", "", "hotTagsCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/IHotTagsCallback;", "(Ljava/util/List;ZLcom/tencent/mobileqq/emoticonview/searchemo/IHotTagsCallback;)V", "dtBindViewReport", "", "view", "Landroid/view/View;", "position", "", "tag", "", "getItemCount", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "Companion", "TagViewHolder", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchTagAdapter extends RecyclerView.Adapter<TagViewHolder> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final float ITEM_PADDING_VERTICAL_FOR_DIALOG = 5.0f;
    private static final float ITEM_PADDING_VERTICAL_FOR_GIF_PANEL = 10.0f;

    @NotNull
    private static final String TAG = "SearchTagAdapter";
    private final boolean fromSearchEmotionDialog;

    @NotNull
    private final IHotTagsCallback hotTagsCallback;

    @NotNull
    private final List<EmojiHotPicHotWordsItem> tagList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/SearchTagAdapter$Companion;", "", "()V", "ITEM_PADDING_VERTICAL_FOR_DIALOG", "", "ITEM_PADDING_VERTICAL_FOR_GIF_PANEL", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/SearchTagAdapter$TagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "tvTag", "Landroid/widget/TextView;", "getTvTag", "()Landroid/widget/TextView;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class TagViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        @NotNull
        private final TextView tvTag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TagViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            View findViewById = view.findViewById(R.id.kbj);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tv_tag)");
            this.tvTag = (TextView) findViewById;
        }

        @NotNull
        public final TextView getTvTag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TextView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.tvTag;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19728);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SearchTagAdapter(@NotNull List<EmojiHotPicHotWordsItem> tagList, boolean z16, @NotNull IHotTagsCallback hotTagsCallback) {
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        Intrinsics.checkNotNullParameter(hotTagsCallback, "hotTagsCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tagList, Boolean.valueOf(z16), hotTagsCallback);
            return;
        }
        this.tagList = tagList;
        this.fromSearchEmotionDialog = z16;
        this.hotTagsCallback = hotTagsCallback;
    }

    private final void dtBindViewReport(View view, int position, String tag) {
        VideoReport.setElementId(view, EmotionDaTongReportUtil.EM_BAS_SEARCH_FOR_RECOMMENDATION_WORDS);
        VideoReport.setElementReuseIdentifier(view, tag);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("query", tag);
        linkedHashMap.put(EmotionDaTongReportUtil.EM_PARAMS_APP_LOCATION, Integer.valueOf(position + 1));
        VideoReport.setElementParams(view, linkedHashMap);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(EmojiHotPicHotWordsItem wordItem, SearchTagAdapter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(wordItem, "$wordItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "click tag: " + wordItem.word);
        this$0.hotTagsCallback.clickTag(wordItem);
        if (this$0.fromSearchEmotionDialog) {
            ReportController.o(null, "dc00898", "", "", "0X800C522", "0X800C522", 0, 0, "", "", "", wordItem.word);
        } else {
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800AE1F", "0X800AE1F", 0, 0, "2", "", wordItem.word, "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.tagList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull TagViewHolder viewHolder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final EmojiHotPicHotWordsItem emojiHotPicHotWordsItem = this.tagList.get(position);
        viewHolder.getTvTag().setText(emojiHotPicHotWordsItem.word);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.av
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchTagAdapter.onBindViewHolder$lambda$0(EmojiHotPicHotWordsItem.this, this, view);
            }
        });
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        String str = emojiHotPicHotWordsItem.word;
        Intrinsics.checkNotNullExpressionValue(str, "wordItem.word");
        dtBindViewReport(view, position, str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public TagViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TagViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, viewType);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(this.fromSearchEmotionDialog ? R.layout.h8b : R.layout.h8c, viewGroup, false);
        int a16 = com.tencent.mobileqq.EmotionUtils.a(this.fromSearchEmotionDialog ? 5.0f : 10.0f, viewGroup.getContext().getResources());
        view.setPadding(0, a16, 0, a16);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new TagViewHolder(view);
    }
}
