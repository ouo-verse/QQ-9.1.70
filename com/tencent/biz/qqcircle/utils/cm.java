package com.tencent.biz.qqcircle.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.widgets.QFSEDaxiaTipsDialog;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cm {
    public static void c(ImageView imageView, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (imageView != null && feedCloudMeta$StUser != null) {
            if (feedCloudMeta$StUser.is_e_da_xia.get()) {
                imageView.setImageDrawable(null);
                imageView.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int a16 = cx.a(60.0f);
                int a17 = cx.a(19.0f);
                if (layoutParams != null) {
                    layoutParams.width = a16;
                    layoutParams.height = a17;
                    imageView.setLayoutParams(layoutParams);
                }
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/edaxia/qvideo_edaxia_comment_tag.png").setRequestHeight(a17).setRequestWidth(a16).setTargetView(imageView));
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public static void d(Context context, ImageView imageView, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser != null && imageView != null) {
            if (feedCloudMeta$StUser.is_e_da_xia.get()) {
                imageView.setVisibility(8);
                QLog.d("QFSUserLabelBindUtils", 1, "[bindLabel] isEDaxia, hide other label.");
                return;
            }
            int i3 = feedCloudMeta$StUser.get().label.get();
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        imageView.setVisibility(8);
                        return;
                    } else {
                        imageView.setVisibility(0);
                        imageView.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(imageView.getContext(), R.drawable.qvideo_skin_comment_tag_tiefen));
                        return;
                    }
                }
                imageView.setVisibility(0);
                imageView.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(imageView.getContext(), R.drawable.qvideo_skin_comment_tag_fanpaidaren));
                return;
            }
            imageView.setVisibility(0);
            imageView.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(imageView.getContext(), R.drawable.qvideo_skin_comment_tag_gengwang_richtext));
            return;
        }
        QLog.d("QFSUserLabelBindUtils", 1, "[bindLabel] poster or labelImageView is null.");
    }

    public static void g(Context context, View view) {
        if (bz.r()) {
            context = ASEngineUtils.getHostContext(context);
        }
        if (context == null) {
            QLog.d("QFSUserLabelBindUtils", 1, "[showEDaxiaTipsDialog] context is null.");
            return;
        }
        if (context instanceof Activity) {
            Intent intent = ((Activity) context).getIntent();
            int i3 = -1;
            if (intent != null) {
                i3 = intent.getIntExtra("orientation_type_flag", -1);
            }
            if (i3 == 0 || i3 == 8) {
                QLog.d("QFSUserLabelBindUtils", 1, "[showEDaxiaTipsDialog] full screen, return.");
                return;
            }
        }
        QFSEDaxiaTipsDialog qFSEDaxiaTipsDialog = new QFSEDaxiaTipsDialog(context);
        qFSEDaxiaTipsDialog.Y(view);
        qFSEDaxiaTipsDialog.show();
        QLog.d("QFSUserLabelBindUtils", 1, "[showEDaxiaTipsDialog] show dialog.");
    }

    public static void h(Context context) {
        if (bz.r()) {
            context = ASEngineUtils.getHostContext(context);
        }
        Context context2 = context;
        if (context2 == null) {
            return;
        }
        DialogUtil.createCustomDialog(context2, 230, context2.getResources().getString(R.string.f183443j7), context2.getResources().getString(R.string.f183453j8), (String) null, h.a(R.string.f1910643s), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.utils.ck
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    public static void i(Context context) {
        DialogUtil.createCustomDialog(context, 230, context.getResources().getString(R.string.f183613jn), context.getResources().getString(R.string.f183623jo), (String) null, h.a(R.string.f1910643s), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.utils.cl
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }, (DialogInterface.OnClickListener) null).show();
    }
}
