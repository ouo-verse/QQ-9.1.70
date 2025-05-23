package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ag extends ReportDialog implements View.OnClickListener {
    protected final Context C;
    private ImageView D;
    protected View E;
    RelativeLayout F;
    private String G;
    private a H;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void onRetryClick();
    }

    public ag(@NonNull Context context, a aVar) {
        super(context, R.style.a5k);
        this.G = "none";
        setCanceledOnTouchOutside(false);
        this.C = context;
        this.H = aVar;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.i79, (ViewGroup) null);
        this.E = inflate;
        setContentView(inflate, new RelativeLayout.LayoutParams(ViewUtils.dip2px(140.0f), ViewUtils.dip2px(140.0f)));
        ImageView imageView = (ImageView) findViewById(R.id.dum);
        this.D = imageView;
        imageView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f123987i5);
        this.F = relativeLayout;
        relativeLayout.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.dum) {
            dismiss();
        } else if (view.getId() == R.id.f123987i5) {
            this.H.onRetryClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
