package com.tencent.qqnt.markdown.data.multipic;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.qqnt.markdown.api.IMultiPicApi;
import com.tencent.qqnt.markdown.data.multipic.detail.MultiPicDetailFragment;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u00a2\u0006\u0004\b\"\u0010#J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010!\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/markdown/data/multipic/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/markdown/data/multipic/f;", "", "index", "count", "Lkotlin/Pair;", "k0", "Landroid/content/Context;", "context", "", "l0", "Landroid/view/ViewGroup;", "viewGroup", "n0", "getItemCount", "viewHolder", "m0", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "picList", BdhLogUtil.LogTag.Tag_Conn, "allPicList", "D", "I", "parentWidth", "E", "parentHeight", UserInfo.SEX_FEMALE, "orientation", "G", "itemsPerRow", "<init>", "(Ljava/util/List;Ljava/util/List;IIII)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends RecyclerView.Adapter<f> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<String> allPicList;

    /* renamed from: D, reason: from kotlin metadata */
    private final int parentWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private final int parentHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private final int orientation;

    /* renamed from: G, reason: from kotlin metadata */
    private final int itemsPerRow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> picList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/markdown/data/multipic/b$a", "Lcom/tencent/qqnt/markdown/data/multipic/c;", "", "url", "", "showMore", "", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f359377b;

        a(f fVar) {
            this.f359377b = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) fVar);
            }
        }

        @Override // com.tencent.qqnt.markdown.data.multipic.c
        public void a(@NotNull String url, boolean showMore) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, url, Boolean.valueOf(showMore));
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            if (showMore) {
                b bVar = b.this;
                Context context = this.f359377b.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "viewHolder.itemView.context");
                bVar.l0(context);
                return;
            }
            IMultiPicApi iMultiPicApi = (IMultiPicApi) QRoute.api(IMultiPicApi.class);
            Context context2 = this.f359377b.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "viewHolder.itemView.context");
            iMultiPicApi.openPreview(context2, b.this.allPicList, b.this.allPicList.indexOf(url));
        }
    }

    public b(@NotNull List<String> picList, @NotNull List<String> allPicList, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(picList, "picList");
        Intrinsics.checkNotNullParameter(allPicList, "allPicList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, picList, allPicList, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.picList = picList;
        this.allPicList = allPicList;
        this.parentWidth = i3;
        this.parentHeight = i16;
        this.orientation = i17;
        this.itemsPerRow = i18;
    }

    private final Pair<Integer, Integer> k0(int index, int count) {
        int i3;
        float f16;
        int i16;
        int dpToPx;
        int i17;
        int i18;
        int dpToPx2 = ViewUtils.dpToPx(4.0f);
        if (this.orientation == 1 && (i18 = this.itemsPerRow) > 0) {
            int i19 = (this.parentWidth - ((i18 - 1) * dpToPx2)) / i18;
            return new Pair<>(Integer.valueOf(i19), Integer.valueOf(i19));
        }
        int i26 = this.parentHeight;
        if (index != 0) {
            if (index != 1) {
                if (index != 2) {
                    if (index != 3) {
                        if (index != 4) {
                            i3 = 0;
                        }
                        i17 = i26;
                    } else {
                        i16 = this.parentWidth - (dpToPx2 * 2);
                        dpToPx = ViewUtils.dpToPx(10.0f);
                        f16 = ((i16 - dpToPx) / 3.45f) * 2.45f;
                        i3 = (int) f16;
                    }
                } else if (count == 3) {
                    i3 = (this.parentWidth - dpToPx2) / 3;
                    i26 = (i26 - dpToPx2) / 2;
                } else {
                    i26 = (int) (((this.parentWidth - (dpToPx2 * 2)) - ViewUtils.dpToPx(10.0f)) / 3.45f);
                    i17 = (this.parentHeight - dpToPx2) / 2;
                }
            } else {
                if (count != 2) {
                    if (count != 3) {
                        i26 = (int) (((this.parentWidth - (dpToPx2 * 2)) - ViewUtils.dpToPx(10.0f)) / 3.45f);
                        i17 = (this.parentHeight - dpToPx2) / 2;
                    } else {
                        i3 = (this.parentWidth - dpToPx2) / 3;
                        i26 = (i26 - dpToPx2) / 2;
                    }
                }
                i17 = i26;
            }
            return new Pair<>(Integer.valueOf(i26), Integer.valueOf(i17));
        }
        if (count != 1) {
            if (count != 2) {
                if (count != 3) {
                    i16 = this.parentWidth - (dpToPx2 * 2);
                    dpToPx = ViewUtils.dpToPx(10.0f);
                    f16 = ((i16 - dpToPx) / 3.45f) * 2.45f;
                    i3 = (int) f16;
                } else {
                    f16 = ((this.parentWidth - dpToPx2) / 3.0f) * 2;
                    i3 = (int) f16;
                }
            }
            i17 = i26;
            return new Pair<>(Integer.valueOf(i26), Integer.valueOf(i17));
        }
        i3 = this.parentWidth;
        int i27 = i26;
        i26 = i3;
        i17 = i27;
        return new Pair<>(Integer.valueOf(i26), Integer.valueOf(i17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(Context context) {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.allPicList);
        Unit unit = Unit.INSTANCE;
        intent.putExtra("pic_data_list", arrayList);
        QPublicFragmentActivity.start(context, intent, MultiPicDetailFragment.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.picList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull f viewHolder, int index) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder, index);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Pair<Integer, Integer> k06 = k0(index, this.picList.size());
        boolean z17 = false;
        if (this.allPicList.size() > 5 && index == this.picList.size() - 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        PicViewWrapper l3 = viewHolder.l();
        String str = this.picList.get(index);
        if (str.length() == 0) {
            z17 = true;
        }
        if (z17) {
            Drawable drawable = viewHolder.itemView.getContext().getResources().getDrawable(R.drawable.qui_aio_fail_icon);
            Intrinsics.checkNotNullExpressionValue(drawable, "viewHolder.itemView.cont\u2026awable.qui_aio_fail_icon)");
            l3.m("\u751f\u6210\u5931\u8d25", drawable, k06.getFirst().intValue(), k06.getSecond().intValue());
        } else if (str.equals(ToastView.ICON_LOADING)) {
            Drawable loadingDrawable = LoadingUtil.getLoadingDrawable(viewHolder.itemView.getContext(), 2);
            Intrinsics.checkNotNullExpressionValue(loadingDrawable, "getLoadingDrawable(viewH\u2026ngType.LOADING_TYPE_GRAY)");
            l3.m("\u52a0\u8f7d\u4e2d", loadingDrawable, k06.getFirst().intValue(), k06.getSecond().intValue());
        } else {
            l3.l(str, k06.getFirst().intValue(), k06.getSecond().intValue(), z16);
            l3.k(new a(viewHolder));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(@NotNull ViewGroup viewGroup, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, index);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewGroup.context");
        return new f(new PicViewWrapper(context));
    }
}
