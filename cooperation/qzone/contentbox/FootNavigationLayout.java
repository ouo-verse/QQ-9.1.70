package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$MenuItem;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.contentbox.model.BottomItem;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import fo.b;
import fo.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class FootNavigationLayout extends LinearLayout {
    private static final int ACTION_TYPE = 7;
    private static final int MAX_ITEM = 3;
    private static final int[] SUB_ACTION_TYPE = {4, 5, 6};
    private ImageView[] arrows;
    private View[] dividers;
    private ViewGroup[] items;
    private ImageView[] mEntranceIcon;
    private TextView[] texts;

    public FootNavigationLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.f167307cm1, this);
        this.items = new ViewGroup[]{(ViewGroup) findViewById(R.id.exq), (ViewGroup) findViewById(R.id.nfi), (ViewGroup) findViewById(R.id.ngw)};
        this.mEntranceIcon = new ImageView[]{(ImageView) findViewById(R.id.exp), (ImageView) findViewById(R.id.nfh), (ImageView) findViewById(R.id.ngv)};
        this.arrows = new ImageView[]{(ImageView) findViewById(R.id.exv), (ImageView) findViewById(R.id.nfj), (ImageView) findViewById(R.id.ngx)};
        this.texts = new TextView[]{(TextView) findViewById(R.id.f56), (TextView) findViewById(R.id.nfk), (TextView) findViewById(R.id.ngy)};
        this.dividers = new View[]{null, findViewById(R.id.f20438d), findViewById(R.id.f20448e)};
    }

    public void setArrowVisible(int i3) {
        for (ImageView imageView : this.arrows) {
            if (imageView != null) {
                imageView.setVisibility(i3);
            }
        }
    }

    public void updateData(ArrayList<BottomItem> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        for (final int i3 = 0; i3 < 3; i3++) {
            ViewGroup viewGroup = this.items[i3];
            TextView textView = this.texts[i3];
            View view = this.dividers[i3];
            if (i3 >= arrayList.size()) {
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                }
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                final BottomItem bottomItem = arrayList.get(i3);
                if (bottomItem == null || TextUtils.isEmpty(bottomItem.content) || TextUtils.isEmpty(bottomItem.content.trim())) {
                    if (viewGroup != null) {
                        viewGroup.setVisibility(8);
                    }
                    if (view != null) {
                        view.setVisibility(8);
                    }
                } else {
                    if (viewGroup != null) {
                        viewGroup.setVisibility(0);
                        if (textView != null) {
                            textView.setText(bottomItem.content);
                        }
                        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: cooperation.qzone.contentbox.FootNavigationLayout.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                EventCollector.getInstance().onViewClickedBefore(view2);
                                ax c16 = bi.c(((BaseActivity) FootNavigationLayout.this.getContext()).app, FootNavigationLayout.this.getContext(), bottomItem.url);
                                if (c16 != null) {
                                    c16.b();
                                } else {
                                    Intent intent = new Intent(FootNavigationLayout.this.getContext(), (Class<?>) QQBrowserActivity.class);
                                    intent.putExtra("url", bottomItem.url);
                                    intent.putExtra("fromQZone", true);
                                    QZoneHelper.addSource(intent);
                                    FootNavigationLayout.this.getContext().startActivity(intent);
                                }
                                LpReportManager.getInstance().reportToDC02880(new LpReportInfo_dc02880(7, FootNavigationLayout.SUB_ACTION_TYPE[i3]), false, true);
                                EventCollector.getInstance().onViewClicked(view2);
                            }
                        });
                    }
                    if (view != null) {
                        view.setVisibility(0);
                    }
                }
            }
        }
    }

    public FootNavigationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setNightMode(boolean z16) {
        int i3 = 0;
        if (z16) {
            ImageView[] imageViewArr = this.arrows;
            int length = imageViewArr.length;
            while (i3 < length) {
                ImageView imageView = imageViewArr[i3];
                if (imageView != null) {
                    imageView.setBackgroundResource(R.drawable.dfs);
                }
                i3++;
            }
            return;
        }
        ImageView[] imageViewArr2 = this.arrows;
        int length2 = imageViewArr2.length;
        while (i3 < length2) {
            ImageView imageView2 = imageViewArr2[i3];
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.dfr);
            }
            i3++;
        }
    }

    public FootNavigationLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }

    private void setEntranceIconDrawable(ImageView imageView, int i3) {
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        if (i3 == 1) {
            imageView.setImageResource(R.drawable.qui_qq_zone);
        } else if (i3 == 2) {
            imageView.setImageResource(R.drawable.qui_intimates_space);
        } else {
            imageView.setVisibility(8);
        }
    }

    private void dtReport(ViewGroup viewGroup, QZoneOfficialAccountBase$MenuItem qZoneOfficialAccountBase$MenuItem) {
        if (viewGroup == null || qZoneOfficialAccountBase$MenuItem == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, Integer.valueOf(qZoneOfficialAccountBase$MenuItem.menu_type.get()));
        c.o(viewGroup, "em_bas_chum_space_entry", new b().i("menuType=" + qZoneOfficialAccountBase$MenuItem.menu_type.get()).l(hashMap));
    }

    public void updateData(List<QZoneOfficialAccountBase$MenuItem> list) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            ViewGroup viewGroup = this.items[i3];
            TextView textView = this.texts[i3];
            View view = this.dividers[i3];
            ImageView imageView = this.mEntranceIcon[i3];
            if (i3 >= list.size()) {
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                }
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                final QZoneOfficialAccountBase$MenuItem qZoneOfficialAccountBase$MenuItem = list.get(i3);
                if (qZoneOfficialAccountBase$MenuItem == null || qZoneOfficialAccountBase$MenuItem.menu_type.get() == 0 || TextUtils.isEmpty(qZoneOfficialAccountBase$MenuItem.caption.get()) || TextUtils.isEmpty(qZoneOfficialAccountBase$MenuItem.jump_url.get().trim())) {
                    if (viewGroup != null) {
                        viewGroup.setVisibility(8);
                    }
                    if (view != null) {
                        view.setVisibility(8);
                    }
                } else {
                    if (viewGroup != null) {
                        viewGroup.setVisibility(0);
                        if (textView != null) {
                            textView.setText(qZoneOfficialAccountBase$MenuItem.caption.get());
                        }
                        setEntranceIconDrawable(imageView, qZoneOfficialAccountBase$MenuItem.menu_type.get());
                        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: cooperation.qzone.contentbox.FootNavigationLayout.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                EventCollector.getInstance().onViewClickedBefore(view2);
                                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                if (peekAppRuntime instanceof QQAppInterface) {
                                    ax c16 = bi.c((QQAppInterface) peekAppRuntime, FootNavigationLayout.this.getContext(), qZoneOfficialAccountBase$MenuItem.jump_url.get());
                                    if (c16 != null) {
                                        c16.b();
                                    } else {
                                        Intent intent = new Intent(FootNavigationLayout.this.getContext(), (Class<?>) QQBrowserActivity.class);
                                        intent.putExtra("url", qZoneOfficialAccountBase$MenuItem.jump_url.get());
                                        intent.putExtra("fromQZone", true);
                                        QZoneHelper.addSource(intent);
                                        FootNavigationLayout.this.getContext().startActivity(intent);
                                    }
                                    LpReportManager.getInstance().reportToDC02880(new LpReportInfo_dc02880(16, 1), false, false);
                                }
                                EventCollector.getInstance().onViewClicked(view2);
                            }
                        });
                    }
                    if (view != null) {
                        view.setVisibility(0);
                    }
                    dtReport(viewGroup, qZoneOfficialAccountBase$MenuItem);
                }
            }
        }
    }
}
