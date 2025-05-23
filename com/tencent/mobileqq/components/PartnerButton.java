package com.tencent.mobileqq.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.Button;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/components/PartnerButton;", "Landroid/widget/Button;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/components/PartnerButton$a;", "buttonParams", "", "setButtonParams", "type", "a", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "params", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PartnerButton extends Button {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<String, PartnerButtonParam> params;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PartnerButton(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(String type) {
        PartnerButtonParam partnerButtonParam;
        Intrinsics.checkNotNullParameter(type, "type");
        ConcurrentHashMap<String, PartnerButtonParam> concurrentHashMap = this.params;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(type) || (partnerButtonParam = concurrentHashMap.get(type)) == null) {
            return;
        }
        partnerButtonParam.getIconDrawable().setBounds(0, 0, ViewUtils.dip2px(partnerButtonParam.getIconSize()), ViewUtils.dip2px(partnerButtonParam.getIconSize()));
        setCompoundDrawables(partnerButtonParam.getIconDrawable(), null, null, null);
        setBackground(partnerButtonParam.getBackGroundDrawable());
        setText(partnerButtonParam.getButtonText());
        setTextSize(partnerButtonParam.getTextSize());
    }

    public final void setButtonParams(ConcurrentHashMap<String, PartnerButtonParam> buttonParams) {
        Intrinsics.checkNotNullParameter(buttonParams, "buttonParams");
        this.params = buttonParams;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PartnerButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PartnerButton(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\t\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/components/PartnerButton$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "c", "()Landroid/graphics/drawable/Drawable;", "IconDrawable", "", "b", UserInfo.SEX_FEMALE, "d", "()F", "iconSize", "Landroid/text/SpannableStringBuilder;", "Landroid/text/SpannableStringBuilder;", "()Landroid/text/SpannableStringBuilder;", "buttonText", "e", "textSize", "backGroundDrawable", "<init>", "(Landroid/graphics/drawable/Drawable;FLandroid/text/SpannableStringBuilder;FLandroid/graphics/drawable/Drawable;)V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.components.PartnerButton$a, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class PartnerButtonParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final Drawable IconDrawable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float iconSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final SpannableStringBuilder buttonText;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final float textSize;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final Drawable backGroundDrawable;

        public PartnerButtonParam(Drawable IconDrawable, float f16, SpannableStringBuilder buttonText, float f17, Drawable backGroundDrawable) {
            Intrinsics.checkNotNullParameter(IconDrawable, "IconDrawable");
            Intrinsics.checkNotNullParameter(buttonText, "buttonText");
            Intrinsics.checkNotNullParameter(backGroundDrawable, "backGroundDrawable");
            this.IconDrawable = IconDrawable;
            this.iconSize = f16;
            this.buttonText = buttonText;
            this.textSize = f17;
            this.backGroundDrawable = backGroundDrawable;
        }

        /* renamed from: a, reason: from getter */
        public final Drawable getBackGroundDrawable() {
            return this.backGroundDrawable;
        }

        /* renamed from: b, reason: from getter */
        public final SpannableStringBuilder getButtonText() {
            return this.buttonText;
        }

        /* renamed from: c, reason: from getter */
        public final Drawable getIconDrawable() {
            return this.IconDrawable;
        }

        /* renamed from: d, reason: from getter */
        public final float getIconSize() {
            return this.iconSize;
        }

        /* renamed from: e, reason: from getter */
        public final float getTextSize() {
            return this.textSize;
        }

        public int hashCode() {
            return (((((((this.IconDrawable.hashCode() * 31) + Float.floatToIntBits(this.iconSize)) * 31) + this.buttonText.hashCode()) * 31) + Float.floatToIntBits(this.textSize)) * 31) + this.backGroundDrawable.hashCode();
        }

        public String toString() {
            Drawable drawable = this.IconDrawable;
            float f16 = this.iconSize;
            SpannableStringBuilder spannableStringBuilder = this.buttonText;
            return "PartnerButtonParam(IconDrawable=" + drawable + ", iconSize=" + f16 + ", buttonText=" + ((Object) spannableStringBuilder) + ", textSize=" + this.textSize + ", backGroundDrawable=" + this.backGroundDrawable + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PartnerButtonParam)) {
                return false;
            }
            PartnerButtonParam partnerButtonParam = (PartnerButtonParam) other;
            return Intrinsics.areEqual(this.IconDrawable, partnerButtonParam.IconDrawable) && Float.compare(this.iconSize, partnerButtonParam.iconSize) == 0 && Intrinsics.areEqual(this.buttonText, partnerButtonParam.buttonText) && Float.compare(this.textSize, partnerButtonParam.textSize) == 0 && Intrinsics.areEqual(this.backGroundDrawable, partnerButtonParam.backGroundDrawable);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartnerButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
