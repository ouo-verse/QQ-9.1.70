package com.qzone.reborn.feedx.widget.entrance;

import android.content.Context;
import com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u001f\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxTopEntranceViewFactory;", "", "Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxTopEntranceViewFactory$EntranceType;", "b", "", "viewType", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxBaseEntranceView;", "a", "(Ljava/lang/Integer;Landroid/content/Context;)Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxBaseEntranceView;", "<init>", "()V", "EntranceType", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxTopEntranceViewFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final QZoneFeedxTopEntranceViewFactory f56058a = new QZoneFeedxTopEntranceViewFactory();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxTopEntranceViewFactory$EntranceType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "MOMENT", "INTIMATE", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public enum EntranceType {
        MOMENT(1),
        INTIMATE(2);

        private final int type;

        EntranceType(int i3) {
            this.type = i3;
        }

        public final int getType() {
            return this.type;
        }
    }

    QZoneFeedxTopEntranceViewFactory() {
    }

    public final QZoneFeedxBaseEntranceView a(Integer viewType, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int type = EntranceType.INTIMATE.getType();
        if (viewType != null && viewType.intValue() == type) {
            return new QZoneFeedxTopIntimateEntranceView(context);
        }
        return new QZoneFeedxTopMomentEntranceView(context);
    }

    public final EntranceType b() {
        if (QZoneIntimateEntranceManager.v()) {
            return EntranceType.INTIMATE;
        }
        return EntranceType.MOMENT;
    }
}
