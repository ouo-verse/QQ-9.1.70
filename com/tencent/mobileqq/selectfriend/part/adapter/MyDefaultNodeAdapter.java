package com.tencent.mobileqq.selectfriend.part.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.selectmember.ResultRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0094\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0094\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/MyDefaultNodeAdapter;", "Lcom/tencent/mobileqq/selectfriend/part/adapter/MyBaseAdapter;", "context", "Landroid/content/Context;", "fsForwardData", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "Landroid/os/Bundle;", "resultRecord", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/content/Context;Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;Lcom/tencent/mobileqq/selectmember/ResultRecord;Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getResultRecord", "()Lcom/tencent/mobileqq/selectmember/ResultRecord;", "forwardRecentItemViewOnClick", "", "v", "Landroid/view/View;", "isSupportShow", "", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class MyDefaultNodeAdapter extends MyBaseAdapter {
    private final Drawable drawable;
    private final ResultRecord resultRecord;

    public MyDefaultNodeAdapter(Context context, FSForwardData<Bundle> fSForwardData, ResultRecord resultRecord, Drawable drawable) {
        super(context, fSForwardData);
        this.resultRecord = resultRecord;
        this.drawable = drawable;
    }

    @Override // com.tencent.mobileqq.selectfriend.part.adapter.MyBaseAdapter
    protected Drawable getDrawable() {
        return this.drawable;
    }

    @Override // com.tencent.mobileqq.selectfriend.part.adapter.MyBaseAdapter
    protected ResultRecord getResultRecord() {
        return this.resultRecord;
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public boolean isSupportShow() {
        return false;
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public void forwardRecentItemViewOnClick(View v3) {
    }
}
