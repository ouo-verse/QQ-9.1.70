package com.tenpay.idverify.hint;

import android.content.Intent;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.idverify.IdVerifyCommonHintVC;
import com.tenpay.idverify.hint.IdVerifyHintFragment;
import com.tenpay.sdk.util.WalletGateData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyFinishProcessor;", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment$IdVerifyHintProcessor;", "fragment", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment;", "(Lcom/tenpay/idverify/hint/IdVerifyHintFragment;)V", "getFragment", "()Lcom/tenpay/idverify/hint/IdVerifyHintFragment;", "setVCData", "", "vc", "Lcom/tenpay/idverify/IdVerifyCommonHintVC;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyFinishProcessor implements IdVerifyHintFragment.IdVerifyHintProcessor {

    @NotNull
    public static final String KEY_AUTH_BUTTON = "auth_button";

    @NotNull
    public static final String KEY_AUTH_COMMENT = "auth_comment";

    @NotNull
    public static final String KEY_AUTH_TIP = "auth_tip";

    @NotNull
    public static final String KEY_EXIT_AFTER_CONFIRM = "exit_after_confirm";

    @NotNull
    private final IdVerifyHintFragment fragment;

    public IdVerifyFinishProcessor(@NotNull IdVerifyHintFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setVCData$lambda$0(IdVerifyFinishProcessor this$0, Ref.ObjectRef authComment, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(authComment, "$authComment");
        this$0.fragment.setRetCodeMsgAndGetBundle(0, (String) authComment.element);
        if (z16) {
            this$0.fragment.exitCurrentProcess();
        } else {
            this$0.fragment.finish();
        }
        WalletGateData.getInstance().clear();
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final IdVerifyHintFragment getFragment() {
        return this.fragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [T, java.lang.String] */
    @Override // com.tenpay.idverify.hint.IdVerifyHintFragment.IdVerifyHintProcessor
    public void setVCData(@NotNull IdVerifyCommonHintVC vc5) {
        T t16;
        String str;
        String str2;
        boolean z16;
        Intrinsics.checkNotNullParameter(vc5, "vc");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intent intent = this.fragment.getIntent();
        if (intent != null) {
            t16 = intent.getStringExtra(KEY_AUTH_COMMENT);
        } else {
            t16 = 0;
        }
        objectRef.element = t16;
        Intent intent2 = this.fragment.getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra(KEY_AUTH_TIP);
        } else {
            str = null;
        }
        Intent intent3 = this.fragment.getIntent();
        if (intent3 != null) {
            str2 = intent3.getStringExtra(KEY_AUTH_BUTTON);
        } else {
            str2 = null;
        }
        CharSequence charSequence = (CharSequence) objectRef.element;
        boolean z17 = false;
        final boolean z18 = true;
        if (charSequence != null && charSequence.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            objectRef.element = this.fragment.getResources().getString(R.string.f2188064p);
        }
        if (str2 == null || str2.length() == 0) {
            z17 = true;
        }
        if (z17) {
            str2 = vc5.resources().getString(R.string.e5o);
        }
        String str3 = str2;
        Intent intent4 = this.fragment.getIntent();
        if (intent4 != null) {
            z18 = intent4.getBooleanExtra(KEY_EXIT_AFTER_CONFIRM, true);
        }
        IdVerifyCommonHintVC.setData$default(vc5, ResourcesCompat.getDrawable(vc5.resources(), R.drawable.olc, null), (String) objectRef.element, str, str3, new View.OnClickListener() { // from class: com.tenpay.idverify.hint.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IdVerifyFinishProcessor.setVCData$lambda$0(IdVerifyFinishProcessor.this, objectRef, z18, view);
            }
        }, null, null, 96, null);
    }
}
