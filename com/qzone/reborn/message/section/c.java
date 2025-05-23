package com.qzone.reborn.message.section;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J*\u0010\u0019\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/qzone/reborn/message/section/c;", "Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgBaseSection;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "G", "", BdhLogUtil.LogTag.Tag_Conn, "H", "K", "M", "J", "L", "D", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "N", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "actionText", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "actionIcon", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends QZOldStylePassiveMsgBaseSection {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView actionText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView actionIcon;

    private final void C(BusinessFeedData feedData) {
        int color;
        String str;
        com.qzone.reborn.message.data.f fVar = com.qzone.reborn.message.data.f.f58260a;
        if (!fVar.c(feedData) && G(feedData)) {
            TextView textView = this.actionText;
            boolean z16 = false;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.actionText;
            if (textView2 != null) {
                if (fVar.m(feedData)) {
                    str = com.qzone.util.l.a(R.string.w_r);
                } else if (fVar.z(feedData)) {
                    str = com.qzone.util.l.a(R.string.w_t);
                } else {
                    CellLocalInfo localInfoV2 = feedData.getLocalInfoV2();
                    if (localInfoV2 != null && localInfoV2.canJoinAlbum) {
                        str = com.qzone.util.l.a(R.string.w_o);
                    } else {
                        CellLocalInfo localInfoV22 = feedData.getLocalInfoV2();
                        if (localInfoV22 != null && localInfoV22.joinedAlbum) {
                            str = com.qzone.util.l.a(R.string.w_q);
                        } else if (fVar.o(feedData)) {
                            str = com.qzone.util.l.a(R.string.get);
                        } else if (fVar.d(feedData)) {
                            str = com.qzone.util.l.a(R.string.ges);
                        } else {
                            str = "";
                        }
                    }
                }
                textView2.setText(str);
            }
            CellLocalInfo localInfoV23 = feedData.getLocalInfoV2();
            if (localInfoV23 != null && localInfoV23.joinedAlbum) {
                z16 = true;
            }
            if (z16) {
                color = ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_secondary, null);
            } else {
                color = ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_link, null);
            }
            TextView textView3 = this.actionText;
            if (textView3 != null) {
                textView3.setTextColor(color);
                return;
            }
            return;
        }
        TextView textView4 = this.actionText;
        if (textView4 == null) {
            return;
        }
        textView4.setVisibility(8);
    }

    private final void D(final BusinessFeedData feedData) {
        Drawable drawable;
        com.qzone.reborn.message.data.f fVar = com.qzone.reborn.message.data.f.f58260a;
        if (!fVar.c(feedData) && !G(feedData) && fVar.b(feedData) && (drawable = ResourcesCompat.getDrawable(p().getResources(), R.drawable.ax_, null)) != null) {
            ImageView imageView = this.actionIcon;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.actionIcon;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable);
            }
            ImageView imageView3 = this.actionIcon;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.F(c.this, feedData, view);
                    }
                });
                return;
            }
            return;
        }
        ImageView imageView4 = this.actionIcon;
        if (imageView4 != null) {
            imageView4.setOnClickListener(null);
        }
        ImageView imageView5 = this.actionIcon;
        if (imageView5 == null) {
            return;
        }
        imageView5.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(c this$0, BusinessFeedData feedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        dl.g w3 = this$0.w();
        if (w3 != null) {
            w3.V0(feedData);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean G(BusinessFeedData feedData) {
        com.qzone.reborn.message.data.f fVar = com.qzone.reborn.message.data.f.f58260a;
        if (fVar.m(feedData) || fVar.z(feedData)) {
            return true;
        }
        CellLocalInfo localInfoV2 = feedData.getLocalInfoV2();
        if (localInfoV2 != null && localInfoV2.canJoinAlbum) {
            return true;
        }
        CellLocalInfo localInfoV22 = feedData.getLocalInfoV2();
        return (localInfoV22 != null && localInfoV22.joinedAlbum) || fVar.o(feedData) || fVar.d(feedData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H() {
        BusinessFeedData businessFeedData = (BusinessFeedData) this.mData;
        boolean z16 = false;
        if (businessFeedData == null) {
            RFWLog.e("QZOldStylePassiveMsgActionSection", RFWLog.USR, "feedData is null");
            return;
        }
        com.qzone.reborn.message.data.f fVar = com.qzone.reborn.message.data.f.f58260a;
        if (fVar.m(businessFeedData)) {
            K(businessFeedData);
            return;
        }
        if (!fVar.o(businessFeedData) && !fVar.z(businessFeedData)) {
            CellLocalInfo localInfoV2 = businessFeedData.getLocalInfoV2();
            if (localInfoV2 != null && localInfoV2.canJoinAlbum) {
                z16 = true;
            }
            if (z16) {
                J(businessFeedData);
                return;
            } else {
                if (fVar.d(businessFeedData)) {
                    L(businessFeedData);
                    return;
                }
                return;
            }
        }
        M(businessFeedData);
    }

    private final void J(BusinessFeedData feedData) {
        dl.d dVar = (dl.d) q(dl.d.class);
        if (dVar != null) {
            dVar.s7(feedData, this.mPosition);
        }
    }

    private final void K(BusinessFeedData feedData) {
        User user = feedData.getUser();
        Long valueOf = user != null ? Long.valueOf(user.uin) : null;
        if (valueOf != null) {
            Long l3 = (valueOf.longValue() > 0L ? 1 : (valueOf.longValue() == 0L ? 0 : -1)) != 0 ? valueOf : null;
            if (l3 != null) {
                ho.i.z().l(p(), l3.longValue());
            }
        }
    }

    private final void L(BusinessFeedData feedData) {
        dl.g w3 = w();
        if (w3 != null) {
            w3.u6(feedData, this.mPosition);
        }
    }

    private final void M(BusinessFeedData feedData) {
        dl.g w3 = w();
        if (w3 != null) {
            w3.t9(feedData, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.actionText = (TextView) containerView.findViewById(R.id.nbn);
        this.actionIcon = (ImageView) containerView.findViewById(R.id.nbm);
        TextView textView = this.actionText;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.O(c.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nog};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onBindData(BusinessFeedData data, int position, List<Object> payload) {
        if (data != null) {
            C(data);
            D(data);
        }
    }
}
