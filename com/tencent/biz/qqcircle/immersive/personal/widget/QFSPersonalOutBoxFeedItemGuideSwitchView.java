package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* loaded from: classes4.dex */
public class QFSPersonalOutBoxFeedItemGuideSwitchView extends FrameLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    public ImageView f89299d;

    /* renamed from: e, reason: collision with root package name */
    public VasPagView f89300e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f89301f;

    public QFSPersonalOutBoxFeedItemGuideSwitchView(@NonNull Context context) {
        this(context, null);
    }

    private void c() {
        this.f89299d = (ImageView) findViewById(R.id.duw);
        VasPagView vasPagView = (VasPagView) findViewById(R.id.f219802h);
        this.f89300e = vasPagView;
        vasPagView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit d(PAGFile pAGFile, PAGView pAGView) {
        if (pAGView.isPlaying()) {
            return null;
        }
        if (pAGView.getComposition() == null && pAGFile != null) {
            pAGView.setComposition(pAGFile);
            pAGView.setRepeatCount(0);
        }
        pAGView.setProgress(0.0d);
        pAGView.flush();
        pAGView.play();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit e(PAGView pAGView) {
        pAGView.stop();
        return null;
    }

    public void f(final PAGFile pAGFile) {
        if (!this.f89300e.api().isBuild()) {
            this.f89300e.api().build();
        }
        this.f89300e.api().postAction(new Function1() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d16;
                d16 = QFSPersonalOutBoxFeedItemGuideSwitchView.d(PAGFile.this, (PAGView) obj);
                return d16;
            }
        });
    }

    public void g() {
        this.f89300e.api().postAction(new Function1() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e16;
                e16 = QFSPersonalOutBoxFeedItemGuideSwitchView.e((PAGView) obj);
                return e16;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        View.OnClickListener onClickListener = this.f89301f;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f89301f = onClickListener;
    }

    public QFSPersonalOutBoxFeedItemGuideSwitchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPersonalOutBoxFeedItemGuideSwitchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        View.inflate(context, R.layout.f168622g33, this);
        c();
    }
}
