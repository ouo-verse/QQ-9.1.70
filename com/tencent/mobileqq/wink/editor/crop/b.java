package com.tencent.mobileqq.wink.editor.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbAssetModel;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager;
import com.tencent.mobileqq.wink.editor.crop.b;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.model.MediaType;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001&\u0018\u0000 .2\u00020\u0001:\u0002/\rB\u001d\u0012\u0006\u0010+\u001a\u00020*\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0015\u00a2\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR8\u0010%\u001a&\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010\u00040 j\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/b;", "Landroid/widget/BaseAdapter;", "", "id", "Landroid/graphics/Bitmap;", "c", "", "position", "", "e", "f", "getCount", "Lcom/tencent/mobileqq/wink/editor/crop/model/a;", "b", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "", "d", "Ljava/util/List;", "()Ljava/util/List;", "videos", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "Landroid/view/LayoutInflater;", "Landroid/view/LayoutInflater;", "mInflater", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "thumbnailMap", "com/tencent/mobileqq/wink/editor/crop/b$c", "i", "Lcom/tencent/mobileqq/wink/editor/crop/b$c;", "thumbnailGeneratedListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.wink.editor.crop.model.a> videos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LayoutInflater mInflater;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Object, Bitmap> thumbnailMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c thumbnailGeneratedListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "b", "()Landroid/widget/ImageView;", "img", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "durationText", "Landroid/view/View;", "c", "Landroid/view/View;", "()Landroid/view/View;", "selectCoverView", "<init>", "(Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.crop.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ViewHolder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ImageView img;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final TextView durationText;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final View selectCoverView;

        public ViewHolder(@NotNull ImageView img, @NotNull TextView durationText, @NotNull View selectCoverView) {
            Intrinsics.checkNotNullParameter(img, "img");
            Intrinsics.checkNotNullParameter(durationText, "durationText");
            Intrinsics.checkNotNullParameter(selectCoverView, "selectCoverView");
            this.img = img;
            this.durationText = durationText;
            this.selectCoverView = selectCoverView;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final TextView getDurationText() {
            return this.durationText;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final ImageView getImg() {
            return this.img;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final View getSelectCoverView() {
            return this.selectCoverView;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewHolder)) {
                return false;
            }
            ViewHolder viewHolder = (ViewHolder) other;
            if (Intrinsics.areEqual(this.img, viewHolder.img) && Intrinsics.areEqual(this.durationText, viewHolder.durationText) && Intrinsics.areEqual(this.selectCoverView, viewHolder.selectCoverView)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.img.hashCode() * 31) + this.durationText.hashCode()) * 31) + this.selectCoverView.hashCode();
        }

        @NotNull
        public String toString() {
            return "ViewHolder(img=" + this.img + ", durationText=" + this.durationText + ", selectCoverView=" + this.selectCoverView + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/b$c", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.notifyDataSetChanged();
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            int i3;
            boolean z16 = false;
            if (bitmap != null) {
                i3 = bitmap.getWidth();
            } else {
                i3 = 0;
            }
            w53.b.a("wink_crop", "onThumbnailGenerated startTimeMs " + startTimeMs + ", bitmap width: " + i3 + ", tag " + tag);
            if (bitmap == null) {
                return;
            }
            b bVar = b.this;
            Iterator<T> it = bVar.d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mobileqq.wink.editor.crop.model.a aVar = (com.tencent.mobileqq.wink.editor.crop.model.a) it.next();
                if (Intrinsics.areEqual(aVar.getId(), tag)) {
                    bVar.thumbnailMap.put(aVar.getId(), bitmap);
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final b bVar2 = b.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.crop.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.c.c(b.this);
                    }
                });
            }
        }
    }

    public b(@NotNull Context context, @NotNull List<com.tencent.mobileqq.wink.editor.crop.model.a> videos) {
        int i3;
        ThumbAssetModel thumbAssetModel;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videos, "videos");
        this.videos = videos;
        this.thumbnailProvider = com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.mInflater = from;
        this.thumbnailMap = new HashMap<>();
        this.thumbnailGeneratedListener = new c();
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.wink.editor.crop.model.a aVar : videos) {
            MediaType type = aVar.getType();
            MediaType mediaType = MediaType.VIDEO;
            if (type == mediaType) {
                thumbAssetModel = new ThumbAssetModel(aVar.getThumbUrl(), mediaType.ordinal(), aVar.getDurationS() * 1000000);
            } else {
                thumbAssetModel = null;
            }
            if (thumbAssetModel != null) {
                arrayList.add(thumbAssetModel);
            }
        }
        ThumbnailProviderManager.f319211a.d(arrayList, "WinkCropVideoListAdapter");
        this.thumbnailProvider.b(this.thumbnailGeneratedListener);
        for (com.tencent.mobileqq.wink.editor.crop.model.a aVar2 : this.videos) {
            Bitmap bitmapByTime = this.thumbnailProvider.getBitmapByTime(aVar2.getSelectStart(), aVar2.getId(), aVar2.getThumbUrl());
            long selectStart = aVar2.getSelectStart();
            if (bitmapByTime != null) {
                i3 = bitmapByTime.getWidth();
            } else {
                i3 = 0;
            }
            w53.b.a("wink_crop", "get bitmap sync startTimeMs " + selectStart + ", bitmap width: " + i3 + ", tag " + aVar2.getId());
            this.thumbnailMap.put(aVar2.getId(), bitmapByTime);
        }
    }

    private final Bitmap c(String id5) {
        return this.thumbnailMap.get(id5);
    }

    @Override // android.widget.Adapter
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.wink.editor.crop.model.a getItem(int position) {
        return this.videos.get(position);
    }

    @NotNull
    public final List<com.tencent.mobileqq.wink.editor.crop.model.a> d() {
        return this.videos;
    }

    public final void e(int position) {
        Iterator<T> it = this.videos.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.wink.editor.crop.model.a) it.next()).g(false);
        }
        if (position >= 0 && position < this.videos.size()) {
            this.videos.get(position).g(true);
            notifyDataSetChanged();
        }
    }

    public final void f() {
        this.thumbnailProvider.c(this.thumbnailGeneratedListener);
        ThumbnailProviderManager.f319211a.r("WinkCropVideoListAdapter");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.videos.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        Pair pair;
        int i3;
        Unit unit;
        if (convertView != null) {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.crop.WinkCropVideoListAdapter.ViewHolder");
            pair = new Pair(convertView, (ViewHolder) tag);
        } else {
            View inflate = this.mInflater.inflate(R.layout.hcy, parent, false);
            View findViewById = inflate.findViewById(R.id.y8t);
            Intrinsics.checkNotNullExpressionValue(findViewById, "tempView.findViewById(R.id.iv_seg_cover)");
            View findViewById2 = inflate.findViewById(R.id.f111046k6);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "tempView.findViewById(R.id.tv_seg_time)");
            View findViewById3 = inflate.findViewById(R.id.y8u);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "tempView.findViewById(R.id.iv_select)");
            ViewHolder viewHolder = new ViewHolder((ImageView) findViewById, (TextView) findViewById2, findViewById3);
            inflate.setTag(viewHolder);
            pair = new Pair(inflate, viewHolder);
        }
        View view = (View) pair.component1();
        ViewHolder viewHolder2 = (ViewHolder) pair.component2();
        com.tencent.mobileqq.wink.editor.crop.model.a aVar = this.videos.get(position);
        View selectCoverView = viewHolder2.getSelectCoverView();
        if (aVar.getIsSelect()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        selectCoverView.setVisibility(i3);
        if (aVar.getType() == MediaType.VIDEO) {
            viewHolder2.getDurationText().setText(aVar.getDurationS() + ReportConstant.COSTREPORT_PREFIX);
            viewHolder2.getDurationText().setVisibility(0);
            Bitmap c16 = c(aVar.getId());
            if (c16 != null) {
                viewHolder2.getImg().setImageBitmap(c16);
                viewHolder2.getImg().setVisibility(0);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                viewHolder2.getImg().setVisibility(8);
            }
        } else {
            viewHolder2.getDurationText().setVisibility(8);
            viewHolder2.getImg().setVisibility(0);
            QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
            Option obtain = Option.obtain();
            obtain.setUrl(aVar.getThumbUrl());
            obtain.setTargetView(viewHolder2.getImg());
            obtain.setRequestHeight(e83.a.b(64));
            obtain.setRequestWidth(e83.a.b(64));
            g16.loadImage(obtain);
        }
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return view;
    }
}
