package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i3) {
            return new BackStackState[i3];
        }
    };
    private static final String TAG = "FragmentManager";
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.mOps.size();
        this.mOps = new int[size * 5];
        if (backStackRecord.mAddToBackStack) {
            this.mFragmentWhos = new ArrayList<>(size);
            this.mOldMaxLifecycleStates = new int[size];
            this.mCurrentMaxLifecycleStates = new int[size];
            int i3 = 0;
            int i16 = 0;
            while (i3 < size) {
                FragmentTransaction.Op op5 = backStackRecord.mOps.get(i3);
                int i17 = i16 + 1;
                this.mOps[i16] = op5.mCmd;
                ArrayList<String> arrayList = this.mFragmentWhos;
                Fragment fragment = op5.mFragment;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.mOps;
                int i18 = i17 + 1;
                iArr[i17] = op5.mEnterAnim;
                int i19 = i18 + 1;
                iArr[i18] = op5.mExitAnim;
                int i26 = i19 + 1;
                iArr[i19] = op5.mPopEnterAnim;
                iArr[i26] = op5.mPopExitAnim;
                this.mOldMaxLifecycleStates[i3] = op5.mOldMaxState.ordinal();
                this.mCurrentMaxLifecycleStates[i3] = op5.mCurrentMaxState.ordinal();
                i3++;
                i16 = i26 + 1;
            }
            this.mTransition = backStackRecord.mTransition;
            this.mName = backStackRecord.mName;
            this.mIndex = backStackRecord.mIndex;
            this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
            this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
            this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
            this.mReorderingAllowed = backStackRecord.mReorderingAllowed;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        int i3 = 0;
        int i16 = 0;
        while (i3 < this.mOps.length) {
            FragmentTransaction.Op op5 = new FragmentTransaction.Op();
            int i17 = i3 + 1;
            op5.mCmd = this.mOps[i3];
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(TAG, "Instantiate " + backStackRecord + " op #" + i16 + " base fragment #" + this.mOps[i17]);
            }
            String str = this.mFragmentWhos.get(i16);
            if (str != null) {
                op5.mFragment = fragmentManager.findActiveFragment(str);
            } else {
                op5.mFragment = null;
            }
            op5.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i16]];
            op5.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i16]];
            int[] iArr = this.mOps;
            int i18 = i17 + 1;
            int i19 = iArr[i17];
            op5.mEnterAnim = i19;
            int i26 = i18 + 1;
            int i27 = iArr[i18];
            op5.mExitAnim = i27;
            int i28 = i26 + 1;
            int i29 = iArr[i26];
            op5.mPopEnterAnim = i29;
            int i36 = iArr[i28];
            op5.mPopExitAnim = i36;
            backStackRecord.mEnterAnim = i19;
            backStackRecord.mExitAnim = i27;
            backStackRecord.mPopEnterAnim = i29;
            backStackRecord.mPopExitAnim = i36;
            backStackRecord.addOp(op5);
            i16++;
            i3 = i28 + 1;
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mName = this.mName;
        backStackRecord.mIndex = this.mIndex;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
        backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
        backStackRecord.mReorderingAllowed = this.mReorderingAllowed;
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }
}
