package com.tenpay.sdk.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.c;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.QwLog;
import com.tenpay.sdk.model.MarketModel;
import com.tenpay.sdk.model.PayTypeModel;
import com.tenpay.sdk.view.PayTypeCard;
import com.tenpay.util.Utils;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class BusinessPayTypeExpandableAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "BusinessPayTypeExpandableAdapter";
    private boolean isHasMarketPromotion;
    private OnItemClickListener itemClickListener;
    private Context mContext;
    private List<MarketModel> mMarketModels;
    private long mPayTypeMarketingFee;
    private List<PayTypeModel> mPayTypeModels;
    public String mPayTypeTitle;
    private int mProcessType;
    public String mPromotionTitle;
    private JSONArray mSelectPointListInfo;
    private JSONArray mSelectPromotionListInfo;
    private long mTotalMarketingFee;
    private String mUin;
    private int mLastSelectedPosition = 0;
    private boolean isFirstReport = true;

    /* loaded from: classes27.dex */
    public interface OnItemClickListener {
        void onPayTypeItemClick(PayTypeModel payTypeModel, long j3);

        void onPromotionItemClick(long j3);
    }

    public BusinessPayTypeExpandableAdapter(Context context, String str, List<MarketModel> list, List<PayTypeModel> list2, int i3) {
        this.mContext = context;
        this.mUin = str;
        this.mPayTypeModels = list2;
        this.mMarketModels = list;
        this.mProcessType = i3;
        if (list != null && list.size() > 0) {
            this.isHasMarketPromotion = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCheckState(int i3) {
        PayTypeModel payTypeModel;
        boolean z16;
        try {
            payTypeModel = this.mPayTypeModels.get(this.mLastSelectedPosition);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            payTypeModel = null;
        }
        for (int i16 = 0; i16 < this.mPayTypeModels.size(); i16++) {
            PayTypeModel payTypeModel2 = this.mPayTypeModels.get(i16);
            if (i16 == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            payTypeModel2.isCheck = z16;
            if (i16 == i3) {
                if (payTypeModel != null) {
                    QwLog.i("mPayTypeMarketingFee mLastModel : " + this.mPayTypeMarketingFee);
                    this.mPayTypeMarketingFee = this.mPayTypeMarketingFee + (payTypeModel2.promotion_fee - payTypeModel.promotion_fee);
                } else {
                    QwLog.i("mPayTypeMarketingFee : " + this.mPayTypeMarketingFee);
                    this.mPayTypeMarketingFee = this.mPayTypeMarketingFee + payTypeModel2.promotion_fee;
                }
            }
        }
    }

    public static JSONObject getMarketingInfo(MarketModel marketModel) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", marketModel.f386900id + "");
            jSONObject.put("fee", marketModel.fee + "");
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$getPayTypeView$0(String str, PayTypeCard payTypeCard, PayTypeModel payTypeModel, String str2) {
        if (!Utils.isEmpty(str2)) {
            str = str2;
        }
        String str3 = Utils.cutTextByPix(this.mContext, str, 130.0f, payTypeCard.getTitleTextView().getPaint()) + "-" + payTypeModel.title;
        payTypeModel.nick = str3;
        payTypeCard.setTitle(str3);
        return null;
    }

    private void showItemChecked(PayTypeCard payTypeCard, PayTypeModel payTypeModel) {
        if (payTypeModel.isCheck) {
            payTypeCard.setSelected(true);
        } else if (!"new_bind".equals(payTypeModel.pay_channel) && !"pfa_pay".equals(payTypeModel.pay_channel)) {
            payTypeCard.goneArrowAndCheck();
        }
    }

    public void computeCommMarketingFee(MarketModel marketModel) {
        boolean z16;
        String str = marketModel.group;
        if (str == null) {
            str = "";
        }
        marketModel.group = str;
        String[] split = str.split("\\|");
        if (marketModel.isCheck) {
            for (MarketModel marketModel2 : this.mMarketModels) {
                if (marketModel2.f386900id != marketModel.f386900id && !marketModel2.isPointModel && marketModel2.check_fixed == 0 && marketModel2.isCheck) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < split.length) {
                            if (split[i3].equals(marketModel2.f386900id + "")) {
                                z16 = false;
                                break;
                            }
                            i3++;
                        } else {
                            z16 = true;
                            break;
                        }
                    }
                    if (z16) {
                        this.mTotalMarketingFee -= marketModel2.fee;
                        marketModel2.isCheck = false;
                    }
                }
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        return 0L;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        if (i3 == 0) {
            if (this.isHasMarketPromotion) {
                return getPromotionView(i16, view, viewGroup);
            }
            return getPayTypeView(i16, view, viewGroup);
        }
        return getPayTypeView(i16, view, viewGroup);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        if (i3 == 0) {
            if (this.isHasMarketPromotion) {
                QwLog.i("groupPosition : " + i3 + "isHasPromotion : true");
                return this.mMarketModels.size();
            }
            QwLog.i("groupPosition : " + i3 + "isHasPromotion : false");
            return this.mPayTypeModels.size();
        }
        if (i3 == 1) {
            return this.mPayTypeModels.size();
        }
        return 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        int i3;
        List<PayTypeModel> list = this.mPayTypeModels;
        if (list != null && list.size() > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.isHasMarketPromotion) {
            return i3 + 1;
        }
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return 0L;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ad8, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.am9);
        if (i3 == 0) {
            if (this.isHasMarketPromotion) {
                textView.setText(this.mPromotionTitle);
                QwLog.i("getGroupView groupPosition : " + i3 + "isHasPromotion : " + this.mPromotionTitle);
            } else {
                textView.setText(this.mPayTypeTitle);
            }
        } else {
            textView.setText(this.mPayTypeTitle);
        }
        return inflate;
    }

    public View getPayTypeView(final int i3, View view, ViewGroup viewGroup) {
        boolean z16;
        boolean z17;
        QwLog.i("BusinessPayTypeAdapter --> getView");
        final PayTypeModel payTypeModel = this.mPayTypeModels.get(i3);
        final PayTypeCard payTypeCard = new PayTypeCard(this.mContext);
        payTypeCard.setTitleSingleLine();
        String str = payTypeModel.sub_title1;
        if ("spfa_pay".equals(payTypeModel.pay_channel)) {
            final String optString = payTypeModel.channel_info.optString("uin");
            Bundle bundle = new Bundle();
            bundle.putString(WadlProxyConsts.CHANNEL, "");
            bundle.putString("uin", optString);
            bundle.putString("group_id", "");
            if (TextUtils.isEmpty(payTypeModel.nick)) {
                QWalletNickNameServer.b(null, optString, new Function1() { // from class: com.tenpay.sdk.adapter.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda$getPayTypeView$0;
                        lambda$getPayTypeView$0 = BusinessPayTypeExpandableAdapter.this.lambda$getPayTypeView$0(optString, payTypeCard, payTypeModel, (String) obj);
                        return lambda$getPayTypeView$0;
                    }
                });
            }
            payTypeCard.setTitle(payTypeModel.nick);
            payTypeCard.setSubTitleColor(-16777216);
        } else if (!TextUtils.isEmpty(str)) {
            payTypeCard.setTitle(payTypeModel.title + str);
        } else {
            payTypeCard.setTitle(payTypeModel.title);
        }
        if ("balance".equals(payTypeModel.pay_channel)) {
            if (payTypeModel.disable != 0) {
                payTypeCard.setDisableLogoId(R.drawable.dvp);
            } else {
                payTypeCard.setLogoId(R.drawable.dvp);
            }
        } else if ("new_bind".equals(payTypeModel.pay_channel)) {
            payTypeCard.setLogoId(R.drawable.dvg);
            JSONObject jSONObject = payTypeModel.channel_info;
            if (jSONObject != null) {
                updatePayItem(payTypeCard, jSONObject.optString("redirect_url"), payTypeModel.channel_info.optString("url_title"));
            }
        } else if ("pfa_pay".equals(payTypeModel.pay_channel)) {
            String optString2 = payTypeModel.channel_info.optString("pfa_logo_id");
            if (payTypeModel.disable != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            payTypeCard.setLogoId(optString2, z17);
        } else {
            String optString3 = payTypeModel.channel_info.optString("image_id");
            if (payTypeModel.disable != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            payTypeCard.setLogoId(optString3, z16);
        }
        if (payTypeModel.disable == 0) {
            payTypeCard.setSubTitle(payTypeModel.sub_title2);
        } else {
            payTypeCard.setSubTitle(payTypeModel.disable_comment);
        }
        if (payTypeModel.disable == 0) {
            showItemChecked(payTypeCard, payTypeModel);
            payTypeCard.setEnabled(true);
            payTypeCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.adapter.BusinessPayTypeExpandableAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    EventCollector.getInstance().onViewClickedBefore(view2);
                    PayTypeModel payTypeModel2 = payTypeModel;
                    if (!payTypeModel2.isCheck || "new_bind".equals(payTypeModel2.pay_channel) || "pfa_pay".equals(payTypeModel.pay_channel)) {
                        QwLog.i("position : " + i3);
                        BusinessPayTypeExpandableAdapter.this.mPayTypeMarketingFee = 0L;
                        if (!"new_bind".equals(payTypeModel.pay_channel) && !"pfa_pay".equals(payTypeModel.pay_channel)) {
                            BusinessPayTypeExpandableAdapter.this.changeCheckState(i3);
                            BusinessPayTypeExpandableAdapter.this.notifyDataSetChanged();
                            BusinessPayTypeExpandableAdapter.this.mLastSelectedPosition = i3;
                        }
                        if (BusinessPayTypeExpandableAdapter.this.itemClickListener != null) {
                            OnItemClickListener onItemClickListener = BusinessPayTypeExpandableAdapter.this.itemClickListener;
                            PayTypeModel payTypeModel3 = payTypeModel;
                            BusinessPayTypeExpandableAdapter businessPayTypeExpandableAdapter = BusinessPayTypeExpandableAdapter.this;
                            long j3 = businessPayTypeExpandableAdapter.mTotalMarketingFee + BusinessPayTypeExpandableAdapter.this.mPayTypeMarketingFee;
                            businessPayTypeExpandableAdapter.mTotalMarketingFee = j3;
                            onItemClickListener.onPayTypeItemClick(payTypeModel3, j3);
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view2);
                }
            });
            if (payTypeModel.isHasPromotion && payTypeModel.isCheck && payTypeModel.promotion_fee > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("-");
                sb5.append(Utils.fen2Yuan(payTypeModel.promotion_fee + ""));
                sb5.append("\u5143");
                payTypeCard.setMarketingTitle(sb5.toString());
            }
            if (payTypeModel.isCheck && payTypeModel.highlight_flag != 0) {
                payTypeCard.setSubTitleColor(this.mContext.getResources().getColor(R.color.f157586tx));
            }
        } else {
            payTypeCard.setEnabled(false);
        }
        if (payTypeModel.disable != 0) {
            updatePayItem(payTypeCard, payTypeModel.disable_url, payTypeModel.disable_title);
        }
        return payTypeCard;
    }

    public JSONArray getPointListInfo() {
        if (this.isHasMarketPromotion) {
            this.mSelectPointListInfo = new JSONArray();
            Iterator<MarketModel> it = this.mMarketModels.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MarketModel next = it.next();
                if (next.isPointModel && next.isCheck) {
                    this.mSelectPointListInfo.mo162put(getMarketingInfo(next));
                    break;
                }
            }
            if (this.mSelectPointListInfo.length() > 0) {
                QwLog.i(this.mSelectPointListInfo.toString());
                return this.mSelectPointListInfo;
            }
            return null;
        }
        return null;
    }

    public JSONArray getPromotionListInfo() {
        if (this.isHasMarketPromotion) {
            this.mSelectPromotionListInfo = new JSONArray();
            for (MarketModel marketModel : this.mMarketModels) {
                if (!marketModel.isPointModel && marketModel.isCheck) {
                    this.mSelectPromotionListInfo.mo162put(getMarketingInfo(marketModel));
                }
            }
            if (this.mSelectPromotionListInfo.length() > 0) {
                QwLog.i(this.mSelectPromotionListInfo.toString());
                return this.mSelectPromotionListInfo;
            }
            return null;
        }
        return null;
    }

    public View getPromotionView(int i3, View view, ViewGroup viewGroup) {
        QwLog.i("BusinessMarketingAdapter --> getView");
        final MarketModel marketModel = this.mMarketModels.get(i3);
        PayTypeCard payTypeCard = new PayTypeCard(this.mContext);
        boolean z16 = false;
        payTypeCard.setLogoEnable(false);
        payTypeCard.setTitle(marketModel.show_msg);
        if (marketModel.isPointModel) {
            payTypeCard.setSubTitle(marketModel.balance_desc);
            if (marketModel.disable == 0) {
                z16 = true;
            }
            payTypeCard.setEnabled(z16);
        } else {
            payTypeCard.setEnabled(true);
            payTypeCard.setSubTitle(marketModel.comment);
        }
        payTypeCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.adapter.BusinessPayTypeExpandableAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                MarketModel marketModel2 = marketModel;
                if (marketModel2.isPointModel) {
                    if (marketModel2.disable == 0) {
                        if (BusinessPayTypeExpandableAdapter.this.isFirstReport) {
                            if (marketModel.recommend_flag == 1) {
                                c.c("discount.points.cancel", Integer.valueOf(BusinessPayTypeExpandableAdapter.this.mProcessType));
                            } else {
                                c.c("discount.points.choose", Integer.valueOf(BusinessPayTypeExpandableAdapter.this.mProcessType));
                            }
                            BusinessPayTypeExpandableAdapter.this.isFirstReport = false;
                        }
                        if (marketModel.isCheck) {
                            BusinessPayTypeExpandableAdapter.this.mTotalMarketingFee -= marketModel.fee;
                        } else {
                            BusinessPayTypeExpandableAdapter.this.mTotalMarketingFee += marketModel.fee;
                        }
                    }
                } else if (marketModel2.check_fixed != 0) {
                    QwLog.i("user can not cancle checked! ");
                    EventCollector.getInstance().onViewClicked(view2);
                } else if (marketModel2.isCheck) {
                    BusinessPayTypeExpandableAdapter.this.mTotalMarketingFee -= marketModel.fee;
                } else {
                    BusinessPayTypeExpandableAdapter.this.mTotalMarketingFee += marketModel.fee;
                }
                MarketModel marketModel3 = marketModel;
                marketModel3.isCheck = !marketModel3.isCheck;
                if (!marketModel3.isPointModel) {
                    BusinessPayTypeExpandableAdapter.this.computeCommMarketingFee(marketModel3);
                }
                BusinessPayTypeExpandableAdapter.this.notifyDataSetChanged();
                if (BusinessPayTypeExpandableAdapter.this.itemClickListener != null) {
                    BusinessPayTypeExpandableAdapter.this.itemClickListener.onPromotionItemClick(BusinessPayTypeExpandableAdapter.this.mTotalMarketingFee);
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        if (marketModel.isCheck) {
            if (marketModel.fee > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("-");
                sb5.append(Utils.fen2Yuan(marketModel.fee + ""));
                sb5.append("\u5143");
                payTypeCard.setMarketingTitle(sb5.toString());
            } else {
                payTypeCard.setMarketingTitle("");
            }
        }
        payTypeCard.setSelected(marketModel.isCheck);
        return payTypeCard;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        return false;
    }

    public void setDefaultTotalMarketingFee(long j3) {
        this.mTotalMarketingFee = j3;
    }

    public void setLastSelectedPosition(int i3) {
        this.mLastSelectedPosition = i3;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.itemClickListener = onItemClickListener;
    }

    public void updatePayItem(PayTypeCard payTypeCard, String str, String str2) {
        try {
            payTypeCard.setSubTitle(true, null, str2, str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }
}
