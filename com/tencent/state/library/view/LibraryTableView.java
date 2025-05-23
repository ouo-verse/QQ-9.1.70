package com.tencent.state.library.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.data.Text;
import com.tencent.state.library.holder.ViewHolderExtensionsKt;
import com.tencent.state.map.Location;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.databinding.VasSquareLibraryTableViewBinding;
import com.tencent.state.template.data.Decorator;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.view.SquareImageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010 \u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010 \u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%J\u0016\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u0018\u0010,\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020-2\u0006\u0010$\u001a\u00020%H\u0002J\u0016\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000RL\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001d\u00a8\u00064"}, d2 = {"Lcom/tencent/state/library/view/LibraryTableView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryTableViewBinding;", "clickListener", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "type", "", "getClickListener", "()Lkotlin/jvm/functions/Function2;", "setClickListener", "(Lkotlin/jvm/functions/Function2;)V", "clickView", "getClickView", "()Landroid/view/View;", "decorator", "Landroid/widget/ImageView;", "getDecorator", "()Landroid/widget/ImageView;", "reporter", "Lcom/tencent/state/square/IReporter;", "table", "getTable", "bindBrand", "Lcom/tencent/state/template/data/Table;", "scale", "", "bindBrandOrExpect", "bindTableImage", "url", "", "size", "Landroid/util/Size;", "layoutDecorator", "Lcom/tencent/state/template/data/Decorator;", "updateHitAreaLocation", "itemLocation", "Landroid/graphics/Rect;", "avatarLocation", "Lcom/tencent/state/map/Location;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryTableView extends RelativeLayout {
    public static final int CLICK_DECORATOR = 1;
    public static final int CLICK_HIT_AREA = 0;
    private static final String TAG = "LibraryTableView";
    private final VasSquareLibraryTableViewBinding binding;
    private Function2<? super View, ? super Integer, Unit> clickListener;
    private final IReporter reporter;

    public LibraryTableView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void layoutDecorator(Decorator decorator, final float scale) {
        final Location location = decorator.getLocation();
        SquareImageView squareImageView = this.binding.decorator;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.decorator");
        ViewExtensionsKt.updateLayoutParams(squareImageView, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.library.view.LibraryTableView$layoutDecorator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.leftMargin = (int) (Location.this.getX() * scale);
                receiver.topMargin = (int) ((-Location.this.getY()) * scale);
                receiver.width = (int) (Location.this.getWidth() * scale);
                receiver.height = (int) (Location.this.getHeight() * scale);
            }
        });
        SquareImageView squareImageView2 = this.binding.decorator;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.decorator");
        ViewExtensionsKt.setUri(squareImageView2, decorator.getImage().getUrl());
    }

    public final void bindBrand(Table table, float scale) {
        Decorator brand;
        Intrinsics.checkNotNullParameter(table, "table");
        Table neighbor = table.getNeighbor();
        User user = neighbor != null ? neighbor.getUser() : null;
        if (Intrinsics.areEqual(user != null ? Boolean.valueOf(user.isMe()) : null, Boolean.TRUE)) {
            brand = table.getExpectWithShare();
        } else {
            brand = table.getBrand();
        }
        if (brand != null) {
            SquareImageView squareImageView = this.binding.decorator;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.decorator");
            squareImageView.setSelected(Intrinsics.areEqual(brand, table.getExpectWithEdit()));
            layoutDecorator(brand, scale);
            TextView textView = this.binding.decoratorText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.decoratorText");
            textView.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bindBrandOrExpect(Table table, final float scale) {
        Decorator expect;
        boolean z16;
        boolean isBlank;
        String str;
        Map<String, Object> mutableMapOf;
        SitDownInfo sitDown;
        Intrinsics.checkNotNullParameter(table, "table");
        Table neighbor = table.getNeighbor();
        User user = neighbor != null ? neighbor.getUser() : null;
        CommonTagInfo subTag = (user == null || (sitDown = user.getSitDown()) == null) ? null : sitDown.getSubTag();
        if (subTag == null) {
            expect = table.getBrand();
        } else {
            if (user.isMe()) {
                String id5 = subTag.getId();
                if (id5 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(id5);
                    if (!isBlank) {
                        z16 = false;
                        if (z16) {
                            expect = table.getExpectWithEdit();
                        }
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
            if (user.isMe()) {
                expect = table.getExpectWithShare();
            } else {
                expect = table.getExpect();
            }
        }
        if (expect != null) {
            if (Intrinsics.areEqual(expect, table.getExpectWithEdit())) {
                SquareImageView squareImageView = this.binding.decorator;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.decorator");
                squareImageView.setSelected(true);
                IReporter iReporter = this.reporter;
                if (iReporter != null) {
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"));
                    iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_EDIT_DESK_MATE_EXPECT, mutableMapOf);
                }
            } else {
                SquareImageView squareImageView2 = this.binding.decorator;
                Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.decorator");
                squareImageView2.setSelected(false);
            }
            final Location location = expect.getLocation();
            layoutDecorator(expect, scale);
            if (subTag == null || (str = subTag.getText()) == null) {
                str = "";
            }
            if (user != null && !user.isMe()) {
                if (str.length() == 0) {
                    str = "\u968f\u7f18\u5c31\u597d";
                }
            }
            TextView textView = this.binding.decoratorText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.decoratorText");
            textView.setText(str);
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("bindBrandOrExpect: ");
            sb5.append(user != null ? user.getSitDown() : null);
            squareLog.i(TAG, sb5.toString());
            final Text text = expect.getText();
            if (text != null) {
                this.binding.decoratorText.setTextSize(0, text.getTextSize() * scale);
                this.binding.decoratorText.setTextColor(text.textColor(Color.parseColor("#774B2E")));
                TextView textView2 = this.binding.decoratorText;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.decoratorText");
                ViewExtensionsKt.updateLayoutParams(textView2, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.library.view.LibraryTableView$bindBrandOrExpect$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                        invoke2(layoutParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FrameLayout.LayoutParams receiver) {
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        receiver.leftMargin = (int) ((Location.this.getX() + text.getLocation().x) * scale);
                        receiver.topMargin = (int) (((-Location.this.getY()) - text.getLocation().y) * scale);
                    }
                });
            }
        }
    }

    public final void bindTableImage(String url, final Size size) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(size, "size");
        SquareImageView squareImageView = this.binding.table;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.table");
        ViewExtensionsKt.updateLayoutParams(squareImageView, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.library.view.LibraryTableView$bindTableImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RelativeLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = size.getWidth();
                receiver.height = size.getHeight();
            }
        });
        SquareImageView squareImageView2 = this.binding.table;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.table");
        ViewExtensionsKt.setUri(squareImageView2, url);
    }

    public final Function2<View, Integer, Unit> getClickListener() {
        return this.clickListener;
    }

    public final View getClickView() {
        View view = this.binding.hitArea;
        Intrinsics.checkNotNullExpressionValue(view, "binding.hitArea");
        return view;
    }

    public final ImageView getDecorator() {
        SquareImageView squareImageView = this.binding.decorator;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.decorator");
        return squareImageView;
    }

    public final ImageView getTable() {
        SquareImageView squareImageView = this.binding.table;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.table");
        return squareImageView;
    }

    public final void setClickListener(Function2<? super View, ? super Integer, Unit> function2) {
        this.clickListener = function2;
    }

    public final void updateHitAreaLocation(Rect itemLocation, Location avatarLocation) {
        Intrinsics.checkNotNullParameter(itemLocation, "itemLocation");
        Intrinsics.checkNotNullParameter(avatarLocation, "avatarLocation");
        View view = this.binding.hitArea;
        Intrinsics.checkNotNullExpressionValue(view, "binding.hitArea");
        ViewHolderExtensionsKt.adjustHitAreaLocation(view, itemLocation, avatarLocation);
    }

    public LibraryTableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LibraryTableView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryTableView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareLibraryTableViewBinding inflate = VasSquareLibraryTableViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibraryTableVie\u2026ater.from(context), this)");
        this.binding = inflate;
        this.reporter = Square.INSTANCE.getConfig().getReporter();
        inflate.hitArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.view.LibraryTableView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                Function2<View, Integer, Unit> clickListener = LibraryTableView.this.getClickListener();
                if (clickListener != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    clickListener.invoke(it, 0);
                }
            }
        });
        inflate.decorator.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.view.LibraryTableView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IReporter iReporter;
                Map<String, Object> mutableMapOf;
                Function2<View, Integer, Unit> clickListener = LibraryTableView.this.getClickListener();
                if (clickListener != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    clickListener.invoke(it, 1);
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!it.isSelected() || (iReporter = LibraryTableView.this.reporter) == null) {
                    return;
                }
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"));
                iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_EDIT_DESK_MATE_EXPECT, mutableMapOf);
            }
        });
    }

    public static /* synthetic */ void bindBrand$default(LibraryTableView libraryTableView, Table table, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 1.0f;
        }
        libraryTableView.bindBrand(table, f16);
    }

    public static /* synthetic */ void bindBrandOrExpect$default(LibraryTableView libraryTableView, Table table, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 1.0f;
        }
        libraryTableView.bindBrandOrExpect(table, f16);
    }
}
