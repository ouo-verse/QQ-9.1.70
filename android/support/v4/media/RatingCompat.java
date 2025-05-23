package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int i3) {
            return new RatingCompat[i3];
        }
    };
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    /* compiled from: P */
    @RequiresApi(19)
    /* loaded from: classes.dex */
    private static class Api19Impl {
        Api19Impl() {
        }

        @DoNotInline
        static float getPercentRating(Rating rating) {
            return rating.getPercentRating();
        }

        @DoNotInline
        static int getRatingStyle(Rating rating) {
            return rating.getRatingStyle();
        }

        @DoNotInline
        static float getStarRating(Rating rating) {
            return rating.getStarRating();
        }

        @DoNotInline
        static boolean hasHeart(Rating rating) {
            return rating.hasHeart();
        }

        @DoNotInline
        static boolean isRated(Rating rating) {
            return rating.isRated();
        }

        @DoNotInline
        static boolean isThumbUp(Rating rating) {
            return rating.isThumbUp();
        }

        @DoNotInline
        static Rating newHeartRating(boolean z16) {
            return Rating.newHeartRating(z16);
        }

        @DoNotInline
        static Rating newPercentageRating(float f16) {
            return Rating.newPercentageRating(f16);
        }

        @DoNotInline
        static Rating newStarRating(int i3, float f16) {
            return Rating.newStarRating(i3, f16);
        }

        @DoNotInline
        static Rating newThumbRating(boolean z16) {
            return Rating.newThumbRating(z16);
        }

        @DoNotInline
        static Rating newUnratedRating(int i3) {
            return Rating.newUnratedRating(i3);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface StarStyle {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Style {
    }

    RatingCompat(int i3, float f16) {
        this.mRatingStyle = i3;
        this.mRatingValue = f16;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int ratingStyle = Api19Impl.getRatingStyle(rating);
            if (Api19Impl.isRated(rating)) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompat = newHeartRating(Api19Impl.hasHeart(rating));
                        break;
                    case 2:
                        ratingCompat = newThumbRating(Api19Impl.isThumbUp(rating));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = newStarRating(ratingStyle, Api19Impl.getStarRating(rating));
                        break;
                    case 6:
                        ratingCompat = newPercentageRating(Api19Impl.getPercentRating(rating));
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompat = newUnratedRating(ratingStyle);
            }
            ratingCompat.mRatingObj = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat newHeartRating(boolean z16) {
        float f16;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        return new RatingCompat(1, f16);
    }

    public static RatingCompat newPercentageRating(float f16) {
        if (f16 >= 0.0f && f16 <= 100.0f) {
            return new RatingCompat(6, f16);
        }
        Log.e(TAG, "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat newStarRating(int i3, float f16) {
        float f17;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    Log.e(TAG, "Invalid rating style (" + i3 + ") for a star rating");
                    return null;
                }
                f17 = 5.0f;
            } else {
                f17 = 4.0f;
            }
        } else {
            f17 = 3.0f;
        }
        if (f16 >= 0.0f && f16 <= f17) {
            return new RatingCompat(i3, f16);
        }
        Log.e(TAG, "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat newThumbRating(boolean z16) {
        float f16;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        return new RatingCompat(2, f16);
    }

    public static RatingCompat newUnratedRating(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i3, -1.0f);
            default:
                return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    public float getPercentRating() {
        if (this.mRatingStyle == 6 && isRated()) {
            return this.mRatingValue;
        }
        return -1.0f;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000c. Please report as an issue. */
    public Object getRating() {
        if (this.mRatingObj == null) {
            if (isRated()) {
                int i3 = this.mRatingStyle;
                switch (i3) {
                    case 1:
                        this.mRatingObj = Api19Impl.newHeartRating(hasHeart());
                        break;
                    case 2:
                        this.mRatingObj = Api19Impl.newThumbRating(isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.mRatingObj = Api19Impl.newStarRating(i3, getStarRating());
                        break;
                    case 6:
                        this.mRatingObj = Api19Impl.newPercentageRating(getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                this.mRatingObj = Api19Impl.newUnratedRating(this.mRatingStyle);
            }
        }
        return this.mRatingObj;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        int i3 = this.mRatingStyle;
        if ((i3 == 3 || i3 == 4 || i3 == 5) && isRated()) {
            return this.mRatingValue;
        }
        return -1.0f;
    }

    public boolean hasHeart() {
        if (this.mRatingStyle != 1 || this.mRatingValue != 1.0f) {
            return false;
        }
        return true;
    }

    public boolean isRated() {
        if (this.mRatingValue >= 0.0f) {
            return true;
        }
        return false;
    }

    public boolean isThumbUp() {
        if (this.mRatingStyle != 2 || this.mRatingValue != 1.0f) {
            return false;
        }
        return true;
    }

    public String toString() {
        String valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Rating:style=");
        sb5.append(this.mRatingStyle);
        sb5.append(" rating=");
        float f16 = this.mRatingValue;
        if (f16 < 0.0f) {
            valueOf = "unrated";
        } else {
            valueOf = String.valueOf(f16);
        }
        sb5.append(valueOf);
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }
}
